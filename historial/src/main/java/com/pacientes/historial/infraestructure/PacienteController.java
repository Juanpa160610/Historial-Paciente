package com.pacientes.historial.infraestructure;

import com.pacientes.historial.domain.model.entity.PacienteEntity;
import com.pacientes.historial.domain.service.PacienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/historial")


public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping

    public List<PacienteEntity> listarPacientes(){
        return pacienteService.listarPacientes();

    }
}





