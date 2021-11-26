package com.academia.clinicaodontologica.service.impl;

import com.academia.clinicaodontologica.exceptions.ResourceNotFoundException;
import com.academia.clinicaodontologica.model.Dentist;
import com.academia.clinicaodontologica.model.DentistDTO;
import com.academia.clinicaodontologica.repository.IDentistRepository;
import com.academia.clinicaodontologica.service.IDentistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class DentistServiceImpl implements IDentistService {

    @Autowired
    IDentistRepository dentistRepository;

    @Autowired
    ObjectMapper mapper;

    public void createDentist(DentistDTO dent) {
        Dentist dentist = mapper.convertValue(dent, Dentist.class);
        dentistRepository.save(dentist);
    }

    public DentistDTO readDentist(Long id)  {
        DentistDTO dentistDTO = null;
        Optional<Dentist> dentist = dentistRepository.findById(id);
        if(dentist.isPresent()){
            dentistDTO = mapper.convertValue(dentist, DentistDTO.class);
        }
        return dentistDTO;
    }

    public void updateDentist(DentistDTO dentistDTO) throws ResourceNotFoundException{
        Dentist dentist = mapper.convertValue(dentistDTO,Dentist.class);
        if (dentistRepository.getById(dentistDTO.getId()) == null)
            throw new ResourceNotFoundException("No existe un dentita con el id: " + dentistRepository.getById(dentistDTO.getId()));
        dentistRepository.save(dentist);
    }

    public void deleteDentist(Long id) throws ResourceNotFoundException {
        if (dentistRepository.findById(id) == null)
            throw new ResourceNotFoundException("No existe un dentista con el id: " + id);
        dentistRepository.deleteById(id);
    }

    public Collection<DentistDTO> getAll()
    {
        List<Dentist> dentists = dentistRepository.findAll();
        Set<DentistDTO> dentistsDTO = new HashSet<>();
        for(Dentist dentist : dentists){
           dentistsDTO.add(mapper.convertValue(dentist,DentistDTO.class));
        }
        return dentistsDTO;
    }

}


