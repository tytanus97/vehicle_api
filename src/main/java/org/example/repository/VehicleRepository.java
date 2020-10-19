package org.example.repository;

import org.example.entity.Owner;
import org.example.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {


    @Query(value = "SELECT o FROM Owner o join fetch o.ownedVehicles ov where ov.vehicleId =:vehicleId")
    Set<Owner> findVehicleOwners(@Param("vehicleId") Long vehicleId);
}
