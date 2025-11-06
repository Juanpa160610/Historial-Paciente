package com.pacientes.historial.domain.service;

import com.pacientes.historial.domain.model.entity.DTO.PacienteDTO;
import com.pacientes.historial.domain.model.entity.PacienteEntity;
import com.pacientes.historial.domain.repository.PacientesRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class PacienteService {
    private final PacientesRepository pacientesRepository;


    public PacienteService(PacientesRepository pacientesRepository) {
        this.pacientesRepository = pacientesRepository;
    }

    public List<PacienteEntity> listarPacientes(){
        return pacientesRepository.findAll();

    }


    public PacienteDTO crearPaciente(PacienteDTO dto) {
        PacienteEntity entity = new PacienteEntity();
        entity.setNombre(dto.getNombre());
        entity.setEdad(dto.getEdad());
        entity.setHistorial(dto.getHistorial());
        entity.setTratamiento(dto.getTratamiento());
        entity.setFechaRegistro(dto.getFechaRegistro());

        PacienteEntity saved = pacientesRepository.save(entity);

        PacienteDTO result = new PacienteDTO();
        result.setId(saved.getId());
        result.setNombre(saved.getNombre());
        result.setEdad(saved.getEdad());
        result.setHistorial(saved.getHistorial());
        result.setTratamiento(saved.getTratamiento());
        result.setFechaRegistro(saved.getFechaRegistro());

        return result;
    }

    //de aqui para abajo en el Service es el resto del CRUD que quise terminar. Lo vamos hacer importando y  usando el Optional

    public PacienteDTO actualizarPaciente(Long id, PacienteDTO dto) {
        Optional<PacienteEntity> optionalPaciente = pacientesRepository.findById(Math.toIntExact(id));

        if (optionalPaciente.isEmpty()) {
            System.out.println("Paciente con id " + id + " no encontrado");
            return null; // o podrías devolver un DTO vacío
        }
        PacienteEntity entity = optionalPaciente.get();
        entity.setNombre(dto.getNombre());
        entity.setEdad(dto.getEdad());
        entity.setHistorial(dto.getHistorial());
        entity.setTratamiento(dto.getTratamiento());
        entity.setFechaRegistro(dto.getFechaRegistro());

        PacienteEntity updated = pacientesRepository.save(entity);

        PacienteDTO result = new PacienteDTO();
        result.setId(updated.getId());
        result.setNombre(updated.getNombre());
        result.setEdad(updated.getEdad());
        result.setHistorial(updated.getHistorial());
        result.setTratamiento(updated.getTratamiento());
        result.setFechaRegistro(updated.getFechaRegistro());

        return result;
    }
//seguimos con el DELETE
public boolean eliminarPaciente(Long id) {
    Optional<PacienteEntity> optionalPaciente = pacientesRepository.findById(Math.toIntExact(id));

    if (optionalPaciente.isPresent()) {
        pacientesRepository.deleteById(Math.toIntExact(id));
        System.out.println("Paciente con id " + id + " eliminado");
        return true;
    } else {
        System.out.println("Paciente con id " + id + " no encontrado");
        return false;
    }
}



}
