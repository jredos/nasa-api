package com.jrod.atmira.nasa.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jesús Rodríguez
 */
public class CloseApproachData {
    private RelativeVelocity relative_velocity;
    private String orbiting_body;
    private String close_approach_date;

    @JsonProperty("relative_velocity")
    public void setRelative_velocity(RelativeVelocity relative_velocity) {
        this.relative_velocity = relative_velocity;
    }

    @JsonProperty("orbiting_body")
    public void setOrbiting_body(String orbiting_body) {
        this.orbiting_body = orbiting_body;
    }

    @JsonProperty("close_approach_date")
    public void setClose_approach_date(String close_approach_date) { this.close_approach_date = close_approach_date; }

    public RelativeVelocity getRelative_velocity() {
        return relative_velocity;
    }

    public String getOrbiting_body() {
        return orbiting_body;
    }

    public String getClose_approach_date() { return close_approach_date;   }
}
