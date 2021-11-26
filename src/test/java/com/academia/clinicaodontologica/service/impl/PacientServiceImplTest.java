package com.academia.clinicaodontologica.service.impl;

import com.academia.clinicaodontologica.model.PacientDTO;
import com.academia.clinicaodontologica.service.IPacientService;

import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class PacientServiceImplTest {

    @Autowired
    IPacientService pacientService;

    @Test
    public void testgetPacientWithLastNameLike()
    {
        PacientDTO pacient = new PacientDTO();
        pacient.setName("Thairy");
        pacient.setLastname("Daza");


        pacientService.createPacient(pacient);

        Set<PacientDTO> pacients = pacientService.getPacientWithLastNameLike("daza");
        boolean resultado = pacients.size() > 0;
        assertTrue(resultado);
    }

}