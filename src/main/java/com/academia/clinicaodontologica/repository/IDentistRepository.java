package com.academia.clinicaodontologica.repository;

import com.academia.clinicaodontologica.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDentistRepository extends JpaRepository<Dentist, Long> {

}
