package com.patika.onlineshoppingservice.service;

import com.patika.onlineshoppingservice.models.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class OrderItemServiceImpl {
    List<OrderItem> orderItems = new ArrayList<>();

    public void addOrderItems(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
}
