package com.jrod.atmira.nasa.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jesús Rodríguez
 */
public class EstimatedDiameter {
    private EstimatedDiameterUnit kilometers;

    @JsonProperty("kilometers")
    public void setKilometers(EstimatedDiameterUnit kilometers) {
        this.kilometers = kilometers;
    }

    public EstimatedDiameterUnit getKilometers() {
        return kilometers;
    }
}
