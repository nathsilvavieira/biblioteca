package com.sistema.biblioteca.repository;

import com.sistema.biblioteca.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends JpaRepository<AddressModel, Long> {
}
