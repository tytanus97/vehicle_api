package org.example.service;

import org.example.entity.Owner;
import org.example.entity.Vehicle;
import org.example.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collections;
import java.util.Optional;
import java.util.Set;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;


    @Autowired
    public OwnerService(OwnerRepository ownerRepository) {

        this.ownerRepository = ownerRepository;
    }

    @Transactional
    public Owner addOwner(Owner owner) {
            return this.ownerRepository.save(owner);
    }

    @Transactional
    public Optional<Owner> findById(long ownerId) {
        return this.ownerRepository.findById(ownerId);
    }

    @Transactional
    public Set<Vehicle> findOwnerVehicles(Long ownerId) {
        return this.ownerRepository.findOwnerVehicles(ownerId);
    }


    @Transactional
    public Owner updateOwner(Owner owner) {
        return this.ownerRepository.save(owner);
    }

    @Transactional
    public void deleteOwner(Long ownerId) {
        this.ownerRepository.deleteById(ownerId);
    }





}
