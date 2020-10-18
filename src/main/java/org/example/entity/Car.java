package org.example.entity;


import javax.persistence.*;

@Entity
@Table(name="car")
public class Car extends Vehicle{

    @Column(name = "number_of_doors")
    private int numberOfDoors;

    @Column(name = "car_color")
    private String color;

    @Column(name = "engine_type")
    @Enumerated(value = EnumType.STRING)
    private String engineType;

    @Column(name = "engine_capacity")
    private float engineCapacity;

    @Column(name= "horse_power")
    private int horsePower;

    public Car() {
    }

    public Car(String modelName, String brandName, int price, int productionYear, int numberOfDoors,
               String color, String engineType, float engineCapacity, int horsePower) {
        super(modelName, brandName, price, productionYear);

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
}
