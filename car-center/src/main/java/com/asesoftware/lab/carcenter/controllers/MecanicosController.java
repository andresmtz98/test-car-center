package com.asesoftware.lab.carcenter.controllers;

import com.asesoftware.lab.carcenter.model.dtos.NuevoMecanico;
import com.asesoftware.lab.carcenter.model.entities.Mecanicos;
import com.asesoftware.lab.carcenter.service.interfaces.MecanicosService;
import com.asesoftware.lab.carcenter.util.CarCenterUtil;
import com.asesoftware.lab.carcenter.util.Constant;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@SessionAttributes({ Constant.STRING_REGISTRO_MECANICO_PROPERTY, Constant.STRING_TIPOS_IDENTIFICACION })
public class MecanicosController {

    private final MecanicosService mecanicosService;

    public MecanicosController(MecanicosService mecanicosService) {
        this.mecanicosService = mecanicosService;
    }

    @GetMapping(Constant.STRING_SLASH)
    public String inicio(Model model, @RequestParam(required = false) Pageable page) {
        if (page == null)
            page = Pageable.ofSize(Constant.INT_NUMBER_TEN);
        // Busca los mecánicos disponibles en la BD y los pasa como parámetro a la vista
        model.addAttribute(Constant.STRING_DISPONIBLES, mecanicosService.consultarMecanicosDisponibles(page));
        return Constant.STRING_HOME;
    }

    @GetMapping(Constant.STRING_SLASH + Constant.STRING_NEW)
    public String registro(Model model) {
        model.addAttribute(Constant.STRING_REGISTRO_MECANICO_PROPERTY, new NuevoMecanico());
        model.addAttribute(Constant.STRING_TIPOS_IDENTIFICACION, CarCenterUtil.generarTiposIdentificacion());
        return Constant.STRING_NEW;
    }

    @PostMapping(Constant.STRING_SLASH + Constant.STRING_NEW)
    public String registrar(@Valid @ModelAttribute(Constant.STRING_REGISTRO_MECANICO_PROPERTY)
        NuevoMecanico nuevoMecanico, BindingResult bindingResult, Model model, SessionStatus sessionStatus) {

        // Se valida si nuevoMecanico tiene errores de validación
        if (bindingResult.hasErrors()) {
            return Constant.STRING_NEW;
        }

        // Se almacena el mecánico en la BD
        Mecanicos m = mecanicosService.save(CarCenterUtil.transformarMecanico(nuevoMecanico));
        model.addAttribute(Constant.STRING_SUCESS, m != null);
        model.addAttribute(Constant.STRING_REGISTRO_MECANICO_PROPERTY, new NuevoMecanico());
        sessionStatus.setComplete();
        return Constant.STRING_NEW;
    }
}
