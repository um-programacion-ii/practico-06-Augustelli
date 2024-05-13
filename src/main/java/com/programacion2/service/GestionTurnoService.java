package com.programacion2.service;

import com.programacion2.dao.*;

public class GestionTurnoService {

    private final ClinicaService clinicaService;

    public GestionTurnoService(ClinicaService clinicaService) {
        this.clinicaService = clinicaService;
    }
    public Turno crearTurno(SolicitudDeTurno solicitudDeTurno) throws Exception {
        return solicitudDeTurno.isParticular() ?
                crearTurnoParticular(solicitudDeTurno):
                crearTurnoPorObraSocial(solicitudDeTurno);
    }
    private  Turno crearTurnoParticular(SolicitudDeTurno solicitudDeTurno) throws Exception {
        Medico medico = rescatarMedicoDadaSolicitudDeTurno(solicitudDeTurno);
        if (!medico.isAtiendeParticular()){
            throw new Exception("Medico " + solicitudDeTurno.getNombreMedico() + " " + solicitudDeTurno.getApellidoMedico() + " no atiende particular." );
        }
        return new Turno(
                medico,
                solicitudDeTurno.getPaciente(),
                EstadoTurno.TOMADO,
                ObraSocial.NO_OBRA_SOCIAL
        );
    }

    private Turno crearTurnoPorObraSocial(SolicitudDeTurno solicitudDeTurno) throws Exception {
        Medico medico = rescatarMedicoDadaSolicitudDeTurno(solicitudDeTurno);
        if (!medico.getObrasSocialesAceptadas().contains(solicitudDeTurno.getPaciente().getObraSocial())) {
            throw new Exception("La Obra Social del paciente no es aceptada por el médico.");
        }
        return new Turno(
                medico,
                solicitudDeTurno.getPaciente(),
                EstadoTurno.TOMADO,
                solicitudDeTurno.getPaciente().getObraSocial()
        );
    }

    private Medico rescatarMedicoDadaSolicitudDeTurno(SolicitudDeTurno solicitudDeTurno){
        Medico medico;
        if (solicitudDeTurno.getEspecialidad() == null){
            medico = this.clinicaService.rescatarMedico(solicitudDeTurno.getNombreMedico(), solicitudDeTurno.getApellidoMedico());
        } else {
            medico = this.clinicaService.rescatarMedicoPorEspecialidad(solicitudDeTurno.getEspecialidad());
        }

        return  medico;
    }

}
