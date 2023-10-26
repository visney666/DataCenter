/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Casa Ortopedica
 */
@Entity
@Table(name = "vendedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedor.findAll", query = "SELECT v FROM Vendedor v")
    , @NamedQuery(name = "Vendedor.findByVendedorId", query = "SELECT v FROM Vendedor v WHERE v.vendedorId = :vendedorId")
    , @NamedQuery(name = "Vendedor.findByCedula", query = "SELECT v FROM Vendedor v WHERE v.cedula = :cedula")
    , @NamedQuery(name = "Vendedor.findByNombre", query = "SELECT v FROM Vendedor v WHERE v.nombre = :nombre")})
public class Vendedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vendedor_id")
    private Integer vendedorId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cedula")
    private String cedula;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendedor")
    private Collection<Recarga> recargaCollection;

    public Vendedor() {
    }

    public Vendedor(Integer vendedorId) {
        this.vendedorId = vendedorId;
    }

    public Vendedor(Integer vendedorId, String cedula) {
        this.vendedorId = vendedorId;
        this.cedula = cedula;
    }

    public Integer getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(Integer vendedorId) {
        this.vendedorId = vendedorId;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Recarga> getRecargaCollection() {
        return recargaCollection;
    }

    public void setRecargaCollection(Collection<Recarga> recargaCollection) {
        this.recargaCollection = recargaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vendedorId != null ? vendedorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedor)) {
            return false;
        }
        Vendedor other = (Vendedor) object;
        if ((this.vendedorId == null && other.vendedorId != null) || (this.vendedorId != null && !this.vendedorId.equals(other.vendedorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Vendedor[ vendedorId=" + vendedorId + " ]";
    }
    
}
