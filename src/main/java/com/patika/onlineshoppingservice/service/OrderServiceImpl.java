package com.patika.onlineshoppingservice.service;

import com.patika.onlineshoppingservice.models.Order;
import com.patika.onlineshoppingservice.models.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl {
    List<Order> orders = new ArrayList<>();
    List<OrderItem> orderItems = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }
}
