package com.pachedev.dao;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public abstract class GenericDAO<T, ID> {

    protected final EntityManager em;
    private final Class<T> entityClass;

    public GenericDAO(EntityManager em, Class<T> entityClass) {
        this.em = em;
        this.entityClass = entityClass;
    }

    public void guardar(T entity) {
        em.persist(entity);
    }

    public T actualizar(T entity) {
        return em.merge(entity);
    }

    public void eliminar(T entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    public Optional<T> buscarPorId(ID id) {
        return Optional.ofNullable(em.find(entityClass, id));
    }

    public List<T> buscarTodos() {
        String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e";
        return em.createQuery(jpql, entityClass).getResultList();
    }

    public long contar() {
        String jpql = "SELECT COUNT(e) FROM " + entityClass.getSimpleName() + " e";
        return em.createQuery(jpql, long.class).getSingleResult();
    }

    protected TypedQuery<T> createQuery(String jpql) {
        return em.createQuery(jpql, entityClass);
    }

}
