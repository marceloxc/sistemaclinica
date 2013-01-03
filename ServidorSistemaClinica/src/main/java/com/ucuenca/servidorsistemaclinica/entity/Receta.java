/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.servidorsistemaclinica.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcelo
 */
@Entity
@Table(name = "receta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Receta.findAll", query = "SELECT r FROM Receta r"),
    @NamedQuery(name = "Receta.findByIdReceta", query = "SELECT r FROM Receta r WHERE r.idReceta = :idReceta"),
    @NamedQuery(name = "Receta.findByIdPaciente", query = "SELECT r FROM Receta r WHERE r.idPaciente = :idPaciente"),
    @NamedQuery(name = "Receta.findByDescripcion", query = "SELECT r FROM Receta r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "Receta.findByIndicaciones", query = "SELECT r FROM Receta r WHERE r.indicaciones = :indicaciones")})
public class Receta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idReceta")
    private Integer idReceta;
    @Size(max = 11)
    @Column(name = "idPaciente")
    private String idPaciente;
    @Size(max = 50)
    @Column(name = "Descripcion")
    private String descripcion;
    @Size(max = 45)
    @Column(name = "Indicaciones")
    private String indicaciones;
    @JoinColumn(name = "idCita", referencedColumnName = "idCita")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cita idCita;

    public Receta() {
    }

    public Receta(Integer idReceta) {
        this.idReceta = idReceta;
    }

    public Integer getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Integer idReceta) {
        this.idReceta = idReceta;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }

    public Cita getIdCita() {
        return idCita;
    }

    public void setIdCita(Cita idCita) {
        this.idCita = idCita;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReceta != null ? idReceta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receta)) {
            return false;
        }
        Receta other = (Receta) object;
        if ((this.idReceta == null && other.idReceta != null) || (this.idReceta != null && !this.idReceta.equals(other.idReceta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ucuenca.servidorsistemaclinica.Receta[ idReceta=" + idReceta + " ]";
    }
    
}
