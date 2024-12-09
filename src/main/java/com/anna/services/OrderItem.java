package com.anna.services;

import java.math.BigDecimal;

public class OrderItem {
    private int itemId;
    private Product product;
    private int quantity;
    private BigDecimal subTotal; // Calculado no construtor

    public OrderItem(int itemId, Product product, int quantity) {
        this.itemId = itemId;
        this.product = product;
        this.quantity = quantity;
        this.subTotal = product.getPrice().multiply(BigDecimal.valueOf(quantity)); // Calcula o subtotal diretamente no construtor
    }

    public BigDecimal getSubTotal() {
        // Retorna o subtotal já calculado no construtor
        return subTotal;
    }

    public void updateQuantity(int newQuantity) {
        this.quantity = newQuantity;
        // Atualiza o subtotal com base na nova quantidade
        this.subTotal = product.getPrice().multiply(BigDecimal.valueOf(newQuantity));
    }
}