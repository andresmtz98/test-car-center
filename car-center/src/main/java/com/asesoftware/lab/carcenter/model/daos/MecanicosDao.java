package com.asesoftware.lab.carcenter.model.daos;

import com.asesoftware.lab.carcenter.model.dtos.MecanicoDisponible;
import com.asesoftware.lab.carcenter.model.entities.Mecanicos;
import com.asesoftware.lab.carcenter.model.entities.MecanicosPK;
import com.asesoftware.lab.carcenter.util.JPAConstant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MecanicosDao extends
    PagingAndSortingRepository<Mecanicos, MecanicosPK> {

    /**
     * Obtiene el listado de mecánicos disponibles en el momento, ordenado por el número de
     * horas asignadas durantes los últimos 30 días
     *
     * @param page paginación
     * @return {@link Page} de {@link MecanicoDisponible}
     */
    @Query(nativeQuery = true, value = JPAConstant.QUERY_OBTENER_MECANICOS_DISPONIBLES)
    Page<MecanicoDisponible> consultarMecanicosDisponibles(Pageable page);
}