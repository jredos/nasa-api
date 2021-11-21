package com.jrod.atmira.nasa.service;

import com.jrod.atmira.nasa.model.AsteroidDTO;

import java.util.List;

/**
 * @author Jesús Rodríguez
 */
public interface NasaService {
    List<AsteroidDTO> getDangerousAsteroids(Long days);
}

