package com.anna.persistence;

import com.anna.domain.Customer;
import java.util.List;

public interface CustomerRepository {

	List<Customer> findAll(); // Método para encontrar todos os clientes

	Customer findById(String id); // Método para encontrar um cliente por ID

	void save(Customer customer); // Método para salvar um cliente

}