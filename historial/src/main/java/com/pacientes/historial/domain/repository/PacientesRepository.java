package com.pacientes.historial.domain.repository;

import com.pacientes.historial.domain.model.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PacientesRepository extends JpaRepository<PacienteEntity, Integer> {


}
