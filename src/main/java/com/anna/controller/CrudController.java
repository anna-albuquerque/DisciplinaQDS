package com.anna.controller;

import com.anna.services.ICustomerService;
import com.anna.services.IOrderService;
import com.anna.dto.CustomerDTO;
import com.anna.dto.OrderDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crud")
public class CrudController {

    private final ICustomerService customerService;
    private final IOrderService orderService;

    public CrudController(ICustomerService customerService, IOrderService orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
    }

    // --- Operações para Customer ---

    @PostMapping("/customers")
    public ResponseEntity<Void> createCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.createCustomer(customerDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDTO>> getCustomers() {
        List<CustomerDTO> customers = customerService.getCustomers();
        return ResponseEntity.ok(customers);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Void> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        customerService.updateCustomer(id, customerDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }

    // --- Operações para Order ---

    @PostMapping("/orders")
    public ResponseEntity<Void> createOrder(@RequestBody OrderDTO orderDTO) {
        orderService.createOrder(orderDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<Void> updateOrder(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        orderService.updateOrder(id, orderDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }
}