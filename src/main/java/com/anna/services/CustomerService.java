package com.anna.services;

import com.anna.domain.Customer;

public class CustomerService {
    public Customer createCustomer(String name, String email) {
        return Customer.builder()
                .name(name)
                .email(email)
                .build();
    }

    public String convertLongToString(Long id) {
        return id == null ? null : id.toString();
    }
}