package com.example.service;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private String email;
    private List<Order> orders;

    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println("Order placed by " + name);
    }

    // Getters and Setters
}
