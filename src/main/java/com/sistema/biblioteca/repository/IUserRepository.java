package com.sistema.biblioteca.repository;


import com.sistema.biblioteca.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<Users, Long> {

    @Query("SELECT u FROM Users AS u WHERE u.status = 'Ativo' ORDER BY u.name ASC")
    List<Users> findByStatusActive();

    // metodo busca que contem nome

}
