package com.programacion2.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

    private String nombre;
    private String apellido;
    private ObraSocial obraSocial;
    private List<Turno> turnos;
    private List<Receta> recetas;


    public void solicitarTurno(String nombreMedico, boolean particular){

    }

    public void iniciarTurno(Turno turno){

    }
    public void comprarMedicamentos(Receta receta){

    }
}
