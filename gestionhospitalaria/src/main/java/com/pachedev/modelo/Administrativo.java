package com.pachedev.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "administrativos")
public class Administrativo extends PersonalMedico {

    @NotNull(message = "El cargo es obligatorio.")
    @Size(max = 100, message = "El cargo no puede exceder los 100 caracteres.")
    @Column(name = "cargo", nullable = false, length = 100)
    private String cargo;

    public Administrativo() {
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Administrativo [cargo=" + cargo + "]";
    }

}
