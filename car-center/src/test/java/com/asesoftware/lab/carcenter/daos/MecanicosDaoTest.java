package com.asesoftware.lab.carcenter.daos;

import com.asesoftware.lab.carcenter.model.daos.MecanicosDao;
import com.asesoftware.lab.carcenter.model.dtos.MecanicoDisponible;
import com.asesoftware.lab.carcenter.model.entities.Mecanicos;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class MecanicosDaoTest {

    private static List<Mecanicos> mecanicos;
    @MockBean private MecanicosDao mecanicosDao;

    @BeforeAll static void beforeall() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Mecanicos>> type = new TypeReference<>() {
        };
        mecanicos = mapper.createParser(
                new ClassPathResource("mecanicos.json").getInputStream())
            .readValueAs(type);
    }

    @BeforeEach
    void beforeEach() {
        when(mecanicosDao.findAll()).thenReturn(mecanicos);
    }

    @Test void testFindAll() {
        List<Mecanicos> mecanicos = (List<Mecanicos>) mecanicosDao.findAll();
        assertTrue(mecanicos.size() > 0);
    }

    @Test void testMecanicosDisponibles() {
        when(mecanicosDao.consultarMecanicosDisponibles(any())).thenReturn(
            new PageImpl<>(
                mecanicos.stream().map(m -> new MecanicoDisponible() {
                    @Override public Integer getDocumento() {
                        return m.getDocumento();
                    }

                    @Override public String getNombre() {
                        return String.format("%S %S", m.getPrimerNombre(),
                            m.getPrimerApellido());
                    }

                    @Override public String getCelular() {
                        return m.getCelular();
                    }

                    @Override public Integer getTotalHoras() {
                        return 0;
                    }
                }).collect(Collectors.toList())));

        Page<MecanicoDisponible> mecanicosDisponibles = mecanicosDao.consultarMecanicosDisponibles(
            Pageable.ofSize(10));
        assertTrue(mecanicosDisponibles.getTotalElements() > 0);
    }
}
