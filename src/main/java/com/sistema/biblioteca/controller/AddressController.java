package com.sistema.biblioteca.controller;

import com.sistema.biblioteca.model.AddressModel;
import com.sistema.biblioteca.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping
    List<AddressModel> findAllAddress(){
        return addressService.findAllAddress();
    }

    @GetMapping("/{id}")
    public Optional<AddressModel> findAddressById(@PathVariable Long id){
        return addressService.findAddressById(id);
    }

    @PostMapping
    public AddressModel saveAddress(@RequestBody AddressModel addressModel){
        return addressService.saveAddress(addressModel);
    }
    @PutMapping
    public AddressModel updateAddress(@RequestBody AddressModel addressModel){
        return addressService.saveAddress(addressModel);
    }
    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id){}
}
