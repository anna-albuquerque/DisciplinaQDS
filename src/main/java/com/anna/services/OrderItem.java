package com.anna.services;

import java.math.BigDecimal;

public class OrderItem {
    private int itemId;
    private Product product;
    private int quantity;
    private double subTotal;

    private BigDecimal price;

public BigDecimal getPrice() {
    return price;
}

public void setPrice(BigDecimal price) {
    this.price = price;
}


    public OrderItem(int itemId, Product product, int quantity) {
        this.itemId = itemId;
        this.product = product;
        this.quantity = quantity;
        this.subTotal = calculateSubTotal();
    }

    public double calculateSubTotal() {
        return product.getPrice().multiply(new BigDecimal(quantity));
    }

    public BigDecimal getSubTotal() {
        return this.price.multiply(new BigDecimal(this.quantity));
    }
}
