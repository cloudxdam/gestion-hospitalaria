package com.pachedev.modelo;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class TratamientoMedicamentoId implements Serializable {

    @Column(name = "tratamiento_id")
    private Long tratamientoId;

    @Column(name = "medicamento_id")
    private Long medicamentoId;

    public TratamientoMedicamentoId() {
    }

    public Long getTratamientoId() {
        return tratamientoId;
    }

    public void setTratamientoId(Long tratamientoId) {
        this.tratamientoId = tratamientoId;
    }

    public Long getMedicamentoId() {
        return medicamentoId;
    }

    public void setMedicamentoId(Long medicamentoId) {
        this.medicamentoId = medicamentoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof TratamientoMedicamentoId))
            return false;
        TratamientoMedicamentoId that = (TratamientoMedicamentoId) o;
        return Objects.equals(tratamientoId, that.tratamientoId) && Objects.equals(medicamentoId, that.medicamentoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tratamientoId, medicamentoId);
    }

}
