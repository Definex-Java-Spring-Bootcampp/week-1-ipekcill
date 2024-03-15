package com.patika.onlineshoppingservice.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Order {
    private Customer customer;
    private LocalDateTime orderDate;
    private List<OrderItem> orderItems;
    private Bill bill;

    public Order(Customer customer, LocalDateTime orderDate) {
        this.customer = customer;
        this.orderDate = orderDate;
    }
    public void completeOrder() {
        for (OrderItem orderItem : orderItems) {
            Product product = orderItem.getProduct();
            int orderedQuantity = orderItem.getQuantity();
            int currentStock = product.getStock();

            if (currentStock >= orderedQuantity) {
                product.setStock(currentStock - orderedQuantity);
            } else {
                System.out.println("Sorry, " + product.getName() + " does not exist sufficient quantities in our stocks.");
            }
        }
    }
    public double calculateBill() {
        double totalAmount = 0;
        for (OrderItem item : orderItems) {
            totalAmount += item.getProduct().getPrice() * item.getQuantity();
        }
        return totalAmount;
    }
}
