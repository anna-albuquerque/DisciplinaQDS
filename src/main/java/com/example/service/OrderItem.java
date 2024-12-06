package com.example.service;

public class OrderItem {
    private int itemId;
    private Product product;
    private int quantity;
    private double subTotal;

    public OrderItem(int itemId, Product product, int quantity) {
        this.itemId = itemId;
        this.product = product;
        this.quantity = quantity;
        this.subTotal = calculateSubTotal();
    }

    public double calculateSubTotal() {
        return product.getPrice() * quantity;
    }

    // Getters and Setters
}
