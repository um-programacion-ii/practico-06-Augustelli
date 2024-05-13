package com.programacion2.dao;


import com.programacion2.service.GestionFarmaciaService;
import com.programacion2.service.GestionTurnoService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

    private static Logger logger = LoggerFactory.getLogger(Paciente.class);
    private String nombre;
    private String apellido;
    private ObraSocial obraSocial;
    private List<Turno> turnos;
    private List<Receta> recetas;


    private GestionTurnoService gestionTurnoService;
    private GestionFarmaciaService gestionFarmaciaService;


    public Paciente(
            GestionTurnoService gestionTurnoService,
            GestionFarmaciaService gestionFarmaciaService)
    {
        this.gestionTurnoService = gestionTurnoService;
        this.gestionFarmaciaService = gestionFarmaciaService;
    }

    public void solicitarTurno(String nombreMedico, String apellidoMedico, boolean particular) throws Exception {
        logger.debug(" --- Solicitando turno para " + nombreMedico + " " + apellidoMedico + " | Particular ? :" + particular );
        turnos.add(this.gestionTurnoService.
                crearTurno(
                    new SolicitudDeTurno(
                                this,
                                nombreMedico,
                                apellidoMedico,
                                particular
                    )
        ));
    }

    public void solicitarTurno(Especialidad especialidad, boolean particular) throws Exception {
        logger.debug(" --- Solicitando turno para la especialidad" + especialidad + " | Particular ? :" + particular );
        turnos.add(this.gestionTurnoService.
                crearTurno(
                        new SolicitudDeTurno(
                                this,
                                especialidad,
                                particular
                        )
                ));
    }

    public void comprarMedicamentos(Receta receta, Farmacia farmacia){
        logger.debug(" --- " + this.getNombre() + " " + this.getApellido() + " comprando medicamentos de " + receta);
        if (receta != null){
            this.gestionFarmaciaService.comprarMedicamentosDeReceta(receta, farmacia);
        }
    }

}
