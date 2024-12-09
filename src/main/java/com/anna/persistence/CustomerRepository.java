package com.anna.persistence;

import com.anna.domain.Customer;
import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
    Customer findById(String id);
    void save(Customer customer);
}
