package org.example.entity;


import org.example.utils.enums.EngineType;

import javax.persistence.*;

@Entity
@Table(name="car")
@DiscriminatorValue("car")
public class Car extends Vehicle{

    @Column(name = "number_of_doors")
    private int numberOfDoors;

    @Column(name = "color")
    private String color;

    @Column(name = "engine_type")
    @Enumerated(value = EnumType.STRING)
    private EngineType engineType;

    @Column(name = "engine_capacity")
    private float engineCapacity;

    @Column(name= "horse_power")
    private int horsePower;

    public Car() {
    }

    public Car(String modelName, String brandName, int price, int productionYear, int numberOfDoors,
               String color, EngineType engineType, float engineCapacity, int horsePower) {
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

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
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
        return  super.toString() +
                "numberOfDoors=" + numberOfDoors +
                ", color='" + color + '\'' +
                ", engineType=" + engineType +
                ", engineCapacity=" + engineCapacity +
                ", horsePower=" + horsePower +
                '}';
    }
}
