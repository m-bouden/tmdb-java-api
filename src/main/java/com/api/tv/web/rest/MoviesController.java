package com.api.tv.web.rest;

import com.api.tv.model.MovieResponse;
import com.api.tv.model.RateRequest;
import com.api.tv.model.RateResponse;
import com.api.tv.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("movie")
public class MoviesController {

    @Autowired
    private final MoviesService moviesService;

    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @GetMapping("/{movieId}/details")
    public ResponseEntity<MovieResponse> getMovieById(@PathVariable("movieId") String movieId) {

        try {
            MovieResponse response = moviesService.findMovieById(movieId);
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{movieId}/rate")
    public ResponseEntity<RateResponse> rateMovie(@PathVariable("movieId") String movieId, @RequestBody(required = true) RateRequest rate) {

        try {
            RateResponse response = moviesService.rateMovie(movieId, rate);
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<MovieResponse>> getMoviesList() {
        try {
            List<MovieResponse> response = moviesService.getList();
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
