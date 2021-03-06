/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rregistro;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author agentecsj8
 */
@Entity
@Table(name = "ASOCIADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asociado.findAll", query = "SELECT a FROM Asociado a"),
    @NamedQuery(name = "Asociado.findByNombre", query = "SELECT a FROM Asociado a WHERE a.nombre = :nombre")})
public class Asociado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(mappedBy = "idAsociado")
    private Collection<Registradora> registradoraCollection;

    public Asociado() {
    }

    public Asociado(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Registradora> getRegistradoraCollection() {
        return registradoraCollection;
    }

    public void setRegistradoraCollection(Collection<Registradora> registradoraCollection) {
        this.registradoraCollection = registradoraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombre != null ? nombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asociado)) {
            return false;
        }
        Asociado other = (Asociado) object;
        if ((this.nombre == null && other.nombre != null) || (this.nombre != null && !this.nombre.equals(other.nombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rregistro.Asociado[ nombre=" + nombre + " ]";
    }

    void setId(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String getNombreClase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
