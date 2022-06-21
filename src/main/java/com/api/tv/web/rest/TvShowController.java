package com.api.tv.web.rest;

import com.api.tv.model.RateRequest;
import com.api.tv.model.RateResponse;
import com.api.tv.model.SeasonResponse;
import com.api.tv.model.TvShowResponse;
import com.api.tv.service.TvShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("tv")
public class TvShowController {

    private final TvShowService tvShowService;

    @Autowired
    public TvShowController(TvShowService tvShowService) {
        this.tvShowService = tvShowService;
    }

    @GetMapping("/{showId}/details")
    public ResponseEntity<TvShowResponse> getShowDetails(@PathVariable("showId") String showId) {

        try {
            TvShowResponse response = tvShowService.findTvShowById(showId);
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{showId}/rate")
    public ResponseEntity<RateResponse> rateMovie(@PathVariable("showId") String showId, @RequestBody RateRequest rate) {

        try {
            RateResponse response = tvShowService.rateShow(showId, rate);
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<TvShowResponse>> getMoviesList() {
        try {
            List<TvShowResponse> response = tvShowService.getList();
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/discover")
    public ResponseEntity<List<TvShowResponse>> discoverShows() {
        try {
            List<TvShowResponse> response = tvShowService.discoverShows();
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{showId}/season/{number}")
    public ResponseEntity<SeasonResponse> getSeasonDetails(@PathVariable("showId") String showId, @PathVariable("number") String seasonNumber) {
        try {
            SeasonResponse response = tvShowService.getSeasonDetails(showId, seasonNumber);
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }
}
