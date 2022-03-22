package com.api.tv.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.stereotype.Service;

import com.api.tv.model.Item;
import com.api.tv.model.ListResponse;
import com.api.tv.model.MediaType;
import com.api.tv.tools.GenericApiCall;

@Service
public class ListService {

	private final static String METHOD_CALL = "list";
	protected Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private GenericApiCall apiCall;

	public ListService() {

	}

	public ListResponse getList(String listId) throws IOException {

		return (ListResponse) apiCall.consumeTemplate(ListResponse.class, METHOD_CALL, listId).getBody();
	}

}
