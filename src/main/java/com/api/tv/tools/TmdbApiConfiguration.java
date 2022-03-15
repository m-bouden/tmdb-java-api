package com.api.tv.tools;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class TmdbApiConfiguration {
	
	@Value("${tmdb.api.key}")
	private static String apiKey;
	
	@Value("${tmdb.api.default.language}")
	private static String defaultLanguage;

	public static String getApiKey() {
		return apiKey;
	}
	
	public static String getDefaultLanguage() {
		return defaultLanguage;
	}
}
