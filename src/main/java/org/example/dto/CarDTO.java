package org.example.dto;

import java.util.Set;

public class CarDTO extends VehicleDTO {

    private int numberOfDoors;
    private String color;
    private String engineType;
    private float engineCapacity;
    private int horsePower;

    public CarDTO() {
    }

    public CarDTO(Long vehicleId, String modelName, String brandName, int price, int productionYear,
                  int numberOfDoors, String color, String engineType, float engineCapacity, int horsePower) {
        super(vehicleId, modelName, brandName, price, productionYear);
        this.numberOfDoors = numberOfDoors;
        this.color = color;
        this.engineType = engineType;
        this.engineCapacity = engineCapacity;
        this.horsePower = horsePower;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public float getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(float engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return "CarDTO{" +
                super.toString() +
                "numberOfDoors=" + numberOfDoors +
                ", color='" + color + '\'' +
                ", engineType='" + engineType + '\'' +
                ", engineCapacity=" + engineCapacity +
                ", horsePower=" + horsePower +
                '}';
    }
}
