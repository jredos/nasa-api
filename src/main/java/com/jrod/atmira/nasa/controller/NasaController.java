package com.jrod.atmira.nasa.controller;

import com.jrod.atmira.nasa.exception.ParamDaysNotFoundException;
import com.jrod.atmira.nasa.exception.ParamDaysInvalidException;
import com.jrod.atmira.nasa.model.AsteroidDTO;
import com.jrod.atmira.nasa.service.NasaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Jesús Rodríguez
 */
@Slf4j
@RestController
@RequestMapping(NasaController.ASTEROID)
public class NasaController {

    public static final String ASTEROID = "/asteroid";

    @Autowired
    private NasaService nasaService;

    @GetMapping(name = "/{days}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AsteroidDTO>> getDangerousAsteroids(@RequestParam(required = false) Long days)
            throws ParamDaysInvalidException, ParamDaysNotFoundException {

        if(days == null){
            log.error("Days parameter not found");
            throw new ParamDaysNotFoundException();
        }else if(days < 1 || days > 7){
            log.error("Invalid days {} parameter", days);
            throw new ParamDaysInvalidException("param: " + days);
        }

        return ResponseEntity.ok(nasaService.getDangerousAsteroids(days));
    }
}
