package com.academia.clinicaodontologica.service.impl;
import com.academia.clinicaodontologica.model.Pacient;
import com.academia.clinicaodontologica.model.PacientDTO;
import com.academia.clinicaodontologica.repository.IPacientRepository;
import com.academia.clinicaodontologica.service.IPacientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PacientServiceImpl implements IPacientService {

    @Autowired
    IPacientRepository pacientRepository;

    @Autowired
    ObjectMapper mapper;

    public void createPacient(PacientDTO pac) {
        Pacient pacient = mapper.convertValue(pac, Pacient.class);
        pacientRepository.save(pacient);
    }

    public PacientDTO readPacient(Long id)     {
        PacientDTO pacientDTO = null;
        Optional<Pacient> pacient = pacientRepository.findById(id);
        if(pacient.isPresent()){
            pacientDTO = mapper.convertValue(pacient, PacientDTO.class);
        }
        return pacientDTO;
    }

    public void updatePacient(PacientDTO pacientDTO){
        Pacient pacient = mapper.convertValue(pacientDTO, Pacient.class);
       pacientRepository.save(pacient);
    }

    public void deletePacient(Long id)
    {
        pacientRepository.deleteById(id);
    }

    public Collection<PacientDTO> getAll()
    {
        List<Pacient> pacients = pacientRepository.findAll();
        Set<PacientDTO> pacientsDTO = new HashSet<>();
            for(Pacient pacient : pacients){
            pacientsDTO.add(mapper.convertValue(pacient,PacientDTO.class));
        }
        return pacientsDTO;
    }

    public Set<PacientDTO> getPacientWithLastNameLike(String lastname) {

        Set<Pacient> pacients = pacientRepository.getPacientByLastNameLike(lastname);
        Set<PacientDTO> pacientsDTO = new HashSet<>();
        for (Pacient pacient : pacients) {
            pacientsDTO.add(mapper.convertValue(pacient,PacientDTO.class));
        }
        return pacientsDTO;
    }

}

