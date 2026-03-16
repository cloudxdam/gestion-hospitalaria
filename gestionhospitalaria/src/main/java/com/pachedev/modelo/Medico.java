package com.pachedev.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("MEDICO")
@Table(name = "medicos")
public class Medico extends PersonalMedico {

    @NotNull(message = "El número de colegiado es obligatorio.")
    @Column(name = "numero_colegiado", unique = true, nullable = false)
    private String numeroColegiado;

    @Column(name = "firma")
    private String firma;

    @OneToMany(mappedBy = "medico")
    private List<Cita> citas = new ArrayList<>();

    public Medico() {
    }

    public String getNumeroColegiado() {
        return numeroColegiado;
    }

    public void setNumeroColegiado(String numeroColegiado) {
        this.numeroColegiado = numeroColegiado;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    @Override
    public String toString() {
        return "Medico [numeroColegiado=" + numeroColegiado + ", firma=" + firma + "]";
    }

}
