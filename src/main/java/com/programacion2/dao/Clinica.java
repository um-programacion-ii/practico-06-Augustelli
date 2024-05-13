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


    public List<Medico> listarMedicosPorEspecialidad(Especialidad especialidad) {
        return getMedicos().stream()
                .filter(medico -> medico.getEspecialidad().equals(especialidad))
                .collect(Collectors.toList());
    }

    public List<Medico> listarMedicosQueAtiendenParticular()
    {
        return getMedicos().stream()
                .filter(Medico::isAtiendeParticular)
                .collect(Collectors.toList());
    }

    public void iniciarTurno(Paciente paciente, Turno turno) throws Exception {
        if (turno.getMedico().isAtendiendoPaciente()){
            throw new Exception("El médico no puede atender al paciente porque esta atendiendo a otro");

        }
    }



}


