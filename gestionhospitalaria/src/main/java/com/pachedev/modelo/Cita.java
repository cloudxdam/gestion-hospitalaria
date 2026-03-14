package com.pachedev.modelo;

import java.time.LocalDateTime;

import com.pachedev.enums.EstadoCita;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "citas")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Future(message = "La fecha y hora de la cita deben ser posteriores a la actual.")
    @NotNull(message = "La fecha y hora de la cita son obligatorias.")
    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    @NotNull(message = "El motivo de la cita es obligatorio.")
    @Size(max = 500, message = "El motivo no puede exceder los 500 caracteres.")
    @Column(name = "motivo", length = 500, nullable = false)
    private String motivo;

    @NotNull(message = "El estado de la cita es obligatorio.")
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoCita estado;

    @Size(max = 1000, message = "Las observaciones no pueden exceder los 1000 caracteres.")
    @Column(name = "observaciones", length = 1000)
    private String observaciones;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull(message = "Indicar el paciente es obligatorio.")
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull(message = "Indicar el médico es obligatorio.")
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;

}
