package com.cg.ProductSpringWeb;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String name;
    String type;
    String place;
    private int warranty;

    
    public Product() {
    }

    
    public Product(String name, String type, String place, int warranty) {
        this.name = name;
        this.type = type;
        this.place = place;
        this.warranty = warranty;
    }


    @Override
    public String toString() {
        return "Product [name=" + name + ", type=" + type + ", place=" + place + ", warranty=" + warranty + "]";
    }

    
    
}