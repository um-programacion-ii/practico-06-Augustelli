package com.programacion2.service;

import com.programacion2.dao.EstadoTurno;
import com.programacion2.dao.Paciente;
import com.programacion2.dao.Turno;

public class AtencionMedicoService {

    public void atenderPaciente(Paciente paciente, Turno turno){
        turno.setEstadoTurno(EstadoTurno.PROCESO);
        turno.getMedico().atenderPaciente(paciente, turno);
    }
}
