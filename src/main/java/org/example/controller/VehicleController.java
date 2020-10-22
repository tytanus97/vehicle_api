package org.example.controller;

import org.example.dto.VehicleDTO;
import org.example.service.OwnerService;
import org.example.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;


    @Autowired
    public VehicleController(VehicleService vehicleService, OwnerService ownerService) {
        this.vehicleService = vehicleService;

    }

    @GetMapping("/")
    public ResponseEntity<List<VehicleDTO>> findAllVehicles() {
        List<VehicleDTO> vehicleDTOList = this.vehicleService.findAllVehicles();
        return new ResponseEntity<>(vehicleDTOList,HttpStatus.OK);
    }

    @GetMapping("/{vehicleId}")
    public ResponseEntity<VehicleDTO> findVehicleById(@PathVariable Long vehicleId) {
        Optional<VehicleDTO> resultVehicleDTO = this.vehicleService.findById(vehicleId);

        if(resultVehicleDTO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(resultVehicleDTO.get(),HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<VehicleDTO> addVehicle(@RequestBody VehicleDTO vehicleDTO) {
        VehicleDTO persistedVehicleDTO = this.vehicleService.addVehicle(vehicleDTO);
        return new ResponseEntity<>(persistedVehicleDTO,HttpStatus.CREATED);
    }

    @PutMapping("/{vehicleId}")
    public ResponseEntity<VehicleDTO> updateVehicle(@RequestBody VehicleDTO vehicleDTO) {
        VehicleDTO updateVehicleDTO = this.vehicleService.updateVehicle(vehicleDTO);
        return new ResponseEntity<>(updateVehicleDTO,HttpStatus.OK);
    }

    @DeleteMapping("/{vehicleId}")
    public ResponseEntity deleteVehicle(@PathVariable Long vehicleId) {
        this.vehicleService.deleteVehicleById(vehicleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
