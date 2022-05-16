package com.api.tv.web.rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.tv.model.ListResponse;
import com.api.tv.service.ListService;

@RestController
@RequestMapping("list")
public class ListController {

	@Autowired
	private final ListService listService;

    public ListController(ListService listService) {
        this.listService = listService;
    }

    @GetMapping("/{listId}/details")
	public ResponseEntity<ListResponse> getListById(@PathVariable("listId") String id) {

		try {
			ListResponse response = listService.getList(id);
			return ResponseEntity.ok(response);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ResponseEntity.notFound().build();
	}
}
