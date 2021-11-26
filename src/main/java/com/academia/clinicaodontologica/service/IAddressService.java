package com.academia.clinicaodontologica.service;

import com.academia.clinicaodontologica.model.AddressDTO;



import java.util.Collection;

public interface IAddressService {

    void createAddress(AddressDTO add);
    public AddressDTO readAddress(Long id);
    public void updateAddress(AddressDTO addressDTO);
    public void deleteAddress(Long id);
    public Collection<AddressDTO> getAll();
}
