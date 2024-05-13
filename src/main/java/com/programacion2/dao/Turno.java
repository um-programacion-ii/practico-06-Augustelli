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



    public Turno(Medico medico, Paciente paciente, EstadoTurno estadoTurno, ObraSocial obraSocial) {
        this.medico = medico;
        this.paciente = paciente;
        this.estadoTurno = estadoTurno;
        this.obraSocial = obraSocial;
    }


}
