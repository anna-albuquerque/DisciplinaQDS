package com.anna.services.dto;

import java.math.BigDecimal;
import java.util.List;

public class OrderDTO {
    private Long orderId;
    private Long customerId;
    private List<Long> orderItemIds;
    private BigDecimal totalAmount;

    // Construtores, getters, setters
}

public class OrderItemDTO {
    private Long itemId;
    private Long productId;
    private int quantity;
    private BigDecimal subTotal;

    // Construtores, getters, setters
}