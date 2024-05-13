package com.programacion2.dao;

import lombok.Data;




@Data
public class Drogueria {

    public static Medicamento solicitarMedicamento(Medicamento medicamento){
        return new Medicamento(medicamento.getNombre(),1000, medicamento.getPrecio());
    }
}
