package com.pacientes.historial.domain.model.entity.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class PacienteDTO {
    private Long id;
    private String nombre;
    private Integer edad;
    private String historial;
    private String tratamiento;
    private Date fechaRegistro;


    public void setId(Long id) { this.id = id; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public void setEdad(Integer edad) { this.edad = edad; }

    public void setHistorial(String historial) { this.historial = historial; }

    public void setTratamiento(String tratamiento) { this.tratamiento = tratamiento; }

    public Date getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(Date fechaRegistro) { this.fechaRegistro = fechaRegistro; }
}


