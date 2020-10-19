package org.example.service;

import org.example.dto.OwnerDTO;
import org.example.entity.Owner;
import org.example.entity.Vehicle;
import org.example.repository.OwnerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
public class OwnerService {
    private final ModelMapper modelMapper;
    private final OwnerRepository ownerRepository;


    @Autowired
    public OwnerService(ModelMapper modelMapper, OwnerRepository ownerRepository) {
        this.modelMapper = modelMapper;
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


    public OwnerDTO mapToOwnerDTO(Owner owner) {
        return this.modelMapper.map(owner,OwnerDTO.class);
    }

    public Owner mapToOwner(OwnerDTO ownerDTO) {
        return this.modelMapper.map(ownerDTO,Owner.class);
    }


}
