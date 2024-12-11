@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be null or empty")
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    // Remova a referência direta para Order
    // Use apenas IDs dos pedidos
    @ElementCollection
    private List<Long> orderIds = new ArrayList<>();

    // Método para adicionar ID de pedido
    public void addOrderId(Long orderId) {
        this.orderIds.add(orderId);
    }
}