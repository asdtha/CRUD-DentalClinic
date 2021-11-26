package com.academia.clinicaodontologica.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


@Entity
@Table(name= "addresses")
@Getter @Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String street;
    private String number;
    private String district;
    private String province;

    @OneToOne(mappedBy = "address") // con mappedBy indicamos que el atributo domicilio del lado de la clase Pacient es quien establece la relacion
    @JsonIgnoreProperties(value = {"address"})
    private Pacient pacient;

    public Address() {}

    public Address(String street, String number, String district, String province) {
        this.street = street;
        this.number = number;
        this.district = district;
        this.province = province;

    }


}