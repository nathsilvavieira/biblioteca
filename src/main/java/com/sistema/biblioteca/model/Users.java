package com.sistema.biblioteca.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name",nullable = false, length = 100)
    private String name;

    @Column(name = "doc",nullable = false, length = 100)
    private String doc;

    @Column(name = "type_doc",nullable = false, length = 50)
    private String type_doc;

    @Column(name = "email",nullable = false, length = 100)
    private String email;

    @Column(name = "telephone", length = 50)
    private String telephone;

    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name="status")
    private String status;

    /**
     * Relacionamento reverso (@OneToMany):
     * Na classe User, usamos @OneToMany com o atributo mappedBy = "user" para indicar o relacionamento reverso com a classe Address.
     * Adicionamos cascade = CascadeType.ALL para que as alterações em User sejam propagadas para os endereços associados.
     * orphanRemoval = true:
     * Isso garante que, se um endereço for removido da lista de endereços de um usuário, ele será excluído automaticamente do banco de dados.
     */

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AddressModel> addresses;

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

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getType_doc() {
        return type_doc;
    }

    public void setType_doc(String type_doc) {
        this.type_doc = type_doc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public List<AddressModel> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressModel> addresses) {
        this.addresses = addresses;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
