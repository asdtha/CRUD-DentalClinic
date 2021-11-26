package com.academia.clinicaodontologica.service;

import com.academia.clinicaodontologica.exceptions.ResourceNotFoundException;
import com.academia.clinicaodontologica.model.DentistDTO;


import java.util.Collection;
import java.util.Set;

public interface IDentistService {

    public void createDentist(DentistDTO dent);
    public DentistDTO readDentist(Long id);
    public void updateDentist(DentistDTO dentistDTO) throws ResourceNotFoundException;
    public void deleteDentist(Long id) throws ResourceNotFoundException;
    public Collection<DentistDTO> getAll();


}
