package com.asesoftware.lab.carcenter.service.impl;

import com.asesoftware.lab.carcenter.model.daos.MecanicosDao;
import com.asesoftware.lab.carcenter.model.dtos.MecanicoDisponible;
import com.asesoftware.lab.carcenter.model.entities.Mecanicos;
import com.asesoftware.lab.carcenter.model.entities.MecanicosPK;
import com.asesoftware.lab.carcenter.service.interfaces.MecanicosService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MecanicosServiceImpl extends CommonServiceImpl<Mecanicos, MecanicosPK> implements
    MecanicosService {

    public MecanicosServiceImpl(MecanicosDao repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Mecanicos> findAll(Pageable pageable) {
        return ((MecanicosDao) repository).findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<MecanicoDisponible> consultarMecanicosDisponibles(
        Pageable page) {
        return ((MecanicosDao) repository).consultarMecanicosDisponibles(page);
    }
}
