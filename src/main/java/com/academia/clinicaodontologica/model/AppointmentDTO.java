package com.academia.clinicaodontologica.model;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter @Getter
public class AppointmentDTO {

    private Long id;
    private Date date;
    private Pacient pacient;
    private Dentist dentist;

}
