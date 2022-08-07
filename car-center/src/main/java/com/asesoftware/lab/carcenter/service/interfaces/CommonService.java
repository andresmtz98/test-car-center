package com.asesoftware.lab.carcenter.service.interfaces;

import java.io.Serializable;
import java.util.Optional;

public interface CommonService<E, T extends Serializable> {

    Iterable<E> findAll();

    Optional<E> findById(T id);

    E save(E entity);

    void deleteById(T id);

    Iterable<E> save(Iterable<E> entities);
}
