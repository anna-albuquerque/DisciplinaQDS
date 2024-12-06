package com.anna.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;


public class Order {
    private int orderId;
    private Date date;
    private List<OrderItem> items;
    private double totalAmount;

    public Order(int orderId, Date date) {
        this.orderId = orderId;
        this.date = date;
        this.items = new ArrayList<>();
    }

    public void addProduct(Product product, int quantity) {
        if (product.updateStock(quantity)) {
            OrderItem item = new OrderItem(items.size() + 1, product, quantity);
            items.add(item);
            calculateTotal();
        } else {
            System.out.println("Cannot add product " + product.getName() + " - insufficient stock.");
        }
    }

    public void calculateTotal() {
        totalAmount = items.stream()
            .map(OrderItem::getSubTotal)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Order total updated: $" + totalAmount);
    }

    public BigDecimal getTotalAmount() {
        return this.items.stream()
            .map(OrderItem::getSubTotal)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
}
