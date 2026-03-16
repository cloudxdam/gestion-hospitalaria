package com.pachedev.modelo;

import com.pachedev.enums.Turno;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@DiscriminatorValue("ENFERMERO")
@Table(name = "enfermeros")
public class Enfermero extends PersonalMedico {

    @Enumerated(EnumType.STRING)
    @Column(name = "turno")
    private Turno turno;

    @Size(max = 100, message = "El área no puede exceder los 100 caracteres.")
    @Column(name = "area", length = 100)
    private String area;

    public Enfermero() {
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Enfermero [turno=" + turno + ", area=" + area + "]";
    }

}
