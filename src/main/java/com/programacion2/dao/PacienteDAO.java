package com.programacion2.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDAO {

    private String nombre;
    private String apellido;
    private ObraSocialDAO obraSocial;
    private List<Turno> turnos;
    private List<Receta> recetas;

}
