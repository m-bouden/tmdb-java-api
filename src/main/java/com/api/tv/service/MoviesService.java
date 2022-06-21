package com.api.tv.service;

import com.api.tv.dto.MovieDto;
import com.api.tv.model.MovieResponse;
import com.api.tv.model.RateRequest;
import com.api.tv.model.RateResponse;
import com.api.tv.repository.MovieRepository;
import com.api.tv.tools.GenericApiCall;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.el.MapELResolver;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MoviesService {

    private final static String METHOD_CALL = "movie";
    private final GenericApiCall apiCall;
    private final MovieRepository movieRepository;

    @Autowired
    public MoviesService(GenericApiCall apiCall, MovieRepository movieRepository) {
        this.apiCall = apiCall;
        this.movieRepository = movieRepository;
    }

    public MovieResponse findMovieById(String movieId) throws IOException {

        log.info("Calling movie service for movieId = {}." , movieId);
        MovieResponse response = (MovieResponse) apiCall.consumeGetTemplate(MovieResponse.class, METHOD_CALL, movieId).getBody();
        if (response != null) {
            movieRepository.save(new MovieDto().toMovie(response));
        }
        return response;
    }

    public RateResponse rateMovie(String movieId, RateRequest rate) throws IOException {
        log.info("Rating value = {} for movieId = {}", rate.getValue(), movieId);
        return (RateResponse) apiCall.consumePostTemplate(RateResponse.class, rate, METHOD_CALL, movieId, "rating").getBody();
    }

    public List<MovieResponse> getList() throws IOException {
        log.info("Calling movie list service.");
        return (List<MovieResponse>) apiCall.consumeGetTemplate(new ArrayList<MovieResponse>().getClass(), "genre", METHOD_CALL, "list");
    }

    public List<MovieResponse> discoverMovies() throws IOException {
        log.info("Calling discover movies service.");
        return (List<MovieResponse>) apiCall.consumeGetTemplate(new ArrayList<MovieResponse>().getClass(), "discover", METHOD_CALL);
    }
}
