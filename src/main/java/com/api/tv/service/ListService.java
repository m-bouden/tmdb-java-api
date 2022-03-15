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

		String inline = apiCall.callApi(METHOD_CALL, listId);
		JsonParser parse = new JacksonJsonParser();
		Map<String, Object> responseBody = parse.parseMap(inline);

		return formatResponse(responseBody);

	}

	private ListResponse formatResponse(Map<String, Object> responseBody) {

		ListResponse response = new ListResponse();

		response.setCreatedBy((String) responseBody.get("created_by"));
		response.setDescription((String) responseBody.get("description"));
		response.setId((String) responseBody.get("id"));
		response.setLanguage((String) responseBody.get("iso_639-1"));
		response.setName((String) responseBody.get("name"));
		response.setPosterPath((String) responseBody.get("poster_path"));
		response.setItemCount(Integer.valueOf((String) responseBody.get("item_count")));
		response.setFavoriteCount(Integer.valueOf((String) responseBody.get("favorite_count")));

		JsonParser parse = new JacksonJsonParser();
		List<Item> items = new ArrayList<>();
		List<Object> itemList = Arrays.asList(responseBody.get("items"));
		for (Object element : itemList) {
			Map<String, Object> item = parse.parseMap((String) element);
			Item responseItem = new Item();
			responseItem.setTitle((String) item.get("title"));
			responseItem.setId((String) item.get("id"));
			responseItem.setOriginalTitle((String) item.get("original_title"));
			responseItem.setReleaseDate(LocalDate.parse((String) item.get("release_date")));
			responseItem.setMediaType(MediaType.valueOf((String) item.get("media_type")));
			responseItem.setOriginalLanguage((String) item.get("original_language"));
			responseItem.setVoteAverage(Double.valueOf((String) item.get("vote_average")));

			items.add(responseItem);
		}
		response.setItems(items);

		return response;
	}
}
