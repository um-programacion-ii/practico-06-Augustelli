package com.programacion2;



import com.programacion2.dao.*;
import com.programacion2.service.ClinicaService;
import com.programacion2.service.GestionFarmaciaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClinicaServiceTest {

    private ClinicaService clinicaService;
    private GestionFarmaciaService gestionFarmaciaService;
    private Medico medico;
    private Paciente paciente;
    private Turno turno;
    private Receta receta;
    private Farmacia farmacia;

    @BeforeEach
    public void setUp() {
        gestionFarmaciaService = mock(GestionFarmaciaService.class);
        clinicaService = new ClinicaService(gestionFarmaciaService);
        medico = mock(Medico.class);
        paciente = mock(Paciente.class);
        turno = mock(Turno.class);
        receta = mock(Receta.class);
        farmacia = mock(Farmacia.class);
        ClinicaService.medicoMap = new HashMap<>();
    }

    @Test
    void testAniadirMedico() {
        clinicaService.aniadirMedico(medico);
        assertEquals(1, ClinicaService.medicoMap.size());
    }

    @Test
    void testEliminarMedico() {
        clinicaService.aniadirMedico(medico);
        clinicaService.eliminarMedico(1);
        assertEquals(0, ClinicaService.medicoMap.size());
    }

    @Test
    void testRescatarMedico() {
        when(medico.getNombre()).thenReturn("John");
        when(medico.getApellido()).thenReturn("Doe");
        clinicaService.aniadirMedico(medico);
        Medico rescatado = clinicaService.rescatarMedico("John", "Doe");
        assertEquals(medico, rescatado);
    }

    @Test
    void testRescatarMedicoPorEspecialidad() {
        when(medico.getEspecialidad()).thenReturn(Especialidad.TRAUMATOLOGO);
        clinicaService.aniadirMedico(medico);
        Medico rescatado = clinicaService.rescatarMedicoPorEspecialidad(Especialidad.TRAUMATOLOGO);
        assertEquals(medico, rescatado);
    }

    @Test
    void testVenderMedicamento() {
        clinicaService.venderMedicamento(receta, farmacia);
        verify(gestionFarmaciaService, times(1)).comprarMedicamentosDeReceta(receta, farmacia);
    }
}