package org.example.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;

@Entity
@Table(name="rocket")
@DiscriminatorValue("rocket")
public class Rocket extends Vehicle{

    @Column(name="crew_capacity")
    private int crewCapacity;

    @Column(name="max_thrust")
    private float maxThrust;

    @Column(name="max_payload")
    private float maxPayload;

    public Rocket() {}

    public Rocket(String modelName, String brandName, int price, int productionYear, int crewCapacity,
                  float maxThrust, float maxPayLoad) {
        super(modelName, brandName, price, productionYear);

        this.crewCapacity = crewCapacity;
        this.maxThrust = maxThrust;
        this.maxPayload = maxPayLoad;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "crewCapacity=" + crewCapacity +
                ", maxThrust=" + maxThrust +
                ", maxPayLoad=" + maxPayload +
                '}';
    }
}
