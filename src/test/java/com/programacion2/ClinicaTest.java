package com.programacion2;

import com.programacion2.dao.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClinicaTest {

    private Clinica clinica;
    private Medico medico;
    private Paciente paciente;
    private Turno turno;

    @BeforeEach
    public void setUp() {
        clinica = new Clinica();
        medico = mock(Medico.class);
        paciente = mock(Paciente.class);
        turno = mock(Turno.class);
    }

    @Test
    void testListarMedicosPorEspecialidad() {
        when(medico.getEspecialidad()).thenReturn(Especialidad.CARDIOLOGO);
        clinica.setMedicos(Collections.singletonList(medico));

        assertEquals(Collections.singletonList(medico), clinica.listarMedicosPorEspecialidad(Especialidad.CARDIOLOGO));
    }

    @Test
    void testListarMedicosQueAtiendenParticular() {
        when(medico.isAtiendeParticular()).thenReturn(true);
        clinica.setMedicos(Collections.singletonList(medico));

        assertEquals(Collections.singletonList(medico), clinica.listarMedicosQueAtiendenParticular());
    }

    @Test
    void testIniciarTurno() throws Exception {
        when(turno.getMedico()).thenReturn(medico);
        when(medico.isAtendiendoPaciente()).thenReturn(false);

        clinica.iniciarTurno(paciente, turno);
        verify(medico, times(1)).isAtendiendoPaciente();
    }
}