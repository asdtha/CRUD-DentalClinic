package com.academia.clinicaodontologica.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AddressDTO {
    private Long id;
    private String street;
    private String number;
    private String district;
    private String province;
    private Pacient pacient;
}
