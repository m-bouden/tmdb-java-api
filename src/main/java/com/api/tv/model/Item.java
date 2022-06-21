package com.api.tv.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
public class Item implements Serializable {

	private @JsonProperty("poster_path") String posterPath;
	private @JsonProperty("adult") boolean adult;
	private @JsonProperty("overview") String overview;
	private @JsonProperty("release_date") LocalDate releaseDate;
	private @JsonProperty("original_title") String originalTitle;
	private @JsonProperty("genre_ids") Set<Integer> genreIds;
	private @JsonProperty("id") String id;
	private @JsonProperty("media_type") MediaType mediaType;
	private @JsonProperty("original_language") String originalLanguage;
	private @JsonProperty("title") String title;
	private @JsonProperty("backdrop_path") String backdropPath;
	private @JsonProperty("popularity") double popularity;
	private @JsonProperty("vote_count") int voteCount;
	private @JsonProperty("vote_average") double voteAverage;
	private @JsonProperty("video") boolean video;

}
