package com.jrod.atmira.nasa;

import com.jrod.atmira.nasa.dao.NasaDAO;
import com.jrod.atmira.nasa.model.AsteroidDTO;
import com.jrod.atmira.nasa.utils.UtilsDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author Jesús Rodríguez
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NasaDAOTests {

    @Autowired
    NasaDAO nasaDAO;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testGetDangerousAsteroids_ReturnListNotNull(){
        Long days = 6L;
        String startDate = UtilsDate.getCurrentDate();
        String endDate = UtilsDate.sumDaysToDate(startDate, days);
        List<AsteroidDTO> asteroidList = nasaDAO.getDangerousAsteroids(startDate, endDate);
        assertNotEquals(null, asteroidList);
    }
}
