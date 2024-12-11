package com.anna.services;

import com.anna.domain.Customer;
import com.anna.domain.DomainCustomer;

public class CustomerService {

    // Método para converter um DomainCustomer para um Customer da domain
    public static Customer fromDomainCustomer(DomainCustomer domainCustomer) {
        if (domainCustomer == null) {
            return null;
        }
        return Customer.builder()
                .id(domainCustomer.getId()) // Converte apenas o ID
                .name(domainCustomer.getName())
                .email(domainCustomer.getEmail())
                .build();
    }

    // Método para converter Long para String
    public String convertLongToString(Long id) {
        return id == null ? null : id.toString();
    }
}