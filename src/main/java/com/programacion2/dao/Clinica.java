package com.programacion2.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Clinica {

    private List<Medico> medicos;
    private List<Paciente> pacietes;
    private Farmacia farmacia;
    private Map<Paciente, List<Turno>> turnosPacientes;
    public void init() {
    }

    public List<Medico> listarMedicosPorEspecialidadYObraSocial(String nombreObraSocial, String nombreEspecialidad) {
        return medicos.stream()
                .filter(medico -> medico.getObrasSocialesAceptadas().contains(ObraSocial.valueOf(nombreObraSocial))
                        && medico.getEspecialidad().equals(Especialidad.valueOf(nombreEspecialidad)))
                .collect(Collectors.toList());
    }

    public List<Medico> listarMedicos(){
        return medicos;
    }

}


