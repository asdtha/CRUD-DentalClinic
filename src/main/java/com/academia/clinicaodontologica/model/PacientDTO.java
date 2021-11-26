package com.academia.clinicaodontologica.model;


import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PacientDTO {

        private Long id;
        private String name;
        private String lastname;
        private String dni;
        private Date entryDate;
        private Address address;

    }
