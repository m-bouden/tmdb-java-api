package com.api.tv.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
public class TvShowResponse {

    private @JsonProperty("id") int id;
    private @JsonProperty("original_name") String originalName;
    private @JsonProperty("origin_country") String originCountry;
    private @JsonProperty("original_language") String originalLanguage;
    private @JsonProperty("overview") String overview;
    private @JsonProperty("poster_path") String posterPath;
    private @JsonProperty("status") String status;
    private @JsonProperty("type") String type;
    private @JsonProperty("name") String name;
    private @JsonProperty("languages") List<String> languages;
    private @JsonProperty("created_by") Creator createdBy;
    private @JsonProperty("genres") List<Genre> genres;
    private @JsonProperty("first_air_date") String firstAirDate;
    private @JsonProperty("last_episode_to_air") Episode lastEpisode;
    private @JsonProperty("networks") List<Network> networks;
    private @JsonProperty("number_of_seasons") int seasonNumber;
    private @JsonProperty("number_of_episodes") int episodeNumber;
    private @JsonProperty("production_companies") List<ProductionCompany> productionCompanies;
    private @JsonProperty("production_countries") List<ProductionCountry> productionCountries;
    private @JsonProperty("seasons") List<SeasonResponse> seasons;
    private @JsonProperty("spoken_languages") List<Language> spokenLanguages;
    private @JsonProperty("vote_average") double voteAverage;
    private @JsonProperty("vote_count") int voteCount;
    private @JsonProperty("tagline") String tagline;

}
