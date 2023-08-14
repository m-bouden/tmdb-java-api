package com.api.tv.tools;

import com.api.tv.model.RateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class GenericApiCall {

    private final RestTemplate template;
	private static final String BASE_URL = "https://api.themoviedb.org/3/";

    @Bean
    public RestTemplate restTemplate() {

        return new RestTemplateBuilder().build();
    }

    @Autowired
	public GenericApiCall() {
        template = restTemplate();
    }

    public ResponseEntity<?> consumeGetTemplate(Class<?> clazz, String... params) {

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhMzQ2MGE3NTAwNjQ2NzkwZjhjNTkyYzAzYjNkZDdhYyIsInN1YiI6IjYyMjljOTQ5MTA5Y2QwMDAxYmYyZGI0MiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.1YRvb85pOPujEzk9-ivB5YZTHONOfC-YoEjeNYoWfzs");
        return template.exchange(buildURL(params), HttpMethod.GET, new HttpEntity<>(headers), clazz);
    }

	private String buildURL(String... strings) {
		StringBuilder uri = new StringBuilder(BASE_URL);

		for (int i = 0; i < strings.length; i++) {
			uri.append(strings[i]);
			if (i < strings.length - 1) {
				uri.append("/");
			}
		}
		uri.append("?language=").append(TmdbApiConfiguration.getDefaultLanguage());

		return uri.toString();
	}

    public ResponseEntity<?> consumePostTemplate(Class<?> clazz, RateRequest rate, String... params) {

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhMzQ2MGE3NTAwNjQ2NzkwZjhjNTkyYzAzYjNkZDdhYyIsInN1YiI6IjYyMjljOTQ5MTA5Y2QwMDAxYmYyZGI0MiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.1YRvb85pOPujEzk9-ivB5YZTHONOfC-YoEjeNYoWfzs");
        template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        HttpEntity<RateRequest> rateRequest  = new HttpEntity<>(rate, headers);
        return template.postForEntity(buildURL(params), rateRequest, clazz);
    }
}
