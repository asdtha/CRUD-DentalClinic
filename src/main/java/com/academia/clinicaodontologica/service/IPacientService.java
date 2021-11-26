package com.academia.clinicaodontologica.service;
import com.academia.clinicaodontologica.model.PacientDTO;
import java.util.*;

public interface IPacientService {

    public void createPacient(PacientDTO pac);
    public PacientDTO readPacient(Long id);
    public void updatePacient(PacientDTO pacientDTO);
    public void deletePacient(Long id);
    public Collection<PacientDTO> getAll();

    public Set<PacientDTO> getPacientWithLastNameLike(String lastname);
}
