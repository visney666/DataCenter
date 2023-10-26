/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Casa Ortopedica
 */
@Embeddable
public class RecargaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_recarga")
    private int idRecarga;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vendedor_id")
    private int vendedorId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "operador_id")
    private int operadorId;

    public RecargaPK() {
    }

    public RecargaPK(int idRecarga, int vendedorId, int operadorId) {
        this.idRecarga = idRecarga;
        this.vendedorId = vendedorId;
        this.operadorId = operadorId;
    }

    public int getIdRecarga() {
        return idRecarga;
    }

    public void setIdRecarga(int idRecarga) {
        this.idRecarga = idRecarga;
    }

    public int getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(int vendedorId) {
        this.vendedorId = vendedorId;
    }

    public int getOperadorId() {
        return operadorId;
    }

    public void setOperadorId(int operadorId) {
        this.operadorId = operadorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idRecarga;
        hash += (int) vendedorId;
        hash += (int) operadorId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecargaPK)) {
            return false;
        }
        RecargaPK other = (RecargaPK) object;
        if (this.idRecarga != other.idRecarga) {
            return false;
        }
        if (this.vendedorId != other.vendedorId) {
            return false;
        }
        if (this.operadorId != other.operadorId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.RecargaPK[ idRecarga=" + idRecarga + ", vendedorId=" + vendedorId + ", operadorId=" + operadorId + " ]";
    }
    
}
