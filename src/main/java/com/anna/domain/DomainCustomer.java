package com.anna.domain;

public class DomainCustomer {
    private Long id; // ID do cliente
    private String name; // Nome do cliente
    private String email; // Email do cliente
    private String phone; // Telefone do cliente

    // Construtor padrão
    public DomainCustomer() {
    }

    // Construtor com parâmetros
    public DomainCustomer(Long id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Outros métodos, como toString, equals, hashCode, etc.
    @Override
    public String toString() {
        return "DomainCustomer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DomainCustomer that = (DomainCustomer) o;

        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        if (!email.equals(that.email)) return false;
        return phone.equals(that.phone);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + phone.hashCode();
        return result;
    }
}