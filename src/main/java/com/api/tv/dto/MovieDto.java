package com.api.tv.dto;

import com.api.tv.model.Movie;
import com.api.tv.model.MovieResponse;
import org.springframework.stereotype.Component;

@Component
public class MovieDto {

    public static Movie toMovie(MovieResponse response) {

        Movie movie = new Movie();
        movie.setId(response.getId());
        movie.setLanguage(response.getOriginalLanguage());
        movie.setAdult(response.isAdult());
        movie.setStatus(response.getStatus());
        movie.setVoteAverage(response.getVoteAverage());
        movie.setVoteCount(response.getVoteCount());
        return movie;
    }
}
