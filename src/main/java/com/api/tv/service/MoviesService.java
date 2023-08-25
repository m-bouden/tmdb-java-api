package com.api.tv.service;

import com.api.tv.dto.MovieDto;
import com.api.tv.model.*;
import com.api.tv.repository.MovieRepository;
import com.api.tv.tools.GenericApiCall;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class MoviesService {

    private static final Logger log = LoggerFactory.getLogger(MoviesService.class);
    private final static String METHOD_CALL = "movie";
    private final GenericApiCall apiCall;
    private final MovieRepository movieRepository;

    @Autowired
    public MoviesService(GenericApiCall apiCall, MovieRepository movieRepository) {
        this.apiCall = new GenericApiCall();
        this.movieRepository = movieRepository;
    }
    @Cacheable(value = "movieDetails", key = "#movieId")
    public MovieResponse findMovieById(String movieId) throws IOException {

        MovieResponse response = (MovieResponse) apiCall.consumeGetTemplate(MovieResponse.class, METHOD_CALL, movieId).getBody();
        if (response != null) {
            movieRepository.save(new MovieDto().toMovie(response));
        }
        return response;
    }

    public RateResponse rateMovie(String movieId, RateRequest rate) throws IOException {

        return (RateResponse) apiCall.consumePostTemplate(RateResponse.class, rate, METHOD_CALL, movieId, "rating").getBody();
    }

    @Cacheable(value = "genresCache", key = "'filter'")
    public GenresResponse getList(String filter) throws IOException {

        GenresResponse response = (GenresResponse) apiCall.consumeGetTemplate(GenresResponse.class, "genre", METHOD_CALL, "list").getBody();

        if (response != null && StringUtils.isNotBlank(filter)) {
            Predicate<Genre> equalsAction = x -> x.getName().equalsIgnoreCase(filter);
            response.setGenres(
                response.getGenres().stream()
                    .filter(equalsAction)
                    .collect(Collectors.toList()));
        }
        log.info("List of genres size is {}", response.getGenres().size());
        return response;
    }

    public List<MovieResponse> discoverMovies() throws IOException {

        return (List<MovieResponse>) apiCall.consumeGetTemplate(new ArrayList<MovieResponse>().getClass(), "discover", METHOD_CALL).getBody();
    }

    public Movie saveMovie(Movie movie) {

        movieRepository.save(movie);
        return movie;
    }
}
