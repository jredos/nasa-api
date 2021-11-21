package com.jrod.atmira.nasa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author Jesús Rodríguez
 */
@Builder
@Data
public class AsteroidDTO {
    private String nombre;
    private Double diametro;
    private Double velocidad;
    private LocalDate fecha;
    private String planeta;
    @JsonIgnore
    private boolean isDangerous;
}
