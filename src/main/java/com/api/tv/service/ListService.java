package com.api.tv.service;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.tv.model.ListResponse;
import com.api.tv.tools.GenericApiCall;

@Service
@Slf4j
public class ListService {

	private final static String METHOD_CALL = "list";
	private final GenericApiCall apiCall;

    @Autowired
	public ListService(GenericApiCall apiCall) {

        this.apiCall = apiCall;
    }

	public ListResponse getList(String listId) throws IOException {

        log.info("Calling list service for listId = {}.", listId);
		return (ListResponse) apiCall.consumeGetTemplate(ListResponse.class, METHOD_CALL, listId).getBody();
	}

}
