package org.example.service;


import org.example.dto.VehicleDTO;
import org.example.entity.Vehicle;
import org.example.repository.VehicleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    private final ModelMapper modelMapper;
    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(ModelMapper modelMapper, VehicleRepository vehicleRepository) {
        this.modelMapper = modelMapper;
        this.vehicleRepository = vehicleRepository;
    }

    @Transactional
    public VehicleDTO addVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = mapToVehicle(vehicleDTO);
        return mapToVehicleDTO(this.vehicleRepository.save(vehicle));
    }


    @Transactional
    public Optional<VehicleDTO> findById(long vehicleId) {
        Optional<Vehicle> vehicle = this.vehicleRepository.findById(vehicleId);
        return vehicle.isPresent() ? Optional.of(mapToVehicleDTO(vehicle.get())):Optional.empty();
    }

    @Transactional
    public List<VehicleDTO> findAllVehicles() {
        return this.vehicleRepository.findAll().stream()
                .map(this::mapToVehicleDTO).collect(Collectors.toList());

    }

    @Transactional
    public VehicleDTO updateVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = mapToVehicle(vehicleDTO);
        return mapToVehicleDTO(this.vehicleRepository.save(vehicle));
    }

    @Transactional
    public void deleteVehicleById(Long vehicleId) {
        this.vehicleRepository.deleteById(vehicleId);
    }

    @Transactional
    public List<VehicleDTO> findByType(String type) throws ClassNotFoundException {
        String className = "org.example.entity."+type;
        return this.vehicleRepository.findCars(Class.forName(className)).stream()
                .map(this::mapToVehicleDTO).collect(Collectors.toList());
    }

    public VehicleDTO mapToVehicleDTO(Vehicle vehicle){
        return this.modelMapper.map(vehicle, VehicleDTO.class);
    }

    public Vehicle mapToVehicle(VehicleDTO vehicleDTO) {
        return this.modelMapper.map(vehicleDTO,Vehicle.class);
    }


}
