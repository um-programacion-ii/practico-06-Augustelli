package com.programacion2.service;

import com.programacion2.dao.*;

import java.util.Map;

public class ClinicaService {


    public static Map<Integer, Medico> medicoMap;

    public void aniadirMedico(Medico medico){
        medicoMap.put(medicoMap.size()+1 , medico);
    }

    public void eliminarMedico(Integer id){
        medicoMap.remove(id);
    }
    private GestionFarmaciaService gestionFarmaciaService;

    public ClinicaService(GestionFarmaciaService gestionFarmaciaService) {
        this.gestionFarmaciaService = gestionFarmaciaService;
    }

    public Medico rescatarMedico(String nombre, String apellido){
        for (Medico medico : medicoMap.values()) {
            if (medico.getNombre().equals(nombre) && medico.getApellido().equals(apellido)) {
                return medico;
            }
        }
        return null;
    }

    public void iniciarTurno(Paciente paciente, Turno turno) throws Exception {
        if (turno.getMedico().isAtendiendoPaciente()){
            throw  new Exception("El medico " + turno.getMedico() + " está atendiendo un paciente.");
        }
        turno.setEstadoTurno(EstadoTurno.PROCESO);
    }

    public Medico rescatarMedicoPorEspecialidad(Especialidad especialidad) {
        Medico medicoDevolver = null;
        for (Medico medico : medicoMap.values()){
            if (medico.getEspecialidad().equals(especialidad)){
                medicoDevolver = medico;
            }
        }
        return medicoDevolver;
    }

    public void venderMedicamento(Receta receta, Farmacia farmacia){
        this.gestionFarmaciaService.comprarMedicamentosDeReceta(receta, farmacia);
    }
}
