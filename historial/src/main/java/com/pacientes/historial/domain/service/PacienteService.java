package com.pacientes.historial.domain.service;

import com.pacientes.historial.domain.model.entity.PacienteEntity;
import com.pacientes.historial.domain.repository.PacientesRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Service

public class PacienteService {
    private final PacientesRepository pacientesRepository;


    public PacienteService(PacientesRepository pacientesRepository) {
        this.pacientesRepository = pacientesRepository;
    }

    public List<PacienteEntity> listarPacientes(){
        return pacientesRepository.findAll();


    }

}


