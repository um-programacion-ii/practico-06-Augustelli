package com.programacion2.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Turno {

    private Medico medico;
    private Paciente paciente;
    private EstadoTurno estadoTurno;
    private Receta receta;
    private ObraSocial obraSocial;

    // Crear servicio de clinica que me de médico dado su nombre o  el objeto de médico
    public  Turno crearTurnoParticular(Paciente paciente, String nombreMedico){
        return new Turno(nombreMedico, paciente, EstadoTurno.TOMADO, null, ObraSocial.NO_OBRA_SOCIAL );
    }

    public Turno crearTurnoPorObraSocial(Paciente paciente, String nombreMedico){
        return new Turno(nombreMedico, paciente, EstadoTurno.TOMADO, null, paciente.getObraSocial() );

    }

}
