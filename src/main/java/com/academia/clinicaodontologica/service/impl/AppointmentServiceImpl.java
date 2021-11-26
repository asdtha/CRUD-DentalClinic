package com.academia.clinicaodontologica.service.impl;

import com.academia.clinicaodontologica.exceptions.BadRequestException;
import com.academia.clinicaodontologica.model.Appointment;
import com.academia.clinicaodontologica.model.AppointmentDTO;
import com.academia.clinicaodontologica.repository.IAppointmentRepository;
import com.academia.clinicaodontologica.service.IAppointmentService;
import com.academia.clinicaodontologica.service.IDentistService;
import com.academia.clinicaodontologica.service.IPacientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AppointmentServiceImpl implements IAppointmentService {

    @Autowired
    IAppointmentRepository appointmentRepository;
    private IPacientService pacientService;
    private IDentistService dentistService;

    @Autowired
    ObjectMapper mapper;

    // Con esto hacemos la asociación entre paciente y odontologo
    @Override
    public void createAppointment(AppointmentDTO appointmentDTO) throws BadRequestException {
        Appointment appointment = mapper.convertValue(appointmentDTO, Appointment.class);
        if (pacientService.readPacient(appointmentDTO.getPacient().getId()) == null || dentistService.readDentist(appointmentDTO.getDentist().getId()) == null)
            throw new BadRequestException("El paciente o el odontologo no existen");
               appointmentRepository.save(appointment);
    }

    @Override
    public AppointmentDTO readAppointment(Long id) {
        AppointmentDTO appointmentDTO = null;
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if(appointment.isPresent()){
            appointmentDTO = mapper.convertValue(appointment, AppointmentDTO.class);
        }
        return appointmentDTO;
    }

    @Override
    public void updateAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = mapper.convertValue(appointmentDTO, Appointment.class);
        appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }


    @Override
    public Collection<AppointmentDTO> getAll() {
            List<Appointment> appointments = appointmentRepository.findAll();

            Set<AppointmentDTO> appointmentsDTO = new HashSet<>();
            for(Appointment appointment : appointments){
                appointmentsDTO.add(mapper.convertValue(appointment,AppointmentDTO.class));
            }
            return appointmentsDTO;

    }
}
