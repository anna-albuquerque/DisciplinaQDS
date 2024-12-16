package com.anna.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

public class OrderService {

	private List<Long> orderItemIds;

	private BigDecimal totalAmount;

public OrderService() {
    this.orderItemIds = new ArrayList<>();
}

	public void addProduct(Product product, int quantity) {
		if (product.updateStock(quantity)) {
			Long orderItemId = saveOrderItem(product, quantity);
			orderItemIds.add(orderItemId);
			calculateTotal();
		}
		else {
			System.out.println("Cannot add product " + product.getName() + " - insufficient stock.");
		}
		    orderItemIds.add(product.getId());
	}

	private Long saveOrderItem(Product product, int quantity) {
		OrderItem item = new OrderItem(orderItemIds.size() + 1, product, quantity);
		return (long) item.getItemId();
	}

	private void calculateTotal() {
		this.totalAmount = orderItemIds.stream()
			.map(orderItemId -> new OrderItem(orderItemId.intValue(), null, 0).getSubTotal())
			.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setCustomerId(Long customerId) {
		// this.customerId = customerId;
	}

}