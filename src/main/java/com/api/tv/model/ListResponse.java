package com.api.tv.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
public class ListResponse implements Serializable {

	private @JsonProperty("created_by") String createdBy;
	private @JsonProperty("description") String description;
	private @JsonProperty("favorite_count") int favoriteCount;
	private @JsonProperty("id") String id;
	private @JsonProperty("item_count") int itemCount;
	private @JsonProperty("name") String name;
	private @JsonProperty("poster_path") String posterPath;
	private @JsonProperty("iso_639_1") String language;

	private @JsonProperty("items") List<Item> items;

}
