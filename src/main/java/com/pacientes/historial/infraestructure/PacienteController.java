package com.pacientes.historial.infraestructure;

import com.pacientes.historial.domain.model.entity.DTO.PacienteDTO;
import com.pacientes.historial.domain.model.entity.PacienteEntity;
import com.pacientes.historial.domain.service.PacienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/historial")


public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/listarPaciente")

    public List<PacienteEntity> listarPacientes(){
        return pacienteService.listarPacientes();

    }

    @PostMapping("/crearPaciente")
    public PacienteDTO crearPaciente(@RequestBody PacienteDTO pacienteDTO) {
        return pacienteService.crearPaciente(pacienteDTO);
    }
//De aqui para abajo es algo extra que le quise añadir para completar el CRUD
    //en el enlace debes poner http://localhost:8080/historial/actualizarPaciente/(id del paciente que desea cambiar)
    @PutMapping("/actualizarPaciente/{id}")
    public PacienteDTO actualizarPaciente(@PathVariable Long id, @RequestBody PacienteDTO pacienteDTO) {
        return pacienteService.actualizarPaciente(id, pacienteDTO);
    }

//Aqui seguimos con el DELETE para realizarlo es con el siguiente enlace http://localhost:8080/historial/eliminarPaciente/(id del paciente que desea eliminae)
    @DeleteMapping("/eliminarPaciente/{id}")
    public String eliminarPaciente(@PathVariable Long id) {
        boolean eliminado = pacienteService.eliminarPaciente(id);
        if (eliminado) {
            return "Paciente con id " + id + " eliminado correctamente";
        } else {
            return "Paciente con id " + id + " no encontrado";
        }
    }



}





