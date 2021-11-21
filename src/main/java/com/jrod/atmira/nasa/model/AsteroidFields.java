package com.jrod.atmira.nasa.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Jesús Rodríguez
 */
public class AsteroidFields {
    private String name;
    private EstimatedDiameter estimated_diameter;
    private boolean is_potentially_hazardous_asteroid;
    private List<CloseApproachData> close_approach_data;

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("close_approach_data")
    public void setClose_Approach_Data(List<CloseApproachData> close_approach_data) {
        this.close_approach_data = close_approach_data;
    }

    @JsonProperty("estimated_diameter")
    public void setEstimated_diameter(EstimatedDiameter estimated_diameter) {
        this.estimated_diameter = estimated_diameter;
    }

    @JsonProperty("is_potentially_hazardous_asteroid")
    public void is_potentially_hazardous_asteroid(boolean is_potentially_hazardous_asteroid) {
        this.is_potentially_hazardous_asteroid = is_potentially_hazardous_asteroid;
    }

    public String getName() {
        return name;
    }

    public EstimatedDiameter getEstimated_diameter() {
        return estimated_diameter;
    }

    public List<CloseApproachData> getClose_approach_data() {
        return close_approach_data;
    }

    public boolean isIs_potentially_hazardous_asteroid() {
        return is_potentially_hazardous_asteroid;
    }
}
