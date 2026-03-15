package com.pachedev;

import java.time.LocalDateTime;

import com.pachedev.enums.EstadoCita;
import com.pachedev.modelo.Cita;
import com.pachedev.modelo.Departamento;
import com.pachedev.modelo.Medico;
import com.pachedev.modelo.Paciente;
import com.pachedev.util.JPAUtil;

import jakarta.persistence.EntityManager;

// Clase main de prueba para probar persitencia antes de seguir
public class MainTest {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();

        try {

            em.getTransaction().begin();

            // 1️⃣ Crear departamento
            Departamento departamento = new Departamento();
            departamento.setNombre("Cardiología");
            departamento.setEspecialidad("Cardiología");
            departamento.setNumeroPlanta(2);

            em.persist(departamento);

            // 2️⃣ Crear médico
            Medico medico = new Medico();
            medico.setNombre("Dr. García");
            medico.setEmail("garcia@hospital.com");
            medico.setEspecialidad("Cardiología");
            medico.setFechaContratacion(java.time.LocalDate.now());
            medico.setNumeroColegiado("COL12345");
            medico.setDepartamento(departamento);

            em.persist(medico);

            // 3️⃣ Crear paciente
            Paciente paciente = new Paciente();
            paciente.setNombre("Juan Pérez");
            paciente.setDni("12345678Z");
            paciente.setEmail("juan@email.com");

            em.persist(paciente);

            // 4️⃣ Crear cita
            Cita cita = new Cita();
            cita.setFechaHora(LocalDateTime.now().plusDays(1));
            cita.setMotivo("Revisión cardíaca");
            cita.setEstado(EstadoCita.PENDIENTE);
            cita.setPaciente(paciente);
            cita.setMedico(medico);

            em.persist(cita);

            em.getTransaction().commit();

            System.out.println("Test básico de persistencia realizado.");

        } catch (Exception e) {

        } finally {
            em.close();
            JPAUtil.close();
        }

    }

}
