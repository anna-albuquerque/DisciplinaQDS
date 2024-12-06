package com.anna.services;

import java.util.Date;

public class Payment {
    private int paymentId;
    private double amount;
    private Date date;

    public Payment(int paymentId, double amount, Date date) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.date = date;
    }

    public boolean processPayment() {
        System.out.println("Processing payment of $" + amount + " on " + date);
        return true; // Simulating successful payment
    }

    // Getters and Setters
}
