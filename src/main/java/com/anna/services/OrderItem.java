package com.anna.services;

import java.math.BigDecimal;

public class OrderItem {
    private Long itemId;
    private Long productId; // Referência por ID
    private int quantity;
    private BigDecimal subTotal;

    public OrderItem(int itemId, Product product, int quantity) {
        this.itemId = (long) itemId;
        this.productId = (long) product.getProductId();
        this.quantity = quantity;
        this.subTotal = product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    // Métodos modificados para usar IDs
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    // Outros métodos mantidos...
}