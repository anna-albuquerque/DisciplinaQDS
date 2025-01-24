package com.anna.controller;

import com.anna.domain.Order;
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
		if (order == null || date == null) {
			System.out.println("Data e cliente são obrigatórios para processar um pagamento.");
			return;
		}
		double amount = order.getTotalAmount().doubleValue(); // Ajuste para obter o valor
																// total diretamente
		Payment payment = new Payment(paymentId, amount, date);
		boolean success = payment.processPayment(); // Ajuste para o método correto de
													// processamento de pagamento
		if (success) {
			payments.add(payment);
			System.out.println("Pagamento processado com sucesso para o pedido ID: " + order.getOrderId());
		}
		else {
			System.out.println("Falha no processamento do pagamento para o pedido ID: " + order.getOrderId());
		}
	}

	public void displayPaymentInfo() {
		// Exemplo de exibição de informações de pagamento
		for (Payment payment : payments) {
			System.out.println("Pagamento ID: " + payment.getPaymentId() + ", Valor: $" + payment.getAmount()
					+ ", Data: " + payment.getDate());
		}
	}
}
