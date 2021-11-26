package com.academia.clinicaodontologica.controller;

import com.academia.clinicaodontologica.exceptions.ResourceNotFoundException;
import com.academia.clinicaodontologica.model.DentistDTO;
import com.academia.clinicaodontologica.service.IDentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/dentists")
public class DentistController {

    @Autowired
    IDentistService dentistService;

    @PostMapping
    public ResponseEntity<?> addDentist(@RequestBody DentistDTO dentistDTO) {
        dentistService.createDentist(dentistDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public DentistDTO getDentist(@PathVariable long id){
        return dentistService.readDentist(id);

    }

    @PutMapping("/update")
    public ResponseEntity<?> updateDentist(@RequestBody DentistDTO dentistDTO) throws ResourceNotFoundException {
          dentistService.updateDentist(dentistDTO);
         return ResponseEntity.ok("Actualizado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDentist(@PathVariable long id) throws ResourceNotFoundException {
       dentistService.deleteDentist(id);
       return ResponseEntity.ok("Eliminado");

    }

    @GetMapping("/list")
    public Collection<DentistDTO> listDentists()
    {
        return dentistService.getAll();
    }


}

