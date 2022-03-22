package com.api.tv.tools;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import com.api.tv.model.ListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GenericApiCall {

    @Autowired
    private RestTemplate template;
	private static final String BASE_URL = "https://api.themoviedb.org/3/";

	public GenericApiCall() {

	}

    public ResponseEntity consumeTemplate(Class clazz, String... params) {
        return template.getForEntity(buildURL(params), clazz);
    }

	private String buildURL(String... strings) {
		StringBuilder uri = new StringBuilder(BASE_URL);

		for (int i = 0; i < strings.length; i++) {
			uri.append(strings[i]);
			if (i < strings.length - 1) {
				uri.append("/");
			}
		}
		uri.append("?api_key=").append(TmdbApiConfiguration.getApiKey());
		uri.append("&language=").append(TmdbApiConfiguration.getDefaultLanguage());

		return uri.toString();
	}
}
