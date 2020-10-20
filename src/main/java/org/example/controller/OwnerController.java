package org.example.controller;


import org.apache.coyote.Response;
import org.example.dto.OwnerDTO;
import org.example.dto.VehicleDTO;
import org.example.entity.Vehicle;
import org.example.service.OwnerService;
import org.example.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;
    private final VehicleService vehicleService;

    @Autowired
    public OwnerController(OwnerService ownerService, VehicleService vehicleService) {
        this.ownerService = ownerService;
        this.vehicleService = vehicleService;
    }

    @GetMapping("/")
    public ResponseEntity<List<OwnerDTO>> findAllOwners() {
        return new ResponseEntity<>(this.ownerService.findAllOwners(), HttpStatus.OK);
    }

    @GetMapping("/{ownerId}")
    public ResponseEntity<OwnerDTO> findOwnerById(@PathVariable Long ownerId) {
        Optional<OwnerDTO> ownerDTO = this.ownerService.findById(ownerId);
        if(ownerDTO.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>(ownerDTO.get(),HttpStatus.OK);
    }

    @GetMapping("/{ownerId}")
    public ResponseEntity<Set<VehicleDTO>> findOwnerVehicles(@PathVariable Long ownerId) {
        Set<Vehicle> vehicleSet = this.ownerService.findOwnerVehicles(ownerId);
        Set<VehicleDTO> vehicleDTOSet = vehicleSet.stream()
                .map(vehicleService::mapToVehicleDTO).collect(Collectors.toSet());
        return new ResponseEntity<>(vehicleDTOSet,HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<OwnerDTO> addOwner(@RequestBody OwnerDTO ownerDTO) {
        OwnerDTO persistedOwner = this.ownerService.addOwner(ownerDTO);
        return new ResponseEntity<>(persistedOwner,HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<OwnerDTO> updateOwner(@RequestBody OwnerDTO ownerDTO) {
        OwnerDTO updatedOwner = this.ownerService.updateOwner(ownerDTO);
        return new ResponseEntity<>(updatedOwner,HttpStatus.CREATED);
    }

    @DeleteMapping("/{ownerId}")
    public ResponseEntity deleteOwner(@PathVariable Long ownerId) {
        this.ownerService.deleteOwner(ownerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
