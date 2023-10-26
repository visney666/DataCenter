/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Casa Ortopedica
 */
@Entity
@Table(name = "recarga")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recarga.findAll", query = "SELECT r FROM Recarga r")
    , @NamedQuery(name = "Recarga.findByIdRecarga", query = "SELECT r FROM Recarga r WHERE r.recargaPK.idRecarga = :idRecarga")
    , @NamedQuery(name = "Recarga.findByVendedorId", query = "SELECT r FROM Recarga r WHERE r.recargaPK.vendedorId = :vendedorId")
    , @NamedQuery(name = "Recarga.findByOperadorId", query = "SELECT r FROM Recarga r WHERE r.recargaPK.operadorId = :operadorId")
    , @NamedQuery(name = "Recarga.findByValor", query = "SELECT r FROM Recarga r WHERE r.valor = :valor")})
public class Recarga implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RecargaPK recargaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;
    @JoinColumn(name = "operador_id", referencedColumnName = "operador_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Operador operador;
    @JoinColumn(name = "vendedor_id", referencedColumnName = "vendedor_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Vendedor vendedor;

    public Recarga() {
    }

    public Recarga(RecargaPK recargaPK) {
        this.recargaPK = recargaPK;
    }

    public Recarga(RecargaPK recargaPK, double valor) {
        this.recargaPK = recargaPK;
        this.valor = valor;
    }

    public Recarga(int idRecarga, int vendedorId, int operadorId) {
        this.recargaPK = new RecargaPK(idRecarga, vendedorId, operadorId);
    }

    public RecargaPK getRecargaPK() {
        return recargaPK;
    }

    public void setRecargaPK(RecargaPK recargaPK) {
        this.recargaPK = recargaPK;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recargaPK != null ? recargaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recarga)) {
            return false;
        }
        Recarga other = (Recarga) object;
        if ((this.recargaPK == null && other.recargaPK != null) || (this.recargaPK != null && !this.recargaPK.equals(other.recargaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Recarga[ recargaPK=" + recargaPK + " ]";
    }
    
}
