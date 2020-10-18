package org.example.entity;

import javax.persistence.*;

@MappedSuperclass
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model_name")
    private String modelName;

    @Column(name="brand_name")
    private String brandName;

    @Column(name="price")
    private int price;

    @Column(name="production_year")
    private int productionYear;

    public Vehicle() {

    }

    public Vehicle(String modelName, String brandName, int price, int productionYear) {
        this.modelName = modelName;
        this.brandName = brandName;
        this.price = price;
        this.productionYear = productionYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}
