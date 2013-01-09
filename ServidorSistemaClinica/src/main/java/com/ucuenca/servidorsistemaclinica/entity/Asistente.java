/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.servidorsistemaclinica.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcelo
 */
@Entity
@Table(name = "asistente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asistente.findAll", query = "SELECT a FROM Asistente a"),
    @NamedQuery(name = "Asistente.findByCedula", query = "SELECT a FROM Asistente a WHERE a.cedula = :cedula"),
    @NamedQuery(name = "Asistente.findByFechaIngreso", query = "SELECT a FROM Asistente a WHERE a.fechaIngreso = :fechaIngreso")})
public class Asistente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "Cedula")
    private String cedula;
    @Column(name = "FechaIngreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @JoinColumn(name = "idSucursal", referencedColumnName = "NumSucursal")
    @ManyToOne(fetch = FetchType.EAGER)
    private Sucursal idSucursal;
    @JoinColumn(name = "Cedula", referencedColumnName = "Cedula", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Persona persona;
    @OneToMany(mappedBy = "idAsistente", fetch = FetchType.EAGER)
    private Set<Cita> citaSet;

    public Asistente() {
    }

    public Asistente(String cedula) {
        this.cedula = cedula;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Sucursal getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Sucursal idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @XmlTransient
    public Set<Cita> getCitaSet() {
        return citaSet;
    }

    public void setCitaSet(Set<Cita> citaSet) {
        this.citaSet = citaSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asistente)) {
            return false;
        }
        Asistente other = (Asistente) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ucuenca.servidorsistemaclinica.entity.Asistente[ cedula=" + cedula + " ]";
    }
    
}
