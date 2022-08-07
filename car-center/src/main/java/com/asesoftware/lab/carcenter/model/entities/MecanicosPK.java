package com.asesoftware.lab.carcenter.model.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MecanicosPK implements Serializable {
    @Column(name = "tipo_documento") @Id private String tipoDocumento;
    @Column(name = "documento") @Id private Integer documento;

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

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MecanicosPK that = (MecanicosPK) o;
        return Objects.equals(tipoDocumento, that.tipoDocumento)
            && Objects.equals(documento, that.documento);
    }

    @Override public int hashCode() {
        return Objects.hash(tipoDocumento, documento);
    }
}
