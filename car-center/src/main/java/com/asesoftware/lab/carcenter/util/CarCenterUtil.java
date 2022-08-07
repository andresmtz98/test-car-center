package com.asesoftware.lab.carcenter.util;

import com.asesoftware.lab.carcenter.model.dtos.NuevoMecanico;
import com.asesoftware.lab.carcenter.model.entities.Mecanicos;

import java.util.Map;

public class CarCenterUtil {

    private CarCenterUtil() {
    }

    public static Mecanicos transformarMecanico(NuevoMecanico source) {
        return Mecanicos.builder().withPrimerNombre(source.getPrimerNombre())
            .withSegundoNombre(source.getSegundoNombre())
            .withPrimerApellido(source.getPrimerApellido())
            .withSegundoApellido(source.getSegundoApellido())
            .withTipoDocumento(source.getTipoDocumento())
            .withDocumento(source.getDocumento()).withEmail(source.getEmail())
            .withCelular(source.getCelular())
            .withDireccion(source.getDireccion()).build();
    }

    public static Map<String, String> generarTiposIdentificacion() {
        return Map.of(Constant.STRING_CC, Constant.STRING_CC_NAME,
            Constant.STRING_CE, Constant.STRING_CE_NAME, Constant.STRING_PP,
            Constant.STRING_PP_NAME);
    }
}
