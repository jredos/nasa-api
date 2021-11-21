package com.jrod.atmira.nasa.service;

import com.jrod.atmira.nasa.dao.NasaDAO;
import com.jrod.atmira.nasa.model.AsteroidDTO;
import com.jrod.atmira.nasa.utils.UtilsDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jesús Rodríguez
 */
@Service
public class NasaServiceImpl implements NasaService{

    @Autowired
    NasaDAO nasaDAO;

    @Override
    public List<AsteroidDTO> getDangerousAsteroids(Long days) {

        String startDate = UtilsDate.getCurrentDate();
        String endDate = UtilsDate.sumDaysToDate(startDate, days);

        List<AsteroidDTO> listAsteroidsAll = nasaDAO.getDangerousAsteroids(startDate, endDate);

        List<AsteroidDTO> listTOP3DangerousAsteroids = listAsteroidsAll
                .stream()
                .filter(asteroid -> asteroid.isDangerous())
                .filter(asteroid -> asteroid.getPlaneta().equals("Earth"))
                .sorted((a1, a2)->a2.getDiametro().
                        compareTo(a1.getDiametro()))
                .limit(3)
                .collect(Collectors.toList());

        return listTOP3DangerousAsteroids;
    }
}