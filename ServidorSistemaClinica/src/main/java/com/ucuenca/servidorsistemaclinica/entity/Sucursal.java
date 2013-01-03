/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.servidorsistemaclinica.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author Marcelo
 */
@Entity
@Table(name = "sucursal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sucursal.findAll", query = "SELECT s FROM Sucursal s"),
    @NamedQuery(name = "Sucursal.findByNumSucursal", query = "SELECT s FROM Sucursal s WHERE s.numSucursal = :numSucursal"),
    @NamedQuery(name = "Sucursal.findByDireccion", query = "SELECT s FROM Sucursal s WHERE s.direccion = :direccion"),
    @NamedQuery(name = "Sucursal.findByTelefono", query = "SELECT s FROM Sucursal s WHERE s.telefono = :telefono")})
public class Sucursal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NumSucursal")
    private Integer numSucursal;
    @Size(max = 45)
    @Column(name = "Direccion")
    private String direccion;
    @Size(max = 11)
    @Column(name = "Telefono")
    private String telefono;
    @OneToMany(mappedBy = "idSucursal", fetch = FetchType.LAZY)
    private Set<Asistente> asistenteSet;
    @OneToMany(mappedBy = "idSucursal", fetch = FetchType.LAZY)
    private Set<Odontologo> odontologoSet;

    public Sucursal() {
    }

    public Sucursal(Integer numSucursal) {
        this.numSucursal = numSucursal;
    }

    public Integer getNumSucursal() {
        return numSucursal;
    }

    public void setNumSucursal(Integer numSucursal) {
        this.numSucursal = numSucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public Set<Asistente> getAsistenteSet() {
        return asistenteSet;
    }

    public void setAsistenteSet(Set<Asistente> asistenteSet) {
        this.asistenteSet = asistenteSet;
    }

    @XmlTransient
    public Set<Odontologo> getOdontologoSet() {
        return odontologoSet;
    }

    public void setOdontologoSet(Set<Odontologo> odontologoSet) {
        this.odontologoSet = odontologoSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numSucursal != null ? numSucursal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursal)) {
            return false;
        }
        Sucursal other = (Sucursal) object;
        if ((this.numSucursal == null && other.numSucursal != null) || (this.numSucursal != null && !this.numSucursal.equals(other.numSucursal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ucuenca.servidorsistemaclinica.Sucursal[ numSucursal=" + numSucursal + " ]";
    }
    
}
