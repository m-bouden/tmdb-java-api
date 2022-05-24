package com.api.tv.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
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

    public TvShowResponse() {
        this.networks = new ArrayList<>();
        this.languages = new ArrayList<>();
        this.productionCompanies = new ArrayList<>();
        this.productionCountries = new ArrayList<>();
        this.spokenLanguages = new ArrayList<>();
        this.seasons = new ArrayList<>();
        this.genres = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public Creator getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Creator createdBy) {
        this.createdBy = createdBy;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    public Episode getLastEpisode() {
        return lastEpisode;
    }

    public void setLastEpisode(Episode lastEpisode) {
        this.lastEpisode = lastEpisode;
    }

    public List<Network> getNetworks() {
        return networks;
    }

    public void setNetworks(List<Network> networks) {
        this.networks = networks;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public List<ProductionCompany> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(List<ProductionCompany> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public List<ProductionCountry> getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(List<ProductionCountry> productionCountries) {
        this.productionCountries = productionCountries;
    }

    public List<SeasonResponse> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<SeasonResponse> seasons) {
        this.seasons = seasons;
    }

    public List<Language> getSpokenLanguages() {
        return spokenLanguages;
    }

    public void setSpokenLanguages(List<Language> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }
}
