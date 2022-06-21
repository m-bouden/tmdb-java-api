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
public class SeasonResponse {

    private @JsonProperty("id") int id;
    private @JsonProperty("name") String name;
    private @JsonProperty("overview") String overview;
    private @JsonProperty("poster_path") String posterPath;
    private @JsonProperty("season_number") int seasonNumber;
    private @JsonProperty("episode_count") int episodeCount;
    private @JsonProperty("air_date") String airDate;

}
