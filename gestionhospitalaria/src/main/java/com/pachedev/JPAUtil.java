package com.academia.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Clase de utilidad para la gestión del ciclo de vida de JPA.
 * Proporciona un punto de acceso centralizado para obtener instancias de
 * EntityManager y gestionar el EntityManagerFactory.
 * Implementa el patrón Singleton para la factoría, asegurando que los recursos
 * de la base de datos se gestionen de manera eficiente.
 * 
 * @author Daniel Pacheco
 * @version 1.0
 */
public class JPAUtil {

    private static final String PERSISTENCE_UTIL_NAME = "techacademyPU";
    private static EntityManagerFactory emf;

    // inicialización estática
    static {
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UTIL_NAME);
        } catch (Throwable e) {
            System.err.println("Error al crear EntityManagerFactory: " + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * Obtiene una nueva instancia de EntityManager
     * 
     * @return EntityManager
     */
    public static EntityManager getEntityManager() {
        if (emf == null || !emf.isOpen()) {
            throw new IllegalStateException("EntityManagerFactory no está disponible.");
        }
        return emf.createEntityManager();
    }

    /**
     * Cierra el EntityManagerFactory
     * Llamar al finalizar la aplicación
     */
    public static void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }

    /**
     * Verifica si el EntityManagerFactory está abierto
     * 
     * @return true si está abierto
     */
    public static boolean isOpen() {
        return emf != null && emf.isOpen();
    }

}