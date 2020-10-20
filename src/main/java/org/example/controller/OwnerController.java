package org.example.controller;


import org.example.dto.OwnerDTO;
import org.example.service.OwnerService;
import org.example.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        retu
    }

}
