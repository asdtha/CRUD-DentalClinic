package com.academia.clinicaodontologica.controller;

import com.academia.clinicaodontologica.model.AddressDTO;
import com.academia.clinicaodontologica.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    IAddressService addressService;

    @PostMapping
    public ResponseEntity<?> addAddress(@RequestBody AddressDTO addressDTO){
        addressService.createAddress(addressDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public AddressDTO getAddress(@PathVariable long id)
    {
        return addressService.readAddress(id);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateAddress(@RequestBody AddressDTO addressDTO)
    {
        ResponseEntity response = null;
        if (addressService.readAddress(addressDTO.getId()) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            addressService.updateAddress(addressDTO);
            response = new ResponseEntity(HttpStatus.OK);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable long id) {
        ResponseEntity response = null;
        if (addressService.readAddress(id) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            addressService.deleteAddress(id);
            response = new ResponseEntity(HttpStatus.OK);
        }
        return response;
    }

    @GetMapping("/list")
    public Collection<AddressDTO> listAddresses()
    {
        return addressService.getAll();
    }





}
