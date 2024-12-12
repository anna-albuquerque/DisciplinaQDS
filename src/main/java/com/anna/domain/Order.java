package com.anna.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Long customerId;

    @ElementCollection
    private List<Long> orderItemIds = new ArrayList<>();

    public void addOrderItemId(Long orderItemId) {
        this.orderItemIds.add(orderItemId);
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    // Getters and Setters
}