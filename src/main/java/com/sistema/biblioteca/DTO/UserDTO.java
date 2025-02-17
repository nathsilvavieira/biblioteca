package com.sistema.biblioteca.DTO;


import com.sistema.biblioteca.model.Users;

public class UserDTO {

    private Long id;
    private String name;
    private String status;

    public UserDTO(Users user) {
        this.id = user.getId();
        this.name = user.getName();
        this.status = user.getStatus();
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
