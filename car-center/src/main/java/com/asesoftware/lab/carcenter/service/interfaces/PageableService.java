package com.asesoftware.lab.carcenter.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Contiene los métodos comunes para paginación de entidades
 *
 * @param <E> Tipo de la entidad
 */
public interface PageableService<E> {

    /**
     * Consulta todas las entidades y aplica la paginación
     *
     * @param pageable paginación
     * @return {@link Page} de {@link E}
     */
    Page<E> findAll(Pageable pageable);
}
