package com.api.tv.tests;

import com.api.tv.model.*;
import com.api.tv.repository.MovieRepository;
import com.api.tv.service.MoviesService;
import com.api.tv.web.rest.MoviesController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {

    @Mock
    private MovieRepository repository;

    @InjectMocks
    private MoviesService service;

    @InjectMocks
    private MoviesController controller;

    private Movie movie;

    @BeforeEach
    public void setup(){

        controller = new MoviesController(service);

        movie = new Movie();
        movie.setAdult(false);
        movie.setTitle("Batman");
        movie.setLanguage("en-US");
    }

    @DisplayName("JUnit test for saveMovie method")
    @Test
    public void testSaveMovieMethod(){
        // given - precondition or setup
        given(repository.save(movie)).willReturn(movie);

        // when -  action or the behaviour that we are going test
        Movie savedMovie = service.saveMovie(movie);

        System.out.println(savedMovie.getTitle());
        // then - verify the output
        assertThat(savedMovie).isNotNull();
    }

    @DisplayName("JUnit test for listMovie method")
    @Test
    public void testAllMoviesMethod() {

        Movie movie1 = new Movie();
        movie1.setTitle("Superman");
        movie1.setLanguage("en-US");
        movie1.setAdult(false);

        repository.save(movie1);

        given(repository.findAll()).willReturn(List.of(movie, movie1));
        List<Movie> movieList = repository.findAll();

        assertThat(movieList).isNotNull();
        assertThat(movieList.size()).isEqualTo(2);
    }

    @DisplayName("JUnit test for movieDetails method")
    @Test
    public void testWSMovieDetailsMethod() {

        MovieResponse movie = null;
        try {
            movie = service.findMovieById("11");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        assertThat(movie).isNotNull();
        assertThat(movie.getOriginalTitle()).isEqualTo("Star Wars");
    }

    @DisplayName("JUnit test for moviesList method")
    @Test
    public void testWSMovieListMethod() {

        GenresResponse response = null;
        try {
            response = service.getList("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("List size: " + response.getGenres().size());
        assertThat(response).isNotNull();
    }

    @DisplayName("JUnit test for moviesController method")
    @Test
    public void testControllerMovieDetailsMethod() {

        MovieResponse movie = null;
        movie = controller.getMovieById(11).getBody();

        assertThat(movie).isNotNull();
        assertThat(movie.getOriginalTitle()).isEqualTo("Star Wars");
    }

    @DisplayName("JUnit test for rateMovie method")
    @Test
    public void testRateMovieMethod() {

        RateRequest rateRequest = new RateRequest();
        rateRequest.setValue(4);

        RateResponse response = null;
        try {
            response = service.rateMovie("11", rateRequest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        assertThat(response).isNotNull();
    }

    @DisplayName("JUnit test for rateMovieController method")
    @Test
    public void testControllerRateMovieMethod() {

        RateRequest rateRequest = new RateRequest();
        rateRequest.setValue(6);

        RateResponse response = null;
        response = controller.rateMovie(11, rateRequest).getBody();
        System.out.println(response.getStatusCode() + " : " + response.getStatusMessage());

        assertThat(response).isNotNull();
    }
}
