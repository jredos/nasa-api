package com.jrod.atmira.nasa.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jesús Rodríguez
 */
public class RelativeVelocity {
    private Double kilometers_per_hour;

    public Double getKilometers_per_hour() {
        return kilometers_per_hour;
    }

    @JsonProperty("kilometers_per_hour")
    public void setKilometers_per_hour(Double kilometers_per_hour) {
        this.kilometers_per_hour = kilometers_per_hour;
    }
}
