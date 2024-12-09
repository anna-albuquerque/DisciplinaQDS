package com.anna.persistence;

import com.anna.services.Customer;
import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
    Customer findById(String id);
    void save(Customer customer);
}
