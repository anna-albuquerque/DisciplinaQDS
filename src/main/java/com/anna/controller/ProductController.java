package com.anna.controller;
import com.anna.services.Product;

import java.util.ArrayList;
import java.util.List;

private int productId;
private int stockQuantity;

public int getProductId() {
    return productId;
}

public void setProductId(int productId) { 
    this.productId = productId; 
}

public int getStockQuantity() { 
    return stockQuantity; 
}

public void setStockQuantity(int stockQuantity) {
    this.stockQuantity = stockQuantity; 
}

public class ProductController {
    private List<Product> products;


    public ProductController() {
        this.products = new ArrayList<>();
    }

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }
    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }
   

    // Adicionar um novo produto
    public void addProduct(int productId, String name, double price, int stockQuantity) {
        Product product = new Product(productId, name, price, stockQuantity);
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
        for (Product product : products) {
            if (product.getProductId() == productId) {
                product.setName(newName);
                product.setPrice(newPrice);
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