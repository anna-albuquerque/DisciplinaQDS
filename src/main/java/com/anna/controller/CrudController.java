package com.anna.controller;
import com.anna.services.Customer;
import com.anna.services.Order;

import java.util.ArrayList;
import java.util.List;

public class CrudController {
    private List<Customer> customers;
    private List<Order> orders;

    public CrudController() {
        this.customers = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    // --- Operações para Customer ---

    // Criar um novo cliente
    public void createCustomer(int id, String name, String email) {
        Customer customer = new Customer(id, name, email);
        customers.add(customer);
        System.out.println("Cliente criado: " + name);
    }

    // Ler todos os clientes
    public void readCustomers() {
        System.out.println("Lista de Clientes:");
        for (Customer customer : customers) {
            System.out.println("ID: " + customer.getId() + ", Nome: " + customer.getName() + ", Email: " + customer.getEmail());
        }
    }

    // Atualizar um cliente existente
    public void updateCustomer(int id, String newName, String newEmail) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                customer.setName(newName);
                customer.setEmail(newEmail);
                System.out.println("Cliente atualizado: " + newName);
                return;
            }
        }
        System.out.println("Cliente com ID " + id + " não encontrado.");
    }

    // Deletar um cliente
    public void deleteCustomer(int id) {
        customers.removeIf(customer -> customer.getId() == id);
        System.out.println("Cliente com ID " + id + " deletado.");
    }

    // --- Operações para Order ---

    // Criar um novo pedido
    public void createOrder(int orderId, java.util.Date date, Customer customer) {
        Order order = new Order(orderId, date);
        orders.add(order);
        customer.placeOrder(order);
        System.out.println("Pedido criado com ID: " + orderId + " para o cliente: " + customer.getName());
    }

    // Ler todos os pedidos
    public void readOrders() {
        System.out.println("Lista de Pedidos:");
        for (Order order : orders) {
            System.out.println("Pedido ID: " + order.getOrderId() + ", Data: " + order.getDate() + ", Total: $" + order.getTotalAmount());
        }
    }

    // Atualizar um pedido existente (exemplo: adicionar produtos)
    public void updateOrder(int orderId, com.example.service.Product product, int quantity) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                order.addProduct(product, quantity);
                System.out.println("Produto adicionado ao pedido ID: " + orderId);
                return;
            }
        }
        System.out.println("Pedido com ID " + orderId + " não encontrado.");
    }

    // Deletar um pedido
    public void deleteOrder(int orderId) {
        orders.removeIf(order -> order.getOrderId() == orderId);
        System.out.println("Pedido com ID " + orderId + " deletado.");
    }

    // Métodos auxiliares para obter clientes e pedidos
    public Customer getCustomerById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) return customer;
        }
        return null;
    }

    public Order getOrderById(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) return order;
        }
        return null;
    }
}