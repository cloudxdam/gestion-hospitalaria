package com.pachedev.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tratamiento_medicamento")
public class TratamientoMedicamento {

    @EmbeddedId
    private TratamientoMedicamentoId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("tratamientoId")
    @JoinColumn(name = "tratamiento_id")
    private Tratamiento tratamiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("medicamentoId")
    @JoinColumn(name = "medicamento_id")
    private Medicamento medicamento;

    @NotNull(message = "La dosis es obligatoria.")
    @Size(max = 100)
    @Column(name = "dosis", nullable = false, length = 100)
    private String dosis;

    @NotNull(message = "La frecuencia es obligatoria (Ej: cada 8 horas).")
    @Column(name = "frecuencia", nullable = false)
    private String frecuencia;

    @Min(1)
    @Column(name = "duracion_dias")
    private Integer duracionDias;

    public TratamientoMedicamento() {
    }

    public TratamientoMedicamentoId getId() {
        return id;
    }

    public void setId(TratamientoMedicamentoId id) {
        this.id = id;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public Integer getDuracionDias() {
        return duracionDias;
    }

    public void setDuracionDias(Integer duracionDias) {
        this.duracionDias = duracionDias;
    }

    @Override
    public String toString() {
        return "TratamientoMedicamento [id=" + id + ", tratamiento=" + tratamiento + ", medicamento=" + medicamento
                + ", dosis=" + dosis + ", frecuencia=" + frecuencia + ", duracionDias=" + duracionDias + "]";
    }

}
