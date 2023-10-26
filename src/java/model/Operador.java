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
@Table(name = "operador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operador.findAll", query = "SELECT o FROM Operador o")
    , @NamedQuery(name = "Operador.findByOperadorId", query = "SELECT o FROM Operador o WHERE o.operadorId = :operadorId")
    , @NamedQuery(name = "Operador.findByNombre", query = "SELECT o FROM Operador o WHERE o.nombre = :nombre")})
public class Operador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "operador_id")
    private Integer operadorId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operador")
    private Collection<Recarga> recargaCollection;

    public Operador() {
    }

    public Operador(Integer operadorId) {
        this.operadorId = operadorId;
    }

    public Operador(Integer operadorId, String nombre) {
        this.operadorId = operadorId;
        this.nombre = nombre;
    }

    public Integer getOperadorId() {
        return operadorId;
    }

    public void setOperadorId(Integer operadorId) {
        this.operadorId = operadorId;
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
        hash += (operadorId != null ? operadorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operador)) {
            return false;
        }
        Operador other = (Operador) object;
        if ((this.operadorId == null && other.operadorId != null) || (this.operadorId != null && !this.operadorId.equals(other.operadorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Operador[ operadorId=" + operadorId + " ]";
    }
    
}
