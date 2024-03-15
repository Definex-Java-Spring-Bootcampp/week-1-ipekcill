package com.patika.onlineshoppingservice.service;

import com.patika.onlineshoppingservice.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl {
    List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}
