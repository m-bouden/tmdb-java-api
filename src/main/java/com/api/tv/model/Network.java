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
public class Network {

    private @JsonProperty("id") int id;
    private @JsonProperty("name") String name;
    private @JsonProperty("logo_path") String logoPath;
    private @JsonProperty("origin_country") String originCountry;

}
