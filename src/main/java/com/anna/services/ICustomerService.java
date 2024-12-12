package com.anna.services;

import com.anna.domain.CustomerDTO;
import java.util.List;

public interface ICustomerService {
    void createCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> getCustomers();
    void updateCustomer(Long id, CustomerDTO customerDTO);
    void deleteCustomer(Long id);
}
