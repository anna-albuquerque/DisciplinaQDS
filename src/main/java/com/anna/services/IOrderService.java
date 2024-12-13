package com.anna.services;

import com.anna.domain.OrderDTO;
import java.util.List;

public interface IOrderService {
    void createOrder(OrderDTO orderDTO);
    List<OrderDTO> getOrders();
    void updateOrder(Long id, OrderDTO orderDTO);
    void deleteOrder(Long id);
}
