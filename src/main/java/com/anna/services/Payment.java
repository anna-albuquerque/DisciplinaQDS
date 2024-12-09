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

    // Getters
    public int getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    // Setters
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
