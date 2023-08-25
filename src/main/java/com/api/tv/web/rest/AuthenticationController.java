package com.api.tv.web.rest;

import com.api.tv.model.GuestSession;
import com.api.tv.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("authentication")
public class AuthenticationController {

    private final AuthenticationService service;

    @Autowired
    public AuthenticationController(AuthenticationService service) {
        this.service = service;
    }

    @GetMapping("/guest/new")
    public ResponseEntity<GuestSession> createGuestSession() {

        try {
            GuestSession response = service.createNewGuestSession();
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.SET_COOKIE, "com.api.tv.cookie=" + response.getGuestSessionId());
            return ResponseEntity.ok().headers(headers).body(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }
}
