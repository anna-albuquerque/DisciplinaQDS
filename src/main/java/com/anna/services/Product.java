package com.anna.services;

import java.math.BigDecimal;

public class Product {

	private int productId;

	private String name;

	private BigDecimal price;

	private int stockQuantity;

	public Product(int productId, String name, BigDecimal price, int stockQuantity) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}

	public boolean updateStock(int quantity) {
		if (stockQuantity >= quantity) {
			stockQuantity -= quantity;
			System.out.println("Stock updated for product: " + name);
			return true;
		}
		else {
			System.out.println("Insufficient stock for product: " + name);
			return false;
		}
	}

	public int getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

}