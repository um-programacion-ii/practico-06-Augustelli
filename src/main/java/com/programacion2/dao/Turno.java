package com.programacion2.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Turno {

    private Medico medico;
    private PacienteDAO pacienteDAO;
    private EstadoTurno estadoTurno;
    private Receta receta;
    private boolean particular;


}
