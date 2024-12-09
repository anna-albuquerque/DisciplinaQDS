package com.anna.services;
import com.anna.domain.Customer as DomainCustomer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.Objects; // Importar a classe Objects

public class Customer {
    private final String id; // Imutável
    private String name;
    private String email;
    private final List<Order> orders; // Lista de ordens associada ao cliente

    // Construtor
    public Customer(String id, String name, String email) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format.");
        }

        this.id = id;
        this.name = name;
        this.email = email;
        this.orders = new ArrayList<>();
    }

    // Método para converter um Customer da domain para um da services
    public static Customer fromDomainCustomer(DomainCustomer domainCustomer) {
        if (domainCustomer == null) {
            return null;
        }
        return new Customer(
            domainCustomer.getId(), 
            domainCustomer.getName(), 
            domainCustomer.getEmail()
        );
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Order> getOrders() {
        return Collections.unmodifiableList(orders); // Retorna lista imutável
    }

    // Setters
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = name;
    }

    public void setEmail(String email) {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format.");
        }
        this.email = email;
    }

    // Método de Negócio para adicionar uma nova ordem
    public void placeOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }
        orders.add(order);
        System.out.println("Order placed by " + name + ": " + order);
    }

    // Validação de Email
    private static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    // Override de Métodos
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id.equals(customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", orders=" + orders.size() +
                '}';
    }
}