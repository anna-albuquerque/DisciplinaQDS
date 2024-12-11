@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    // Remova a importação direta
    // Use apenas o ID do cliente
    private Long customerId;

    // Remova a lista de OrderItem
    // Use apenas lista de IDs dos itens
    @ElementCollection
    private List<Long> orderItemIds = new ArrayList<>();

    // Método para adicionar ID de item do pedido
    public void addOrderItemId(Long orderItemId) {
        this.orderItemIds.add(orderItemId);
    }

    // Método para definir o ID do cliente
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}