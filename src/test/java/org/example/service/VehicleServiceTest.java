package org.example.service;

import org.example.config.Config;
import org.example.dto.CarDTO;
import org.example.dto.VehicleDTO;
import org.example.entity.Car;
import org.example.entity.Rocket;
import org.example.entity.Vehicle;
import org.example.repository.VehicleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;

@Import({Config.class})
@SpringBootTest(classes = {VehicleService.class})
public class VehicleServiceTest {

    @MockBean
    VehicleRepository vehicleRepository;

    @MockBean
    ModelMapper modelMapper;

    @Autowired
    VehicleService vehicleService;

    @BeforeEach
    public void setUp() {
        given(modelMapper.map(any(Vehicle.class),any())).willReturn(new CarDTO());
        given(modelMapper.map(any(VehicleDTO.class),any())).willReturn(new Car());

        given(vehicleRepository.findById(any(Long.class))).willReturn(Optional.of(new Car()));
        given(vehicleRepository.findAll()).willReturn(prepareData());
        given(vehicleRepository.save(any(Vehicle.class))).willReturn(new Car());
        doNothing().when(vehicleRepository).deleteById(any(Long.class));

    }

    @Test
    public void findAllShouldReturnVehicleDTOList() {
        List<VehicleDTO> vehicleDTOS = vehicleService.findAllVehicles();
        assertFalse(vehicleDTOS.isEmpty());
    }

    @Test
    public void findByIdShouldReturnNonEmptyOptionalVehicleDTO() {
        Optional<VehicleDTO> vehicleDTO = vehicleService.findById(1);
        assertTrue(vehicleDTO.isPresent());
    }

    @Test
    public void addVehicleShouldReturnVehicleDTO() {
        VehicleDTO vehicleDTO = vehicleService.addVehicle(new CarDTO());
        assertNotNull(vehicleDTO);
    }

    List<Vehicle> prepareData() {
        return Arrays.asList(new Car(),new Rocket("Falcon 9","SpaceX",5000000,
                2019,2500,2000,10),new Car());
    }

}
