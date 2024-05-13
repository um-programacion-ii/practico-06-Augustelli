package com.programacion2;

import com.programacion2.dao.*;
import com.programacion2.service.GestionFarmaciaService;
import com.programacion2.service.GestionTurnoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PacienteTest {

    private Paciente paciente;
    private GestionTurnoService gestionTurnoService;
    private GestionFarmaciaService gestionFarmaciaService;
    private Receta receta;
    private Farmacia farmacia;

    @BeforeEach
    public void setUp() {
        gestionTurnoService = mock(GestionTurnoService.class);
        gestionFarmaciaService = mock(GestionFarmaciaService.class);
        paciente = new Paciente(gestionTurnoService, gestionFarmaciaService);
        paciente.setTurnos(new ArrayList<>()); // Initialize the turnos list
        receta = mock(Receta.class);
        farmacia = mock(Farmacia.class);
    }

    @Test
    public void testSolicitarTurno() throws Exception {
        SolicitudDeTurno solicitudDeTurno = new SolicitudDeTurno(paciente, "John", "Doe", true);
        Turno turno = new Turno();
        when(gestionTurnoService.crearTurno(solicitudDeTurno)).thenReturn(turno);

        paciente.solicitarTurno("John", "Doe", true);

        verify(gestionTurnoService, times(1)).crearTurno(solicitudDeTurno);
        assertTrue(paciente.getTurnos().contains(turno));
    }

    @Test
    public void testComprarMedicamentos() {
        paciente.setRecetas(new ArrayList<>());
        paciente.comprarMedicamentos(receta, farmacia);

        verify(gestionFarmaciaService, times(1)).comprarMedicamentosDeReceta(receta, farmacia);
    }
}