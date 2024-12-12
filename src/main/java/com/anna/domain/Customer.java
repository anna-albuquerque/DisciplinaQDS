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

    public void addOrderId(Long orderId) {
        this.orderIds.add(orderId);
    }

}