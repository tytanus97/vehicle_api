package org.example.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Set;


@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, property="type")
public class VehicleDTO {

    private Long vehicleId;
    private String modelName;
    private String brandName;
    private int price;
    private int productionYear;


    public VehicleDTO() {
    }

    public VehicleDTO(Long vehicleId, String modelName, String brandName, int price, int productionYear) {
        this.vehicleId = vehicleId;
        this.modelName = modelName;
        this.brandName = brandName;
        this.price = price;
        this.productionYear = productionYear;
        //this.owners = owners;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
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
        return  "  vehicleId=" + vehicleId +
                ", modelName='" + modelName + '\'' +
                ", brandName='" + brandName + '\'' +
                ", price=" + price +
                ", productionYear=" + productionYear + '\'';
    }
}
