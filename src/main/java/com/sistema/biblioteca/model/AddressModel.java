package com.sistema.biblioteca.model;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class AddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    /**
     * Chave estrangeira (@ManyToOne):
     * Na classe Address, usamos @ManyToOne para declarar que vários endereços podem estar associados a um único usuário.
     * @JoinColumn(name = "user_id") especifica que a coluna user_id será usada como chave estrangeira para a tabela users.
     */
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Column(name = "type",nullable = false, length = 100)
    private String type;

    @Column(name = "street",nullable = false, length = 100)
    private String street;

    @Column(name = "complement",length = 100)
    private String complement;

    @Column(name = "number",nullable = false)
    private int number;

    @Column(name = "zipcode",nullable = false, length = 50)
    private String zipcode;

    @Column(name = "city",nullable = false, length = 100)
    private String city;

    @Column(name = "state",nullable = false, length = 2)
    private String state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
