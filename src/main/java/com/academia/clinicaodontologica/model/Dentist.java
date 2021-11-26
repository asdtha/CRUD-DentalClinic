package com.academia.clinicaodontologica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "dentists")
@Getter @Setter
public class Dentist {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String lastname;
    private Integer licenseNumber;

    @OneToMany(mappedBy = "dentist", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = {"dentist"})
    private Set<Appointment> appointments;

    public Dentist() {}


}

