package com.academia.clinicaodontologica.model;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DentistDTO {

    private Long id;
    private String name;
    private String lastname;
    private Integer licenseNumber;

}
