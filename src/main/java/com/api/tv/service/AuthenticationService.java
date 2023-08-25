package com.api.tv.service;

import com.api.tv.model.GuestSession;
import com.api.tv.tools.GenericApiCall;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AuthenticationService {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationService.class);
    private final static String METHOD_CALL = "authentication";
    private final GenericApiCall apiCall;

    @Autowired
    public AuthenticationService(GenericApiCall call) {
        this.apiCall = call;
    }

    public GuestSession createNewGuestSession() throws IOException {

        log.info("Creating guest user session.");
        return (GuestSession) apiCall.consumeGetTemplate(GuestSession.class, METHOD_CALL, "guest_session", "new").getBody();
    }

}
