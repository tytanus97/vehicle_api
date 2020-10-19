package org.example.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="owner")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="owner_id")
    private long ownerId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "owner_vehicle",joinColumns = {@JoinColumn(name="owner_id")}
    ,inverseJoinColumns = {@JoinColumn(name="vehicle_id")})
    private Set<Vehicle> ownedVehicles;

    public Owner() {
    }

    public Owner(String firstName, String lastName, Set<Vehicle> ownedVehicles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ownedVehicles = ownedVehicles;
    }

    public long getId() {
        return ownerId;
    }

    public void setId(long id) {
        this.ownerId = id;
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

    public Set<Vehicle> getOwnedVehicles() {
        return ownedVehicles;
    }

    public void setOwnedVehicles(Set<Vehicle> ownedVehicles) {
        this.ownedVehicles = ownedVehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        if(this.ownedVehicles == null) {
            this.ownedVehicles = new HashSet<>();
        }
        this.ownedVehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        if(this.ownedVehicles != null && this.ownedVehicles.size() > 0) {
            this.ownedVehicles.remove(vehicle);
        }
    }

    @Override
    public String toString() {
        return "Owner{" +
                "ownerId=" + ownerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
