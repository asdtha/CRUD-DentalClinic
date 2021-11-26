package com.academia.clinicaodontologica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pacients")
@Getter @Setter
public class Pacient {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;
    private String lastname;
    private String dni;
    private Date entryDate;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;


    @OneToMany(mappedBy = "pacient", cascade = CascadeType.ALL) // Pacient comunicate with dentist through Appointment
    @JsonIgnoreProperties(value = {"pacient"}) // to avoid an infinite cicle
    private Set<Appointment> appointments;

    public Pacient() {}

    public Pacient(String name, String lastname, String dni, Date entryDate, Address address) {
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
        this.entryDate = entryDate;
        this.address = address;
    }
}
