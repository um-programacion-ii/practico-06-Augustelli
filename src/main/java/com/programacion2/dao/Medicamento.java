package com.programacion2.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Medicamento {

    private String nombre;
    private Presentacion presentacion;
    private int cantidad;
    private Float precio;



}
