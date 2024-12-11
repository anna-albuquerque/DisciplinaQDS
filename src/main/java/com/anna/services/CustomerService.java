package com.anna.services;

import com.anna.domain.Customer;

public class CustomerService {
    // Remover referência a DomainCustomer
    public Customer createCustomer(String name, String email) {
        return Customer.builder()
                .name(name)
                .email(email)
                .build();
    }

    // Converter ID para string mantido
    public String convertLongToString(Long id) {
        return id == null ? null : id.toString();
    }
}