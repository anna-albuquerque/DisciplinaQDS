package com.anna.services;

import com.anna.services.OrderItem;
import com.anna.services.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private int orderId;
    private Date date;
    private List<OrderItem> items;
    private BigDecimal totalAmount;

    public Order(int orderId, Date date) {
        this.orderId = orderId;
        this.date = date;
        this.items = new ArrayList<>();
        this.totalAmount = BigDecimal.ZERO;
    }

    public void addProduct(Product product, int quantity) {
        if (product.updateStock(quantity)) {
            OrderItem item = new OrderItem(items.size() + 1, product, quantity);
            items.add(item);
            calculateTotal();
        } else {
            System.out.println("Cannot add product " + product.getName() + " - insufficient stock.");
        }
    }

    public void calculateTotal() {
        this.totalAmount = items.stream()
            .map(OrderItem::getSubTotal)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Order total updated: $" + totalAmount);
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public int getOrderId() {
        return orderId;
    }

    public Date getDate() {
        return date;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}