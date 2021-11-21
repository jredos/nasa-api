package com.jrod.atmira.nasa.dao;

import com.jrod.atmira.nasa.exception.RestTemplateExceptionHandler;
import com.jrod.atmira.nasa.model.AsteroidDTO;
import com.jrod.atmira.nasa.model.AsteroidFields;
import com.jrod.atmira.nasa.model.CloseApproachData;
import com.jrod.atmira.nasa.model.NearEarthObjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jesús Rodríguez
 */
@Component
public class NasaDAO {
    @Value("${nasa.api.key}")
    private String API_KEY;
    @Value("${nasa.api.url}")
    private String API_URL;

    @Autowired
    RestTemplate restTemplate;

    public List<AsteroidDTO> getDangerousAsteroids(String startDate, String endDate){

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(API_URL)
                .queryParam("start_date", startDate)
                .queryParam("end_date", endDate)
                .queryParam("api_key", API_KEY);

        RequestEntity<Void> requestEntity = RequestEntity
                .get(builder.buildAndExpand().toUri())
                .build();

        restTemplate.setErrorHandler(new RestTemplateExceptionHandler());
        ResponseEntity<NearEarthObjects> responseEntity = restTemplate.exchange(requestEntity, NearEarthObjects.class);

        if(responseEntity.getBody() != null){
            return mapResponse(responseEntity.getBody());
        }

        return new ArrayList();
    }

    private List<AsteroidDTO> mapResponse(NearEarthObjects nearEarthObjects){

        List<AsteroidDTO> asteoridlist = new ArrayList();

        for(List<AsteroidFields> asteroidFields : nearEarthObjects.getNear_earth_objects().values()) {
            for (AsteroidFields fields : asteroidFields) {
                for (CloseApproachData closeApproachData : fields.getClose_approach_data()) {
                    asteoridlist.add(AsteroidDTO.builder()
                            .nombre(fields.getName())
                            .isDangerous(fields.isIs_potentially_hazardous_asteroid())
                            .planeta(closeApproachData.getOrbiting_body())
                            .velocidad(closeApproachData.getRelative_velocity().getKilometers_per_hour())
                            .diametro((fields.getEstimated_diameter().getKilometers().getEstimated_diameter_min()
                                    +fields.getEstimated_diameter().getKilometers().getEstimated_diameter_max())/2)
                            .fecha(LocalDate.parse(closeApproachData.getClose_approach_date()))
                            .build());
                }
            }
        }
        return asteoridlist;
    }

}

