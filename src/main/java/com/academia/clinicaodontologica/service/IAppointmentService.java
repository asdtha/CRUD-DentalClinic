package com.academia.clinicaodontologica.service;

import com.academia.clinicaodontologica.exceptions.BadRequestException;
import com.academia.clinicaodontologica.model.AppointmentDTO;


import java.util.Collection;

public interface IAppointmentService {

    void createAppointment(AppointmentDTO app) throws BadRequestException;
    public AppointmentDTO readAppointment(Long id);
    public void updateAppointment(AppointmentDTO appointmentDTO);
    public void deleteAppointment(Long id);
    Collection<AppointmentDTO> getAll();

}
