package com.example.service;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Criando produtos
        Product product1 = new Product(1, "Laptop", 1500.00, 10);
        Product product2 = new Product(2, "Phone", 800.00, 5);

        // Criando cliente
        Customer customer = new Customer(1, "Alice", "alice@example.com");

        // Criando pedido
        Order order = new Order(1, new Date());
        order.addProduct(product1, 2);
        order.addProduct(product2, 1);

        // Associando pedido ao cliente
        customer.placeOrder(order);

        // Processando pagamento
        Payment payment = new Payment(1, order.getTotalAmount(), new Date());
        if (payment.processPayment()) {
            System.out.println("Payment successful!");
        } else {
            System.out.println("Payment failed!");
        }
    }
}
