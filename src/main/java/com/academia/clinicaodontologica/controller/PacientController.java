package com.academia.clinicaodontologica.controller;


import com.academia.clinicaodontologica.model.PacientDTO;
import com.academia.clinicaodontologica.service.IPacientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/pacients")
public class PacientController {

    @Autowired
    IPacientService pacientService;

    @PostMapping
    public ResponseEntity<?> addPacient(@RequestBody PacientDTO pacientDTO) {
        pacientService.createPacient(pacientDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PacientDTO getPacient(@PathVariable long id) {
       return pacientService.readPacient(id);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updatePacient(@RequestBody PacientDTO pacientDTO)
    {
        ResponseEntity response = null;
        if (pacientService.readPacient(pacientDTO.getId()) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            pacientService.updatePacient(pacientDTO);
            response = new ResponseEntity(HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePacient(@PathVariable long id) {
        ResponseEntity response = null;
        if (pacientService.readPacient(id) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            pacientService.deletePacient(id);
            response = new ResponseEntity(HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Erased");
    }

    @GetMapping("/list")
    public Collection<PacientDTO> listPacients()
    {
        return pacientService.getAll();
    }

    @GetMapping("/listlastname")
    public Set<PacientDTO> listPacients(@RequestParam String lastname)
    {
        return pacientService.getPacientWithLastNameLike(lastname);
    }

}

