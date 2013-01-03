/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.servidorsistemaclinica.entity;

import java.io.Serializable;
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
@Table(name = "odontologo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Odontologo.findAll", query = "SELECT o FROM Odontologo o"),
    @NamedQuery(name = "Odontologo.findByCedula", query = "SELECT o FROM Odontologo o WHERE o.cedula = :cedula"),
    @NamedQuery(name = "Odontologo.findByEspecialidad", query = "SELECT o FROM Odontologo o WHERE o.especialidad = :especialidad"),
    @NamedQuery(name = "Odontologo.findByFechaIngreso", query = "SELECT o FROM Odontologo o WHERE o.fechaIngreso = :fechaIngreso")})
public class Odontologo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "Cedula")
    private String cedula;
    @Size(max = 45)
    @Column(name = "Especialidad")
    private String especialidad;
    @Column(name = "FechaIngreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @JoinColumn(name = "idSucursal", referencedColumnName = "NumSucursal")
    @ManyToOne(fetch = FetchType.LAZY)
    private Sucursal idSucursal;
    @JoinColumn(name = "Cedula", referencedColumnName = "Cedula", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Persona persona;
    @OneToMany(mappedBy = "idOdontologo", fetch = FetchType.LAZY)
    private Set<Cita> citaSet;

    public Odontologo() {
    }

    public Odontologo(String cedula) {
        this.cedula = cedula;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
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
        if (!(object instanceof Odontologo)) {
            return false;
        }
        Odontologo other = (Odontologo) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ucuenca.servidorsistemaclinica.Odontologo[ cedula=" + cedula + " ]";
    }
    
}
