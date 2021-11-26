package com.academia.clinicaodontologica.controller;
import com.academia.clinicaodontologica.exceptions.BadRequestException;
import com.academia.clinicaodontologica.exceptions.ResourceNotFoundException;
import com.academia.clinicaodontologica.model.AppointmentDTO;
import com.academia.clinicaodontologica.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    IAppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<?> addAppointment(@RequestBody AppointmentDTO appointmentDTO) throws BadRequestException {
        appointmentService.createAppointment(appointmentDTO);
        return ResponseEntity.ok("Turno registrado exitosamente");
    }
    @GetMapping("/{id}")
    public AppointmentDTO getAppointment(@PathVariable long id)
    {
        return appointmentService.readAppointment(id);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateAppointment(@RequestBody AppointmentDTO appointmentDTO)
    {
        appointmentService.updateAppointment(appointmentDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAppointment(@PathVariable long id) throws ResourceNotFoundException {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.ok("Turno eliminado exitosamente");

    }


    @GetMapping("/list")
    public Collection<AppointmentDTO> listAppointments()
    {
        return appointmentService.getAll();
    }

}
