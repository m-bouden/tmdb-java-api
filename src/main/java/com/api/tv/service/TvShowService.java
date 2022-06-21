package com.api.tv.service;

import com.api.tv.model.RateRequest;
import com.api.tv.model.RateResponse;
import com.api.tv.model.SeasonResponse;
import com.api.tv.model.TvShowResponse;
import com.api.tv.tools.GenericApiCall;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TvShowService {

    private static final String METHOD_CALL = "tv";
    private final GenericApiCall apiCall;

    @Autowired
    public TvShowService(GenericApiCall apiCall) {
        this.apiCall = apiCall;
    }

    public TvShowResponse findTvShowById(String showId) throws IOException {

        log.info("Calling movie service for showId = {}." , showId);
        return (TvShowResponse) apiCall.consumeGetTemplate(TvShowResponse.class, METHOD_CALL, showId).getBody();
    }

    public RateResponse rateShow(String showId, RateRequest rate) throws IOException {

        log.info("Rating value = {} for showId = {}", rate.getValue(), showId);
        return (RateResponse) apiCall.consumePostTemplate(RateResponse.class, rate, METHOD_CALL, showId, "rating").getBody();
    }

    public List<TvShowResponse> getList() throws IOException {

        log.info("Calling show list service.");
        return (List<TvShowResponse>) apiCall.consumeGetTemplate(ArrayList.class, "genre", METHOD_CALL, "list");
    }

    public List<TvShowResponse> discoverShows() throws IOException {

        log.info("Calling discover show service.");
        return (List<TvShowResponse>) apiCall.consumeGetTemplate(ArrayList.class, "discover", METHOD_CALL);
    }

    public SeasonResponse getSeasonDetails(String showId, String seasonNumber) throws IOException {

        log.info("Calling season details service for {} = showId and season number = {}.", showId, seasonNumber);
        return (SeasonResponse) apiCall.consumeGetTemplate(SeasonResponse.class, METHOD_CALL, showId, "season", seasonNumber).getBody();
    }
}
