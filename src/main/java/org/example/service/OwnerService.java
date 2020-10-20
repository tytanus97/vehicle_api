package org.example.service;

import org.example.dto.OwnerDTO;
import org.example.entity.Owner;
import org.example.entity.Vehicle;
import org.example.repository.OwnerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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
    public OwnerDTO addOwner(OwnerDTO ownerDTO)
    {
            Owner owner = mapToOwner(ownerDTO);
            return mapToOwnerDTO(this.ownerRepository.save(owner));
    }

    @Transactional
    public Optional<OwnerDTO> findById(long ownerId) {
        Optional<Owner> owner = this.ownerRepository.findById(ownerId);
        return owner.isPresent()?Optional.of(mapToOwnerDTO(owner.get())):Optional.empty();
    }

    @Transactional
    public List<OwnerDTO> findAllOwners() {
        List<Owner> ownerList = this.ownerRepository.findAll();
        return ownerList.stream().map(this::mapToOwnerDTO).collect(Collectors.toList());
    }

    @Transactional
    public Set<Vehicle> findOwnerVehicles(Long ownerId) {
        return this.ownerRepository.findOwnerVehicles(ownerId);
    }

    @Transactional
    public OwnerDTO updateOwner(OwnerDTO ownerDTO) {
        Owner owner = mapToOwner(ownerDTO);
        return mapToOwnerDTO(this.ownerRepository.save(owner));
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
