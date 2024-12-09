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

    // Listar todos os pagamentos
    public void listPayments() {
        System.out.println("Lista de Pagamentos:");
        for (Payment payment : payments) {
            System.out.println("Pagamento ID: " + payment.getPaymentId() + ", Valor: $" + payment.getAmount() + ", Data: " + payment.getDate());
        }
    }
}