package com.api.tv.service;

import com.api.tv.model.RateRequest;
import com.api.tv.model.RateResponse;
import com.api.tv.model.TvShowResponse;
import com.api.tv.tools.GenericApiCall;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TvShowService {

    private static final String METHOD_CALL = "tv";
    protected Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final GenericApiCall apiCall;

    public TvShowService(GenericApiCall apiCall) {
        this.apiCall = apiCall;
    }

    public TvShowResponse findTvShowById(String showId) throws IOException {

        log.info("Calling movie service for showId = {}." , showId);
        return (TvShowResponse) apiCall.consumeGetTemplate(TvShowResponse.class, METHOD_CALL, showId).getBody();
    }

    public RateResponse rateShow(String showId, RateRequest rate) throws IOException {

        log.info("Rating value = {} for movieId = {}", rate.getValue(), showId);
        return (RateResponse) apiCall.consumePostTemplate(RateResponse.class, rate, METHOD_CALL, showId, "rating").getBody();
    }

    public List<TvShowResponse> getList() throws IOException {

        log.info("Calling movie list service.");
        return (List<TvShowResponse>) apiCall.consumeGetTemplate(new ArrayList<TvShowResponse>().getClass(), "genre", METHOD_CALL, "list");
    }

    public List<TvShowResponse> discoverMovies() throws IOException {

        log.info("Calling discover movies service.");
        return (List<TvShowResponse>) apiCall.consumeGetTemplate(new ArrayList<TvShowResponse>().getClass(), "discover", METHOD_CALL);
    }
}
