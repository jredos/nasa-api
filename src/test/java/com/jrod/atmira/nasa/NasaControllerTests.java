package com.jrod.atmira.nasa;

import com.jrod.atmira.nasa.controller.NasaController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @author Jesús Rodríguez
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class NasaControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testGetDangerousAsteroids_SizeListOk() throws Exception {
        final int sizeList = 3;
        mockMvc.perform(get(NasaController.ASTEROID).param("days", "6"))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(sizeList)));
    }

    @Test
    public void testGetDangerousAsteroids_PlanetEarthOk() throws Exception {
        mockMvc.perform(get(NasaController.ASTEROID).param("days", "6"))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].planeta", is("Earth")));
    }

    //Exceptions

    @Test
    public void testGetDangerousAsteroids_paramDaysNotFound() throws Exception {
        mockMvc.perform(get(NasaController.ASTEROID))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetDangerousAsteroids_paramDaysInvalid() throws Exception {
        mockMvc.perform(get(NasaController.ASTEROID).param("days", "9"))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetDangerousAsteroids_paramDaysAsString() throws Exception {
        mockMvc.perform(get(NasaController.ASTEROID).param("days", "test"))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
