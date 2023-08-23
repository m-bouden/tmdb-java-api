package com.api.tv.web.rest;

import com.api.tv.model.*;
import com.api.tv.service.MoviesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RestController
@RequestMapping("movie")
public class MoviesController {

    @Autowired
    private final MoviesService moviesService;

    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @GetMapping("/{movieId}/details")
    public ResponseEntity<MovieResponse> getMovieById(@PathVariable("movieId") Integer movieId) {

        try {
            MovieResponse response = moviesService.findMovieById(String.valueOf(movieId));
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{movieId}/rate")
    public ResponseEntity<RateResponse> rateMovie(@PathVariable("movieId") Integer movieId, @RequestBody(required = true) @Valid RateRequest rate) {

        try {
            RateResponse response = moviesService.rateMovie(String.valueOf(movieId), rate);
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/list")
    public ResponseEntity<GenresResponse> getMoviesList(@RequestParam(name = "filter", required = false) String filter) {
        try {
            GenresResponse response = moviesService.getList(filter);
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/discover")
    public ResponseEntity<List<MovieResponse>> discoverMovies() {
        try {
            List<MovieResponse> response = moviesService.discoverMovies();
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }
}
