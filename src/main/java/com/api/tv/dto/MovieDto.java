package com.api.tv.dto;

import com.api.tv.model.Movie;
import com.api.tv.model.MovieResponse;
import org.springframework.stereotype.Component;

@Component
public class MovieDto {

    public Movie toMovie(MovieResponse response) {

        Movie movie = new Movie()
            .title(response.getOriginalTitle())
            .language(response.getOriginalLanguage())
            .status(response.getStatus())
            .voteCount(response.getVoteCount())
            .voteAverage(response.getVoteAverage())
            .adult(response.isAdult());

        return movie;
    }
}
