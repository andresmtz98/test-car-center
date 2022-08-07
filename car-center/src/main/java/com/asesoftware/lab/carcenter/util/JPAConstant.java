package com.asesoftware.lab.carcenter.util;

public class JPAConstant {

    public static final String QUERY_OBTENER_MECANICOS_DISPONIBLES = """
        select *
        from (SELECT documento, concat(primer_nombre, concat(' ', primer_apellido)) nombre, celular, 0 totalHoras
              FROM mecanicos m
              WHERE NOT EXISTS (SELECT 1
                                 FROM mantenimientos mto
                                 WHERE mto.mec_documento = m.documento
                                 AND mto.mec_tipo_documento = m.tipo_documento
                                 AND (mto.estado = 0 or mto.fecha >= now() - interval '30 days'))
              AND estado = 'A'
              UNION
              SELECT m.documento, concat(m.primer_nombre, concat(' ', m.primer_apellido)) nombre, m.celular,
               sum(coalesce(rxm.tiempo_estimado, 0) + coalesce(sxm.tiempo_estimado, 0)) totalHoras
              FROM mecanicos m
              JOIN mantenimientos mto on  mto.mec_documento = m.documento AND mec_tipo_documento = m.tipo_documento\040
              LEFT JOIN repuestos_x_mantenimientos rxm on rxm.cod_mantenimiento  = mto.codigo
              LEFT JOIN servicios_x_mantenimientos sxm on sxm.cod_mantenimiento = mto.codigo
              WHERE mto.fecha >= now() - interval '30 days'
              AND m.estado = 'A'
              AND NOT EXISTS (SELECT 1
                                 FROM mantenimientos mto
                                 WHERE mto.mec_documento = m.documento
                                 AND mto.mec_tipo_documento = m.tipo_documento
                                 AND mto.estado = 0)\040
              GROUP BY m.documento, concat(m.primer_nombre, concat(' ', m.primer_apellido)), m.celular) listado
        order by totalHoras
    """;

    private JPAConstant() {
    }
}
