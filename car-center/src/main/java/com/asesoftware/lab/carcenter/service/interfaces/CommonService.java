package com.asesoftware.lab.carcenter.service.interfaces;

import java.io.Serializable;
import java.util.Optional;

/**
 * Contiene los métodos <i>CRUD</i> comúnmente usados
 *
 * @param <E> Tipo de la entidad
 * @param <T> Tipo de la PK de la entidad
 */
public interface CommonService<E, T extends Serializable> {

    /**
     * Consulta todas las entidades
     *
     * @return {@link Iterable} de {@link E}
     */
    Iterable<E> findAll();

    /**
     * Busca una entidad por {@code id}
     *
     * @param id identificador de la entidad
     * @return {@link Optional} de @link E}
     */
    Optional<E> findById(T id);

    /**
     * Almacena una nueva entidad
     *
     * @param entity entidad a crear
     * @return entidad creada
     */
    E save(E entity);

    /**
     * Elimina la entidad por {@code id}
     *
     * @param id identificador de la entidad
     */
    void deleteById(T id);

    /**
     * Almacena todas las entidades de la lista
     *
     * @param entities listado de entidades a crear
     * @return listado de entidades creadas
     */
    Iterable<E> save(Iterable<E> entities);
}
