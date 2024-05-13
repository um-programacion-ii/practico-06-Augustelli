package com.programacion2;

import com.programacion2.dao.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MedicoTest {

    private Medico medico;
    private Paciente paciente;
    private Turno turno;

    @BeforeEach
    public void setUp() {
        medico = new Medico();
        paciente = mock(Paciente.class);
        turno = mock(Turno.class);
    }

    @Test
     void testRecetarPaciente() {
        Receta receta = medico.recetarPaciente();
        assertNotNull(receta);
    }

    @Test
     void testAtenderPaciente() {
        when(paciente.getRecetas()).thenReturn(new ArrayList<>());
        when(turno.getEstadoTurno()).thenReturn(EstadoTurno.TERMINADO);

        medico.atenderPaciente(paciente, turno);
        verify(paciente, times(1)).getRecetas();
        assertEquals(EstadoTurno.TERMINADO, turno.getEstadoTurno());
        assertFalse(medico.isAtendiendoPaciente());
    }
}