package com.anna.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderService {
    // Remover dependência direta de Customer
    private Long customerId; 
    private int orderId;
    private Date date;
    private List<Long> orderItemIds; // Usar IDs em vez de objetos
    private BigDecimal totalAmount;

    public OrderService(int orderId, Date date) {
        this.orderId = orderId;
        this.date = date;
        this.orderItemIds = new ArrayList<>();
        this.totalAmount = BigDecimal.ZERO;
    }

    public void addProduct(Product product, int quantity) {
        if (product.updateStock(quantity)) {
            // Criar e salvar OrderItem, obtendo seu ID
            Long orderItemId = saveOrderItem(product, quantity);
            orderItemIds.add(orderItemId);
            calculateTotal();
        } else {
            System.out.println("Cannot add product " + product.getName() + " - insufficient stock.");
        }
    }

    // Método para salvar OrderItem e retornar seu ID
    private Long saveOrderItem(Product product, int quantity) {
        OrderItem item = new OrderItem(orderItemIds.size() + 1, product, quantity);
        // Lógica para salvar o item e retornar seu ID
        return (long) item.getItemId();
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    // Outros métodos mantidos...
}