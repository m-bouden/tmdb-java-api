package com.api.tv.model;

public enum MediaType {
	MOVIE("movie"), TV_SHOW("tv_show");
	
	public final String label;
	private MediaType(String value) {
		this.label = value;
	}
}
