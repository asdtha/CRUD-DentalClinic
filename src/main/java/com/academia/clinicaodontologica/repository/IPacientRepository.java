package com.academia.clinicaodontologica.repository;

import com.academia.clinicaodontologica.model.Pacient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IPacientRepository extends JpaRepository<Pacient, Long> {

    @Query("from Pacient s where s.lastname like %:lastname%")
    Set<Pacient> getPacientByLastNameLike(@Param("lastname")String lastname);
}
