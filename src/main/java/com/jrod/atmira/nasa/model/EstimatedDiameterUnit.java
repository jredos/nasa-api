package com.jrod.atmira.nasa.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jesús Rodríguez
 */
public class EstimatedDiameterUnit {
    private Double estimated_diameter_min;
    private Double estimated_diameter_max;

    @JsonProperty("estimated_diameter_min")
    public void setEstimated_diameter_min(Double estimated_diameter_min) {
        this.estimated_diameter_min = estimated_diameter_min;
    }

    @JsonProperty("estimated_diameter_max")
    public void setEstimated_diameter_max(Double estimated_diameter_max) {
        this.estimated_diameter_max = estimated_diameter_max;
    }

    public Double getEstimated_diameter_max() {
        return estimated_diameter_max;
    }

    public Double getEstimated_diameter_min() {
        return estimated_diameter_min;
    }
}
