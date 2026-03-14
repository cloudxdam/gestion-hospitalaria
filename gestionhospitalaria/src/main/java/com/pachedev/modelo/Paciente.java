package com.pachedev.modelo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El nombre del paciente es obligatorio.")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @NotNull(message = "el DNI del paciente es obligatorio")
    @Pattern(regexp = "^([0-9]{8}|[XYZ][0-9]{7})[TRWAGMYFPDXBNJZSQVHLCKE]$", message = "Debe ser un DNI o NIE válido.")
    @Column(name = "dni", nullable = false, unique = true)
    private String dni;

    @Email(message = "Debe introducir un email válido.")
    @Column(name = "email", unique = true)
    private String email;

    @Size(max = 20, message = "El número de teléfono no puede exceder los 20 caracteres.")
    @Column(name = "telefono", length = 20)
    private String telefono;

    @Past(message = "La fecha de nacimiento no puede ser posterior a la actual.")
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Size(max = 5, message = "El grupo sanguíneo no puede exceder los 5 caracteres")
    @Column(name = "grupo_sanguineo", length = 5)
    private String grupoSanguineo;

    @Size(max = 200, message = "la dirección no puede exceder los 200 caracteres.")
    @Column(name = "direccion", length = 200)
    private String direccion;

    @Column(name = "activo")
    private Boolean activo = true;

    @OneToMany(mappedBy = "paciente")
    private List<Cita> citas;

    @OneToMany(mappedBy = "paciente")
    private List<Historial> historiales;

    @OneToMany(mappedBy = "paciente")
    private List<Ingreso> ingresos;

}
