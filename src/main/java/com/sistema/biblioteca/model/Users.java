package com.sistema.biblioteca.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.*;


import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @NotBlank(message = "Não pode ser vazio")
    @Size(min=1,max=100)
    private String name;


    @NotBlank(message = "Campo não pode ser vazio")
    @Size(min=1,max=100)
    private String doc;

    @NotBlank(message = "Campo não pode ser vazio")
    @Size(min=1,max=50)
    private String type_doc;

    @NotBlank(message = "Campo não pode ser vazio")
    @Size(min=1,max=100)
    private String email;

    @NotBlank(message = "Campo não pode ser vazio")
    @Size(min=1,max=100)
    private String telephone;

    @Past
    private Date birthdate;

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
