package org.example.integration;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.controller.VehicleController;
import org.example.dto.RocketDTO;
import org.example.dto.VehicleDTO;
import org.example.entity.Car;
import org.example.repository.VehicleRepository;
import org.example.utils.enums.EngineType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VehicleControllerIntegrationTest {

    @Autowired
    VehicleController vehicleController;

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    WebApplicationContext wac;

    @Autowired
    ObjectMapper objectMapper;

    MockMvc mockMvc;


    @SpyBean
    ModelMapper modelMapper;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void shouldReturnListOfVehicleDTO() throws Exception{

        this.vehicleRepository.save(new Car("Model S","Tesla",200000,2018,
                5,"RED", EngineType.ELECTRIC,0F,300,new HashSet<>()));

        MockHttpServletResponse response = mockMvc.perform(get("/api/vehicles/")
        .accept(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();

        assertEquals(response.getStatus(), HttpStatus.OK.value());
        List<VehicleDTO> vehicleDTOList = Arrays.asList(objectMapper.readValue(response.getContentAsString(),VehicleDTO[].class));
        assertFalse(vehicleDTOList.isEmpty());
    }


    @Test
    public void shouldReturnPersistedVehicle() throws Exception{

       VehicleDTO requestBody =  new RocketDTO(0L,"Falcon 9","SpaceX",2000000,2019,
                2,2500,10,new HashSet<>());

       String vehicleJSON = objectMapper.writeValueAsString(requestBody);

       MockHttpServletResponse response = mockMvc.perform(post("/api/vehicles/")
       .contentType(MediaType.APPLICATION_JSON)
       .accept(MediaType.APPLICATION_JSON)
       .content(vehicleJSON))
               .andReturn()
               .getResponse();

       assertEquals(response.getStatus(),HttpStatus.CREATED.value());
       VehicleDTO persistedVehicle = objectMapper.readValue(response.getContentAsString(),VehicleDTO.class);
       assertNotNull(persistedVehicle);

    }

}
