package com.api.tv.tools;

import com.api.tv.model.RateRequest;
import org.apache.commons.compress.harmony.pack200.NewAttributeBands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GenericApiCall {

    @Autowired
    private final RestTemplate template;
	private static final String BASE_URL = "https://api.themoviedb.org/3/";

	public GenericApiCall(RestTemplate template) {

        this.template = template;
    }

    public ResponseEntity<?> consumeGetTemplate(Class<?> clazz, String... params) {
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

    public ResponseEntity<?> consumePostTemplate(Class<?> clazz, RateRequest rate, String... params) {
        HttpEntity<RateRequest> rateRequest  = new HttpEntity<>(rate);
        return template.postForEntity(buildURL(params), rateRequest, clazz);
    }
}
