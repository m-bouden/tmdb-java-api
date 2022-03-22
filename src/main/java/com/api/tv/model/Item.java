package com.api.tv.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

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

	public Item() {
		genreIds = new HashSet<>();
	}

	public String getPosterPath() {
		return posterPath;
	}
	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}
	public boolean isAdult() {
		return adult;
	}
	public void setAdult(boolean adult) {
		this.adult = adult;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getOriginalTitle() {
		return originalTitle;
	}
	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}
	public Set<Integer> getGenreIds() {
		return genreIds;
	}
	public void setGenreIds(Set<Integer> genreIds) {
		this.genreIds = genreIds;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public MediaType getMediaType() {
		return mediaType;
	}
	public void setMediaType(MediaType mediaType) {
		this.mediaType = mediaType;
	}
	public String getOriginalLanguage() {
		return originalLanguage;
	}
	public void setOriginalLanguage(String originalLanguage) {
		this.originalLanguage = originalLanguage;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBackdropPath() {
		return backdropPath;
	}
	public void setBackdropPath(String backdropPath) {
		this.backdropPath = backdropPath;
	}
	public double getPopularity() {
		return popularity;
	}
	public void setPopularity(double popularity) {
		this.popularity = popularity;
	}
	public int getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}
	public double getVoteAverage() {
		return voteAverage;
	}
	public void setVoteAverage(double voteAverage) {
		this.voteAverage = voteAverage;
	}
	public boolean isVideo() {
		return video;
	}
	public void setVideo(boolean video) {
		this.video = video;
	}

}
