package com.academia.clinicaodontologica.model;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Entity
@Table(name = "appointments")
@Getter @Setter
public class Appointment {

    @Id
    @GeneratedValue
    private Long id;
    private Date date;

    @ManyToOne
    @JoinColumn(name="pacient_id", nullable = false)
    @JsonIgnoreProperties(value = {"appointments"})
    private Pacient pacient;

    @ManyToOne
    @JoinColumn(name="dentist_id", nullable = false)
    @JsonIgnoreProperties(value = {"appointments"})
    private Dentist dentist;

    public Appointment() {}

}

