package org.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.controller.VehicleController;
import org.example.dto.CarDTO;
import org.example.dto.RocketDTO;
import org.example.dto.VehicleDTO;
import org.example.entity.Car;
import org.example.entity.Rocket;
import org.example.entity.Vehicle;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(Car.class, VehicleDTO.class)
                .setConverter(mappingContext -> modelMapper.map(mappingContext.getSource(),CarDTO.class));
        modelMapper.createTypeMap(CarDTO.class, Vehicle.class)
                .setConverter(mappingContext -> modelMapper.map(mappingContext.getSource(),Car.class));

        modelMapper.createTypeMap(Rocket.class,VehicleDTO.class)
                .setConverter(mappingContext -> modelMapper.map(mappingContext.getSource(),RocketDTO.class));
        modelMapper.createTypeMap(RocketDTO.class,Vehicle.class)
                .setConverter(mappingContext -> modelMapper.map(mappingContext.getSource(),Rocket.class));
        return modelMapper;
    }

    @Bean
    public ObjectMapper objectMapper() {

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("configured object mapper");
        objectMapper.registerSubtypes(RocketDTO.class);
        objectMapper.registerSubtypes(CarDTO.class);

        return objectMapper;
    }
}
