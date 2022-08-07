package com.asesoftware.lab.carcenter.model.dtos;

import com.asesoftware.lab.carcenter.util.Constant;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NuevoMecanico {

    @NotNull
    @Size(min = Constant.INT_NUMBER_TWO, max = Constant.INT_NUMBER_TWO)
    private String tipoDocumento;

    @NotNull
    private Integer documento;

    @NotNull
    @Size(min = Constant.INT_NUMBER_TWO, max = Constant.INT_NUMBER_THIRTY)
    private String primerNombre;

    @Size(min = Constant.INT_NUMBER_TWO, max = Constant.INT_NUMBER_THIRTY)
    private String segundoNombre;

    @NotNull
    @Size(min = Constant.INT_NUMBER_TWO, max = Constant.INT_NUMBER_THIRTY)
    private String primerApellido;

    @Size(min = Constant.INT_NUMBER_TWO, max = Constant.INT_NUMBER_THIRTY)
    private String segundoApellido;

    @NotNull
    @Size(min = Constant.INT_NUMBER_TEN, max = Constant.INT_NUMBER_TEN)
    private String celular;

    @NotNull
    @Size(min = Constant.INT_NUMBER_FIVE, max = Constant.INT_NUMBER_TWO_HUNDRED)
    private String direccion;

    @NotNull
    @Size(min = Constant.INT_NUMBER_FIVE, max = Constant.INT_NUMBER_ONE_HUNDRED)
    private String email;

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
