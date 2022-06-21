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
public class MovieResponse implements Serializable {

    private @JsonProperty("id") int id;
    private @JsonProperty("title") String title;
    private @JsonProperty("original_language") String originalLanguage;
    private @JsonProperty("original_title") String originalTitle;
    private @JsonProperty("status") String status;
    private @JsonProperty("release_date") String releaseDate;
    private @JsonProperty("poster_path") String posterPath;
    private @JsonProperty("adult") boolean adult;
    private @JsonProperty("budget") int budget;
    private @JsonProperty("homepage") String homepage;
    private @JsonProperty("popularity") double popularity;
    private @JsonProperty("vote_average") double voteAverage;
    private @JsonProperty("vote_count") int voteCount;
    private @JsonProperty("imdb_id") int imdbId;
    private @JsonProperty("production_companies") List<ProductionCompany> productionCompanies;
    private @JsonProperty("production_countries") List<ProductionCountry> productionCountries;
    private @JsonProperty("spoken_languages") List<Language> spokenLanguages;
    private @JsonProperty("genres") List<Genre> genres;
    private @JsonProperty("video") boolean video;
    private @JsonProperty("genre_ids") List<String> genreIds;

}
