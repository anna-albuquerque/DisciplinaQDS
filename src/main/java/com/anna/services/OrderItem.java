package com.anna.services;

import java.math.BigDecimal;

public class OrderItem {
    private int itemId;
    private Product product;
    private int quantity;
    private BigDecimal subTotal;

    public OrderItem(int itemId, Product product, int quantity) {
        this.itemId = itemId;
        this.product = product;
        this.quantity = quantity;
        this.subTotal = product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void updateQuantity(int newQuantity) {
        this.quantity = newQuantity;
        this.subTotal = product.getPrice().multiply(BigDecimal.valueOf(newQuantity));
    }

    public int getItemId() {
        return itemId;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}