package com.anna.persistence;

import com.anna.domain.Order;
import java.util.List;

public interface OrderRepository {

	List<Order> findAll(); // Método para encontrar todas as ordens

	Order findById(int orderId); // Método para encontrar uma ordem por ID

	void save(Order order); // Método para salvar uma ordem

}