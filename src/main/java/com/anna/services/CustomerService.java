package com.anna.services;

import com.anna.domain.Customer;

public class CustomerService {
    public Customer createCustomer(String name, String email) {
        if (name == null || email == null) {
            System.out.println("Nome e e-mail são obrigatórios para criar um cliente.");
            return null; // Retorna null se algum campo estiver faltando
        }

        // Criação do Customer manualmente com construtores adequados ou setters
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        return customer;
    }

    public String convertLongToString(Long id) {
        return id == null ? null : id.toString();
    }
}
