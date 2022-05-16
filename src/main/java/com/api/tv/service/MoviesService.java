package com.api.tv.service;

import com.api.tv.model.MovieResponse;
import com.api.tv.model.RateRequest;
import com.api.tv.model.RateResponse;
import com.api.tv.tools.GenericApiCall;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.el.MapELResolver;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MoviesService {

    private final static String METHOD_CALL = "movie";
    protected Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final GenericApiCall apiCall;

    public MoviesService(GenericApiCall apiCall) {
        this.apiCall = apiCall;
    }

    public MovieResponse findMovieById(String movieId) throws IOException {

        log.info("Calling movie service for movieId = {}." , movieId);
        return (MovieResponse) apiCall.consumeGetTemplate(MovieResponse.class, METHOD_CALL, movieId).getBody();
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
