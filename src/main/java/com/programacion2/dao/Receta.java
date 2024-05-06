package com.programacion2.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Receta {

    private Medico presriptor;
    private Paciente paciente;
    private ObraSocial obraSocial;
    private List<Medicamento> medicamentosRecetados;


}
