package com.anna.domain;
import com.anna.services.Product; 
import com.anna.services.OrderItem;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private String date;
    private BigDecimal totalAmount;
    private List<OrderItem> items;

    // Construtores
    public Order() {
        this.items = new ArrayList<>();
        this.totalAmount = BigDecimal.ZERO;
    }

    public Order(int orderId, String date, BigDecimal totalAmount, List<OrderItem> items) {
        this.orderId = orderId;
        this.date = date;
        this.totalAmount = totalAmount;
        this.items = items;
    }

    // Getters
    public int getOrderId() {
        return orderId;
    }

    public String getDate() {
        return date;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    // Setters
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    // Método para adicionar um produto
    public void addProduct(Product product, int quantity) {
        if (product.updateStock(quantity)) {
            OrderItem item = new OrderItem(items.size() + 1, product, quantity);
            items.add(item);
            calculateTotal(); // Atualiza o total após adicionar o produto
        } else {
            System.out.println("Cannot add product " + product.getName() + " - insufficient stock.");
        }
    }

    // Método para calcular o total do pedido
    public void calculateTotal() {
        this.totalAmount = items.stream()
            .map(OrderItem::getSubTotal)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Order total updated: $" + totalAmount);
    }

    // Método toString para facilitar a impressão
    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", date='" + date + '\'' +
                ", totalAmount=" + totalAmount +
                ", items=" + items +
                '}';
    }

    // Método equals para comparar ordens
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderId != order.orderId) return false;
        if (!date.equals(order.date)) return false;
        if (!totalAmount.equals(order.totalAmount)) return false;
        return items.equals(order.items);
    }

    // Método hashCode para garantir consistência com equals
    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + date.hashCode();
        result = 31 * result + totalAmount.hashCode();
        result = 31 * result + items.hashCode();
        return result;
    }
}