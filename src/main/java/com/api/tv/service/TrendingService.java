package com.api.tv.service;

import com.api.tv.model.TrendingResponse;
import com.api.tv.tools.GenericApiCall;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TrendingService {

    private final static String METHOD_CALL = "trending";
    protected Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final GenericApiCall apiCall;

    public TrendingService(GenericApiCall apiCall) {
        this.apiCall = apiCall;
    }

    public TrendingResponse findTrending(String type, String period) throws IOException {

        log.info("Calling trending movies/shows/other service.");
        return (TrendingResponse) apiCall.consumeGetTemplate(new TrendingResponse().getClass(), METHOD_CALL, type, period).getBody();
    }
}
