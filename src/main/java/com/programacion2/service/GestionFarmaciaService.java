package com.programacion2.service;

import com.programacion2.dao.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;


public class GestionFarmaciaService {

    private static final Logger logger = LoggerFactory.getLogger(GestionFarmaciaService.class);
    public void comprarMedicamentosDeReceta(Receta receta, Farmacia farmacia) {
        logger.info(receta.getPaciente() + " comprando medicamentos");
        Iterator<Medicamento> iterator = receta.getMedicamentosRecetados().iterator();
        while (iterator.hasNext()) {
            Medicamento medicamento = iterator.next();
            Medicamento medicamentoInFarmacia = farmacia.getMedicamentos().get(medicamento.getNombre());
            if (medicamentoInFarmacia != null && medicamentoInFarmacia.getCantidad() >= medicamento.getCantidad()) {
                medicamentoInFarmacia.setCantidad(medicamentoInFarmacia.getCantidad() - medicamento.getCantidad());
                logger.info(medicamento.getNombre() + " vendido.");
                iterator.remove();
            } else {
                logger.info(medicamento.getNombre() + " no esta en farmacia, se va a solicitar.");
                solicitarMedicamentoADrogeria(medicamento, farmacia);
            }
        }
    }

    private void solicitarMedicamentoADrogeria(Medicamento medicamentoASolicitar, Farmacia farmacia){
        logger.info(" Solicitando " + medicamentoASolicitar.getNombre());
        Medicamento medicamentoSolicitado = Drogueria.solicitarMedicamento(medicamentoASolicitar);
        farmacia.getMedicamentos().put(medicamentoSolicitado.getNombre(), medicamentoSolicitado);
    }
}
