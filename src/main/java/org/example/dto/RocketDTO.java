package org.example.dto;

import java.util.Set;

public class RocketDTO extends VehicleDTO {

    private int crewCapacity;
    private float maxThrust;
    private float maxPayload;

    public RocketDTO() {
    }

    public RocketDTO(Long vehicleId, String modelName, String brandName, int price, int productionYear,
                      int crewCapacity, float maxThrust, float maxPayload) {
        super(vehicleId, modelName, brandName, price, productionYear);
        this.crewCapacity = crewCapacity;
        this.maxThrust = maxThrust;
        this.maxPayload = maxPayload;
    }


    public int getCrewCapacity() {
        return crewCapacity;
    }

    public void setCrewCapacity(int crewCapacity) {
        this.crewCapacity = crewCapacity;
    }

    public float getMaxThrust() {
        return maxThrust;
    }

    public void setMaxThrust(float maxThrust) {
        this.maxThrust = maxThrust;
    }

    public float getMaxPayload() {
        return maxPayload;
    }

    public void setMaxPayload(float maxPayload) {
        this.maxPayload = maxPayload;
    }

    @Override
    public String toString() {
        return "RocketDTO{" +
                super.toString() +
                "crewCapacity=" + crewCapacity +
                ", maxThrust=" + maxThrust +
                ", maxPayload=" + maxPayload +
                '}';
    }
}
