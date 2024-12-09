package com.anna.controller;

import com.anna.domain.Customer;
import com.anna.domain.Order;
import com.anna.services.Product;
import com.anna.services.OrderItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CrudController {

    private List<Customer> customers = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    // --- Operações para Customer ---

    // Criar um novo cliente
    public void createCustomer(String id, String name, String email) {
        if (name == null || email == null) {
            System.out.println("Nome e e-mail são obrigatórios para criar um cliente.");
            return;
        }
        // Ajuste: Criando uma nova instância de Customer com os parâmetros necessários
        Customer customer = new Customer("Nome", "Endereço", "Telefone");
    }

    // Ler todos os clientes
    public void readCustomers() {
        System.out.println("Lista de Clientes:");
        for (Customer customer : customers) {
            System.out.println("ID: " + customer.getId() + ", Nome: " + customer.getName() + ", Email: " + customer.getEmail());
        }
    }

    // Atualizar um cliente existente
    public void updateCustomer(Long id, String newName, String newEmail) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                customer.setName(newName);
                customer.setEmail(newEmail);
                System.out.println("Cliente atualizado: " + newName);
                return;
            }
        }
        System.out.println("Cliente com ID " + id + " não encontrado.");
    }

    // Deletar um cliente
    public void deleteCustomer(Long id) {
        customers.removeIf(customer -> customer.getId().equals(id));
        System.out.println("Cliente com ID " + id + " deletado.");
    }

    // --- Operações para Order ---

// Criar um novo pedido
public void createOrder(String customerName) {
    int orderId = orders.size() + 1; // Ajuste: Criação de pedido sequencial
    String date = new Date().toString(); // Obtendo a data atual como uma string

    // Ajuste: Criando uma nova instância de Order com os parâmetros necessários
    Order order = new Order(orderId, date, BigDecimal.ZERO, new ArrayList<OrderItem>());
    orders.add(order); // Adicionando o pedido à lista de pedidos

    // Adicionando produtos ao pedido
    Product product = new Product(1, "Produto Exemplo", BigDecimal.valueOf(100.0), 10);
    int quantity = 2;
    order.addProduct(product, quantity); // Supondo que o método 'addProduct' aceite um produto e uma quantidade
}

// Atualizar um pedido existente (exemplo: adicionar produtos)
public void updateOrder(int orderId, Product product, int quantity) {
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
    public Customer getCustomerById(Long id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
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
