package com.academia.clinicaodontologica.service.impl;

import com.academia.clinicaodontologica.model.Address;
import com.academia.clinicaodontologica.model.AddressDTO;
import com.academia.clinicaodontologica.repository.IAddressRepository;
import com.academia.clinicaodontologica.service.IAddressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    IAddressRepository addressRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void createAddress(AddressDTO add) {
        Address address = mapper.convertValue(add, Address.class);
        addressRepository.save(address);
    }

    @Override
    public AddressDTO readAddress(Long id) {
        AddressDTO addressDTO = null;
        Optional<Address> address = addressRepository.findById(id);
        if (address.isPresent()) {
            addressDTO = mapper.convertValue(address, AddressDTO.class);
        }
        return addressDTO;
    }

    @Override
    public void updateAddress(AddressDTO addressDTO) {
        Address address = mapper.convertValue(addressDTO, Address.class);
        addressRepository.save(address);
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public Collection<AddressDTO> getAll() {
        List<Address> addresses = addressRepository.findAll();
        Set<AddressDTO> addressesDTO = new HashSet<>();
        for (Address address : addresses) {
            addressesDTO.add(mapper.convertValue(address, AddressDTO.class));
        }
        return addressesDTO;
    }
}
