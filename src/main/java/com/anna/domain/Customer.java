package com.anna.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Name cannot be null or empty")
	private String name;

	@Email(message = "Invalid email format")
	private String email;

	@ElementCollection
	private List<Long> orderIds = new ArrayList<>();

	public Customer() {
		// Construtor padrão necessário para o Hibernate ou outras operações de ORM
	}

	public Customer(String name, String email) {
		this.name = name;
		this.email = email;
		this.orderIds = new ArrayList<>(); // Inicializa uma nova lista para ordersIds
	}

	public void addOrderId(Long orderId) {
		this.orderIds.add(orderId);
	}

	// Getters e setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Long> getOrderIds() {
		return orderIds;
	}

	public void setOrderIds(List<Long> orderIds) {
		this.orderIds = orderIds;
	}

}
