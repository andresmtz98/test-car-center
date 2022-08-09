package com.asesoftware.lab.carcenter.service.interfaces;

import com.asesoftware.lab.carcenter.model.dtos.MecanicoDisponible;
import com.asesoftware.lab.carcenter.model.entities.Mecanicos;
import com.asesoftware.lab.carcenter.model.entities.MecanicosPK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MecanicosService
    extends CommonService<Mecanicos, MecanicosPK>, PageableService<Mecanicos> {

    /**
     * Obtiene el listado de mecánicos disponibles en el momento, ordenado por el número de
     * horas asignadas durantes los últimos 30 días
     *
     * @param page paginación
     * @return {@link Page} de {@link MecanicoDisponible}
     */
    Page<MecanicoDisponible> consultarMecanicosDisponibles(Pageable page);
}
