package org.example.repository;

import org.example.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
}
