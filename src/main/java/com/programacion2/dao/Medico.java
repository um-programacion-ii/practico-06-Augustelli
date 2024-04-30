package com.programacion2.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medico {

    private String nombre;
    private String apellido;
    private Especialidad especialidad;
    private boolean atiendeParticular;
    private List<ObraSocialDAO> obrasSocialesAceptadas;

}
