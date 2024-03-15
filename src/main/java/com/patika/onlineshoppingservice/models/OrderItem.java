package com.patika.onlineshoppingservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderItem {
    private Product product;
    private Integer quantity;
}
