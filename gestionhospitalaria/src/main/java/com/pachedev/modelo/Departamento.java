package com.pachedev.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "departamentos")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El nombre del departamento no puede ser nulo.")
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Size(max = 100, message = "La especialidad no puede exceder los 100 caracteres.")
    @Column(name = "especialidad", length = 100)
    private String especialidad;

    @Min(value = 0, message = "El número de planta debe ser un valor positivo o cero.")
    @Column(name = "numero_planta")
    private Integer numeroPlanta;

    @OneToMany(mappedBy = "departamento")
    private List<PersonalMedico> personalMedico = new ArrayList<>();

    @OneToMany(mappedBy = "departamento")
    private List<Habitacion> habitaciones = new ArrayList<>();

    public Departamento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Integer getNumeroPlanta() {
        return numeroPlanta;
    }

    public void setNumeroPlanta(Integer numeroPlanta) {
        this.numeroPlanta = numeroPlanta;
    }

    public List<PersonalMedico> getPersonalMedico() {
        return personalMedico;
    }

    public void setPersonalMedico(List<PersonalMedico> personalMedico) {
        this.personalMedico = personalMedico;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    @Override
    public String toString() {
        return "Departamento [id=" + id + ", nombre=" + nombre + ", especialidad=" + especialidad + ", numeroPlanta="
                + numeroPlanta + "]";
    }

}
