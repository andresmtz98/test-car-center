package com.asesoftware.lab.carcenter.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PageableService<E> {
    Page<E> findAll(Pageable pageable);
}
