package com.programacion2.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medico {

    private String nombre;
    private String apellido;
    private Especialidad especialidad;
    private boolean atiendeParticular;
    private boolean atendiendoPaciente;
    private List<ObraSocial> obrasSocialesAceptadas;
    private static final Random random = new Random();

    public Receta recetarPaciente(){

        if (random.nextBoolean()) {
            Receta receta = new Receta();
            List<Medicamento> medicamentos = new ArrayList<>();
            int numMedicamentos = random.nextInt(3);
            for (int i = 0; i < numMedicamentos; i++) {
                Medicamento medicamento = new Medicamento();
                medicamento.setNombre("Medicamento " + (i + 1));
                medicamento.setCantidad(random.nextInt(100));
                medicamento.setPrecio(random.nextFloat() * 10000.0f);
                medicamentos.add(medicamento);
            }
            receta.setMedicamentosRecetados(medicamentos);
            return receta;
        } else {
            return null;
        }
    }

    public void atenderPaciente(Paciente paciente, Turno turnoPaciente){
        setAtendiendoPaciente(true);
        Receta receta = recetarPaciente();
        paciente.getRecetas().add(receta);
        turnoPaciente.setEstadoTurno(EstadoTurno.TERMINADO);
        setAtendiendoPaciente(false);
    }

}
