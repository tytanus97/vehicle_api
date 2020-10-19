package org.example.service;


import org.example.dto.CarDTO;
import org.example.dto.VehicleDTO;
import org.example.entity.Owner;
import org.example.entity.Vehicle;
import org.example.repository.VehicleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
import java.util.Set;

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
    public Vehicle addVehicle(Vehicle vehicle) {

        return this.vehicleRepository.save(vehicle);
    }

    @Transactional
    public Set<Owner> findVehicleOwners(Long vehicleId) {
       return this.vehicleRepository.findVehicleOwners(vehicleId);
    }

    @Transactional
    public Optional<Vehicle> findById(long vehicleId) {
        return this.vehicleRepository.findById(vehicleId);
    }

   // public List<VehicleDTO>

    @Transactional
    public Vehicle updateVehicle(Vehicle vehicle) {
        return this.vehicleRepository.save(vehicle);
    }

    @Transactional
    public void deleteVehicleById(Long vehicleId) {
        this.vehicleRepository.deleteById(vehicleId);
    }

    public VehicleDTO mapToVehicleDTO(Vehicle vehicle){
        return this.modelMapper.map(vehicle,VehicleDTO.class);
    }

    public Vehicle mapToVehicle(VehicleDTO vehicleDTO) {
        return this.modelMapper.map(vehicleDTO,Vehicle.class);
    }

}
