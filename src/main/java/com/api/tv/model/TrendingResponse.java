package com.api.tv.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
public class TrendingResponse {

    private @JsonProperty("page") int page;
    private @JsonProperty("total_pages") int totalPages;
    private @JsonProperty("total_results") int totalResults;
    private @JsonProperty("results") List<MovieResponse> results;

}
