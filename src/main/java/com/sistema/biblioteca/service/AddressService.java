package com.sistema.biblioteca.service;

import com.sistema.biblioteca.model.AddressModel;
import com.sistema.biblioteca.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    IAddressRepository addressRepository;

    public List<AddressModel> findAllAddress(){
        return addressRepository.findAll();
    }

    public Optional<AddressModel> findAddressById(Long id){
        return addressRepository.findById(id);
    }

    public AddressModel saveAddress(AddressModel address){
        return addressRepository.save(address);
    }

    public void deleteAddress(Long id){
        if(addressRepository.existsById(id)){
            addressRepository.deleteById(id);
        }
    }
}
