package com.anna.controller;

import com.anna.services.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductController {
    private List<Product> products;

    public ProductController() {
        this.products = new ArrayList<>();
    }

    // Adicionar um novo produto
    public void addProduct(int productId, String name, double price, int stockQuantity) {
        if (price <= 0 || stockQuantity < 0) {
            System.out.println("Preço deve ser positivo e quantidade de estoque não pode ser negativa.");
            return;
        }
        Product product = new Product(productId, name, BigDecimal.valueOf(price), stockQuantity); // Converta price para BigDecimal
        products.add(product);
        System.out.println("Produto adicionado: " + name);
    }

    // Listar todos os produtos
    public void listProducts() {
        System.out.println("Lista de Produtos:");
        for (Product product : products) {
            System.out.println("ID: " + product.getProductId() + ", Nome: " + product.getName() + ", Preço: $" + product.getPrice() + ", Estoque: " + product.getStockQuantity());
        }
    }

    // Atualizar um produto existente
    public void updateProduct(int productId, String newName, double newPrice, int newStockQuantity) {
        if (newPrice <= 0 || newStockQuantity < 0) {
            System.out.println("Novo preço deve ser positivo e nova quantidade de estoque não pode ser negativa.");
            return;
        }
        for (Product product : products) {
            if (product.getProductId() == productId) {
                product.setName(newName);
                product.setPrice(BigDecimal.valueOf(newPrice)); // Converta newPrice para BigDecimal
                product.setStockQuantity(newStockQuantity);
                System.out.println("Produto atualizado: " + newName);
                return;
            }
        }
        System.out.println("Produto com ID " + productId + " não encontrado.");
    }

    // Deletar um produto
    public void deleteProduct(int productId) {
        products.removeIf(product -> product.getProductId() == productId);
        System.out.println("Produto com ID " + productId + " deletado.");
    }

    // Obter um produto por ID
    public Product getProductById(int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) return product;
        }
        return null;
    }
}