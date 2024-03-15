package com.patika.onlineshoppingservice.models;

import com.patika.onlineshoppingservice.enums.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private String name;
    private ProductType productType;
    private Double price;
    private Integer stock;
}
