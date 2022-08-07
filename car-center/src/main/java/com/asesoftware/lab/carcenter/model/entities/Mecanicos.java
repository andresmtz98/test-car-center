package com.asesoftware.lab.carcenter.model.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.PrePersist;
import java.util.Date;
import java.util.Objects;

@Entity @IdClass(MecanicosPK.class) public class Mecanicos {
    @Id @Column(name = "tipo_documento") private String tipoDocumento;
    @Id @Column(name = "documento") private Integer documento;
    @Basic @Column(name = "primer_nombre") private String primerNombre;
    @Basic @Column(name = "segundo_nombre") private String segundoNombre;
    @Basic @Column(name = "primer_apellido") private String primerApellido;
    @Basic @Column(name = "segundo_apellido") private String segundoApellido;
    @Basic @Column(name = "celular") private String celular;
    @Basic @Column(name = "direccion") private String direccion;
    @Basic @Column(name = "email") private String email;
    @Basic @Column(name = "estado") private String estado;
    @Basic @Column(name = "fecha_registro") private Date fechaRegistro;

    private Mecanicos(Builder builder) {
        setTipoDocumento(builder.tipoDocumento);
        setDocumento(builder.documento);
        setPrimerNombre(builder.primerNombre);
        setSegundoNombre(builder.segundoNombre);
        setPrimerApellido(builder.primerApellido);
        setSegundoApellido(builder.segundoApellido);
        setCelular(builder.celular);
        setDireccion(builder.direccion);
        setEmail(builder.email);
        setEstado(builder.estado);
        setFechaRegistro(builder.fechaRegistro);
    }

    public Mecanicos() {
    }

    public static Builder builder() {
        return new Builder();
    }

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @PrePersist
    public void prePersist() {
        this.fechaRegistro = new Date();
        this.estado = "A";
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Mecanicos mecanicos = (Mecanicos) o;
        return Objects.equals(tipoDocumento, mecanicos.tipoDocumento)
            && Objects.equals(documento, mecanicos.documento) && Objects.equals(
            primerNombre, mecanicos.primerNombre) && Objects.equals(
            segundoNombre, mecanicos.segundoNombre) && Objects.equals(
            primerApellido, mecanicos.primerApellido) && Objects.equals(
            segundoApellido, mecanicos.segundoApellido) && Objects.equals(
            celular, mecanicos.celular) && Objects.equals(direccion,
            mecanicos.direccion) && Objects.equals(email, mecanicos.email)
            && Objects.equals(estado, mecanicos.estado) && Objects.equals(
            fechaRegistro, mecanicos.fechaRegistro);
    }

    @Override public int hashCode() {
        return Objects.hash(tipoDocumento, documento, primerNombre,
            segundoNombre, primerApellido, segundoApellido, celular, direccion,
            email, estado, fechaRegistro);
    }

    public static final class Builder {
        private String tipoDocumento;
        private Integer documento;
        private String primerNombre;
        private String segundoNombre;
        private String primerApellido;
        private String segundoApellido;
        private String celular;
        private String direccion;
        private String email;
        private String estado;
        private Date fechaRegistro;

        private Builder() {
        }

        public Builder withTipoDocumento(String tipoDocumento) {
            this.tipoDocumento = tipoDocumento;
            return this;
        }

        public Builder withDocumento(Integer documento) {
            this.documento = documento;
            return this;
        }

        public Builder withPrimerNombre(String primerNombre) {
            this.primerNombre = primerNombre;
            return this;
        }

        public Builder withSegundoNombre(String segundoNombre) {
            this.segundoNombre = segundoNombre;
            return this;
        }

        public Builder withPrimerApellido(String primerApellido) {
            this.primerApellido = primerApellido;
            return this;
        }

        public Builder withSegundoApellido(String segundoApellido) {
            this.segundoApellido = segundoApellido;
            return this;
        }

        public Builder withCelular(String celular) {
            this.celular = celular;
            return this;
        }

        public Builder withDireccion(String direccion) {
            this.direccion = direccion;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withEstado(String estado) {
            this.estado = estado;
            return this;
        }

        public Builder withFechaRegistro(Date fechaRegistro) {
            this.fechaRegistro = fechaRegistro;
            return this;
        }

        public Mecanicos build() {
            return new Mecanicos(this);
        }
    }
}
