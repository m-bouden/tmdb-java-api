package com.api.tv.web.rest;

import com.api.tv.model.TrendingResponse;
import com.api.tv.service.TrendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("trending")
public class TrendingController {

    @Autowired
    private final TrendingService trendingService;

    public TrendingController(TrendingService trendingService) {
        this.trendingService = trendingService;
    }

    @GetMapping("/{type}/{period}")
    public ResponseEntity<TrendingResponse> getTrending(@PathVariable("type") String type, @PathVariable("period") String period) {
        try {
            TrendingResponse response = trendingService.findTrending(type, period);
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }
}
