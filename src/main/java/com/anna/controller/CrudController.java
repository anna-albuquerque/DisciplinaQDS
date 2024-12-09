package com.anna.controller;
import com.anna.services.Customer;
import com.anna.services.Order;

import java.util.Objects;
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
        if (name == null || email == null) {
            System.out.println("Nome e e-mail são obrigatórios para criar um cliente.");
            return;
        }
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
        if (date == null || customer == null) {
            System.out.println("Data e cliente são obrigatórios para criar um pedido.");
            return;
        }
        Order order = new Order(orderId, date);
        orders.add(order);
        customer.placeOrder(order); // Certifique-se de que o método 'placeOrder' adiciona o pedido à lista do cliente
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
    public void updateOrder(int orderId, com.anna.services.Product product, int quantity) {
        if (product == null || quantity <= 0) {
            System.out.println("Produto inválido ou quantidade não positiva.");
            return;
        }
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
            if (String.valueOf(customer.getId()).equals(String.valueOf(id))) {
                return customer;
            }
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