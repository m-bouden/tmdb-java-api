package com.api.tv.tools;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.stereotype.Component;

@Component
public class GenericApiCall {

	private static final String BASE_URL = "https://api.themoviedb.org/3/";
	
	public GenericApiCall() {
	
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
	
	public String callApi(String... params) throws IOException {
		URL url = new URL(buildURL(params));

		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();

		//Getting the response code
		int responsecode = connection.getResponseCode();
		if (responsecode != 200) {
		    throw new RuntimeException("HttpResponseCode: " + responsecode);
		} else {
		  
		    String inline = "";
		    Scanner scanner = new Scanner(url.openStream());
		  
		   //Write all the JSON data into a string using a scanner
		    while (scanner.hasNext()) {
		       inline += scanner.nextLine();
		    }
		    
		    //Close the scanner
		    scanner.close();
		    return inline;
		}
	}
}
