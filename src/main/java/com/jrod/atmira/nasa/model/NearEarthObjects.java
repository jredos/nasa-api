package com.jrod.atmira.nasa.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * @author Jesús Rodríguez
 */
public class NearEarthObjects {
    private int element_count;
    private Map<String, List<AsteroidFields>> near_earth_objects;

    @JsonProperty("element_count")
    public void setElement_count(int element_count) {
        this.element_count = element_count;
    }

    @JsonProperty("near_earth_objects")
    public void setNear_earth_objects(Map<String, List<AsteroidFields>> near_earth_objects) {
        this.near_earth_objects = near_earth_objects;
    }

    public int getElement_count() {
        return element_count;
    }

    public Map<String, List<AsteroidFields>> getNear_earth_objects() {
        return near_earth_objects;
    }
}
