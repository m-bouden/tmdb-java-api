package com.api.tv.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RateRequest implements Serializable {

    @NotNull
    @Min(value = 0, message = "Rating value cannot be lower than 0.")
    @Max(value = 5, message = "Rating value cannot be more than 5.")
    private @JsonProperty("value") double value;

    public RateRequest() {

    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
