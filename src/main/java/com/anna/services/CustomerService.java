package com.anna.services;

import com.anna.domain.Customer;
import com.anna.domain.DomainCustomer;

public class CustomerService {

    // Método para converter um DomainCustomer para um Customer da domain
    public static Customer fromDomainCustomer(DomainCustomer domainCustomer) {
        if (domainCustomer == null) {
            return null;
        }
        Customer customer = new Customer();
        customer.setId(domainCustomer.getId()); // Chama o método setId para atribuir o valor
        customer.setName(domainCustomer.getName());
        customer.setEmail(domainCustomer.getEmail());
        return customer;
    }

    // Método para converter Long para String
    public String convertLongToString(Long id) {
        return id == null ? null : id.toString();
    }
}