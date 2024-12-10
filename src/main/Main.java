package com.anna.service;
import com.anna.controller.CrudController;
import com.anna.controller.PaymentController;
import com.anna.controller.ProductController;
import java.util.Date;
import java.util.Date;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }

    //public static void main(String[] args) {
        // Criando produtos
        //Product product1 = new Product(1, "Laptop", 1500.00, 10);
        //Product product2 = new Product(2, "Phone", 800.00, 5);

        // Criando cliente
        //Customer customer = new Customer(1, "Alice", "alice@example.com");

        // Criando pedido
        //Order order = new Order(1, new Date());
        //order.addProduct(product1, 2);
        //order.addProduct(product2, 1);

        // Associando pedido ao cliente
        //customer.placeOrder(order);

        // Processando pagamento
        //Payment payment = new Payment(1, order.getTotalAmount(), new Date());
        //if (payment.processPayment()) {
            //System.out.println("Payment successful!");
        //} else {
            //System.out.println("Payment failed!");
        //}

        // Inicializando controladores
        //CrudController crudController = new CrudController();
        //ProductController productController = new ProductController();
        //PaymentController paymentController = new PaymentController();

        // --- Gerenciamento de Produtos ---
        //productController.addProduct(1, "Laptop", 1500.00, 10);
        //productController.addProduct(2, "Phone", 800.00, 5);
        //productController.listProducts();

        // --- Gerenciamento de Clientes ---
        //crudController.createCustomer(1, "Alice", "alice@example.com");
        //crudController.createCustomer(2, "Bob", "bob@example.com");
        //crudController.readCustomers();

        // --- Gerenciamento de Pedidos ---
        //Customer customer = crudController.getCustomerById(1);
        //if (customer != null) {
        //  crudController.createOrder(1, new Date(), customer);

            // Adicionando produtos ao pedido
            //Order order = crudController.getOrderById(1);
            //if (order != null) {
                //Product laptop = productController.getProductById(1);
                //Product phone = productController.getProductById(2);

                //if (laptop != null) {
                    //crudController.updateOrder(order.getOrderId(), laptop, 2);
                //}

                //if (phone != null) {
                    //crudController.updateOrder(order.getOrderId(), phone, 1);
                //}

                // Atualizando total do pedido já ocorre no método addProduct

                // --- Processando Pagamento ---
                //paymentController.processPayment(1, order, new Date());
                //paymentController.listPayments();
            //}
        //}

        // --- Atualizando e Deletando Exemplos ---
        //crudController.updateCustomer(1, "Alice Smith", "alice.smith@example.com");
        //crudController.readCustomers();

        //productController.updateProduct(2, "Smartphone", 850.00, 4);
        //productController.listProducts();

        //crudController.deleteOrder(1);
        //crudController.readOrders();

        //crudController.deleteCustomer(2);
        //crudController.readCustomers();

        //productController.deleteProduct(1);
        //productController.listProducts();
    //}
}