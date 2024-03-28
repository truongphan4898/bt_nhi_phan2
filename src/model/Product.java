package model;

import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String name;
    private double cost;
    private String brand;

    public Product() {
    }

    public Product(String id, String name, double cost, String brand) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.brand = brand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Product: " +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", brand='" + brand + '\''+"\n"
                ;
    }
}
