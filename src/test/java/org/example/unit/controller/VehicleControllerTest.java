package org.example.unit.controller;

import org.example.dto.CarDTO;
import org.example.dto.RocketDTO;
import org.example.dto.VehicleDTO;
import org.example.entity.Car;
import org.example.entity.Owner;
import org.example.entity.Vehicle;
import org.example.service.OwnerService;
import org.example.service.VehicleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;

@WebMvcTest(VehicleController.class)
public class VehicleControllerTest {

    @MockBean
    VehicleService vehicleService;

    @MockBean
    OwnerService ownerService;

    @Autowired
    VehicleController vehicleController;

    @BeforeEach
    public void setUp() {
        given(vehicleService.findAllVehicles()).willReturn(prepareData());

        given(vehicleService.addVehicle(any(VehicleDTO.class))).willReturn(getExampleVehicleDTO());

        given(vehicleService.findById(any(Long.class))).willReturn(Optional.of(prepareData().get(1)));

        given(vehicleService.findVehicleOwners(1L))
                .willReturn(prepareDataOwnerDTO());

        given(vehicleService.mapToVehicle(any(VehicleDTO.class))).willReturn(new Car());

        given(vehicleService.mapToVehicleDTO(any(Vehicle.class))).willReturn(new CarDTO());

        given(vehicleService.updateVehicle(any(VehicleDTO.class))).willReturn(new CarDTO());

        doNothing().when(vehicleService).deleteVehicleById(any());

    }

    @Test
    public void findAllVehiclesShouldReturnResponseEntityWithVehicleDTOList() {
        ResponseEntity<List<VehicleDTO>> result = vehicleController.findAllVehicles();
        assertFalse(result.getBody().isEmpty());
    }

    @Test
    public void addVehicleShouldReturnVehicleDTO() {
        ResponseEntity<VehicleDTO> result = vehicleController.addVehicle(new CarDTO());
        assertNotNull(result.getBody());
    }

    @Test
    public void findVehicleByIdShouldReturnVehicleDTO() {
        ResponseEntity<VehicleDTO> result = vehicleController.findVehicleById(1L);
        assertNotNull(result.getBody());
    }

    List<VehicleDTO> prepareData() {
        return Arrays.asList(new CarDTO(),new RocketDTO(1L,"Falcon 9","SpaceX",5000000,
                2019,new HashSet<>(),2500,10,200),new CarDTO());
    }

    VehicleDTO getExampleVehicleDTO() {
        return prepareData().get(1);
    }

    Set<Owner> prepareDataOwnerDTO() {
        return Set.of(new Owner(),new Owner(),new Owner());

    }

}
