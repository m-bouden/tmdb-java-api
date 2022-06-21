package com.api.tv.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
public class Episode {

    private @JsonProperty("id") int id;
    private @JsonProperty("episode_number") int episodeNumber;
    private @JsonProperty("air_date") String airDate;
    private @JsonProperty("name") String name;
    private @JsonProperty("overview") String overview;
    private @JsonProperty("production_code") String productionCode;
    private @JsonProperty("season_number") int seasonNumber;
    private @JsonProperty("still_path") String stillPath;
    private @JsonProperty("vote_average") double voteAverage;
    private @JsonProperty("vote_count") int voteCount;

}
