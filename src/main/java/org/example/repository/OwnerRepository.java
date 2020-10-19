package org.example.repository;


import org.example.entity.Owner;
import org.example.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,Long> {

    @Query(value = "SELECT v from Vehicle v join fetch v.owners vo where vo.ownerId =:ownerId")
    Set<Vehicle> findOwnerVehicles(@Param("ownerId") Long ownerId);
}
