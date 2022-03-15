package com.api.tv.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Item {

	private String posterPath;
	private boolean adult;
	private String overview;
	private LocalDate releaseDate;
	private String originalTitle;
	private Set<Integer> genreIds;
	private String id;
	private MediaType mediaType;
	private String originalLanguage;
	private String title;
	private String backdropPath;
	private double popularity;
	private int voteCount;
	private double voteAverage;
	private boolean video;

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
