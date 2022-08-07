package com.asesoftware.lab.carcenter.service.impl;

import com.asesoftware.lab.carcenter.service.interfaces.CommonService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Optional;

@Transactional
public class CommonServiceImpl<E, T extends Serializable>
    implements CommonService<E, T> {

    protected CrudRepository repository;

    public CommonServiceImpl(CrudRepository repository) {
        this.repository = repository;
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    public Iterable<E> findAll() {
        return repository.findAll();
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    public Optional<E> findById(T id) {
        return repository.findById(id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public E save(E entity) {
        return (E) repository.save(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void deleteById(T id) {
        repository.deleteById(id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterable<E> save(Iterable<E> entities) {
        return repository.saveAll(entities);
    }

}

