package org.example.dto;

import java.util.Set;

public class OwnerDTO {

    private long ownerId;
    private String firstName;
    private String lastName;
    private Set<VehicleDTO> ownedVehicles;

    public OwnerDTO() {
    }

    public OwnerDTO(long ownerId, String firstName, String lastName,Set<VehicleDTO> vehicles) {
        this.ownerId = ownerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ownedVehicles = vehicles;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<VehicleDTO> getOwnedVehicles() {
        return ownedVehicles;
    }

    public void setOwnedVehicles(Set<VehicleDTO> ownedVehicles) {
        this.ownedVehicles = ownedVehicles;
    }

    @Override
    public String toString() {
        return "OwnerDTO{" +
                "ownerId=" + ownerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", vehicles='" + ownedVehicles + '\'' +
                '}';
    }
}
