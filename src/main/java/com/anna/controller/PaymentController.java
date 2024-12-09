package com.anna.controller;
import com.anna.services.Order;
import com.anna.services.Payment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PaymentController {
    private List<Payment> payments;

    public PaymentController() {
        this.payments = new ArrayList<>();
    }

    // Processar um pagamento para um pedido
    public void processPayment(int paymentId, Order order, Date date) {
        double amount = order.getTotalAmount().doubleValue(); // Assumindo que getTotalAmount() retorna BigDecimal
        Payment payment = new Payment(paymentId, amount, date);
        boolean success = payment.processPayment(); // Aqui precisa ajustar para um método correto de processamento
        if (success) {
            payments.add(payment);
            System.out.println("Pagamento processado com sucesso para o pedido ID: " + order.getOrderId());
        } else {
         
            System.out.println("Falha no processamento do pagamento para o pedido ID: " + order.getOrderId());
        }
    }

public void displayPaymentInfo() {
    Payment payment = new Payment(123, 100.0, new Date());
    System.out.println("Payment ID: " + payment.getPaymentId());
    System.out.println("Amount: " + payment.getAmount());
    System.out.println("Date: " + payment.getDate());
    }
}