package com.anna.domain;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDTO {

    private int orderId;
    private String customerName;
    private Date orderDate;
    private BigDecimal totalAmount;

    // Construtor
    public OrderDTO(int orderId, String customerName, Date orderDate, BigDecimal totalAmount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }

    // Getters e Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "OrderDTO [orderId=" + orderId + ", customerName=" + customerName + ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + "]";
    }
}
