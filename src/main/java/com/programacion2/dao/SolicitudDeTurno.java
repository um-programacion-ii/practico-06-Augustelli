package com.programacion2.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudDeTurno {

        private Paciente paciente;
        private String nombreMedico;
        private String apellidoMedico;
        private boolean particular;
        private Especialidad especialidad;


        public SolicitudDeTurno(
                Paciente paciente,
                String nombreMedico,
                String apellidoMedico,
                boolean particular
        ){
                this.paciente = paciente;
                this.nombreMedico =nombreMedico;
                this.apellidoMedico = apellidoMedico;
                this. particular = particular;
        }


        public SolicitudDeTurno(
                Paciente paciente,
                Especialidad especialidad,
                boolean particular
        ){
                this.paciente = paciente;
                this.especialidad = especialidad;
                this. particular = particular;
        }

}
