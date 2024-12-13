package com.anna.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;

	private Long customerId;

	@ElementCollection
	private List<Long> orderItemIds = new ArrayList<>();

	private BigDecimal totalAmount; // Adicionei um campo para o totalAmount

	public Long getOrderId() {
		return orderId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void addOrderItemId(Long orderItemId) {
		this.orderItemIds.add(orderItemId);
	}

	// Outros atributos e métodos relacionados ao pedido

}
