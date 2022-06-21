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
public class Creator {

    private @JsonProperty("id") int id;
    private @JsonProperty("credit_id") String creditId;
    private @JsonProperty("name") String name;
    private @JsonProperty("gender") int gender;
    private @JsonProperty("profile_path") String profilePath;

}
