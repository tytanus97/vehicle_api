package org.example.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vehicle_id")
    private Long vehicleId;

    @Column(name = "model_name")
    private String modelName;

    @Column(name="brand_name")
    private String brandName;

    @Column(name="price")
    private int price;

    @Column(name="production_year")
    private int productionYear;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "owner_vehicle",
    joinColumns = {@JoinColumn(name = "vehicle_id")},
    inverseJoinColumns = {@JoinColumn(name = "owner_id")})
    private Set<Owner> owners;

    public Vehicle() {

    }

    public Vehicle(String modelName, String brandName, int price, int productionYear) {
        this.modelName = modelName;
        this.brandName = brandName;
        this.price = price;
        this.productionYear = productionYear;
    }

    public Long getId() {
        return vehicleId;
    }

    public void setId(Long id) {
        this.vehicleId = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", modelName='" + modelName + '\'' +
                ", brandName='" + brandName + '\'' +
                ", price=" + price + '\'' +
                ", productionYear=" + productionYear + '\'';
    }
}
