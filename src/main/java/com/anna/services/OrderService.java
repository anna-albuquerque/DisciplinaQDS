package com.anna.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderService {
    private List<Long> orderItemIds;

    public OrderService(int orderId, Date date) {
        this.orderItemIds = new ArrayList<>();
    }

    public void addProduct(Product product, int quantity) {
        if (product.updateStock(quantity)) {
            Long orderItemId = saveOrderItem(product, quantity);
            orderItemIds.add(orderItemId);
            calculateTotal();
        } else {
            System.out.println("Cannot add product " + product.getName() + " - insufficient stock.");
        }
    }

    private Long saveOrderItem(Product product, int quantity) {
        OrderItem item = new OrderItem(orderItemIds.size() + 1, product, quantity);
        return (long) item.getItemId();
    }

    public void setCustomerId(Long customerId) {
    }

    private BigDecimal totalAmount;
    private void calculateTotal() {
        this.totalAmount = orderItemIds.stream()
                .map(orderItemId -> new OrderItem(orderItemId.intValue(), null, 0).getSubTotal())
    //            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
}