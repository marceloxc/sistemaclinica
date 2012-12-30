/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.servidorsistemaclinica.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcelo
 */
@Entity
@Table(name = "detallehistoriaclinica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleHistoriaClinica.findAll", query = "SELECT d FROM DetalleHistoriaClinica d"),
    @NamedQuery(name = "DetalleHistoriaClinica.findByCodigo", query = "SELECT d FROM DetalleHistoriaClinica d WHERE d.detalleHistoriaClinicaPK.codigo = :codigo"),
    @NamedQuery(name = "DetalleHistoriaClinica.findByFecha", query = "SELECT d FROM DetalleHistoriaClinica d WHERE d.fecha = :fecha"),
    @NamedQuery(name = "DetalleHistoriaClinica.findByMaterial", query = "SELECT d FROM DetalleHistoriaClinica d WHERE d.material = :material"),
    @NamedQuery(name = "DetalleHistoriaClinica.findByTratamiento", query = "SELECT d FROM DetalleHistoriaClinica d WHERE d.tratamiento = :tratamiento"),
    @NamedQuery(name = "DetalleHistoriaClinica.findByCodigoHistoriaClinica", query = "SELECT d FROM DetalleHistoriaClinica d WHERE d.detalleHistoriaClinicaPK.codigoHistoriaClinica = :codigoHistoriaClinica")})
public class DetalleHistoriaClinica implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleHistoriaClinicaPK detalleHistoriaClinicaPK;
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 45)
    @Column(name = "Material")
    private String material;
    @Size(max = 45)
    @Column(name = "Tratamiento")
    private String tratamiento;
    @JoinColumn(name = "idCita", referencedColumnName = "idCita")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cita idCita;
    @JoinColumn(name = "Codigo", referencedColumnName = "Codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private HistoriaClinica historiaClinica;

    public DetalleHistoriaClinica() {
    }

    public DetalleHistoriaClinica(DetalleHistoriaClinicaPK detalleHistoriaClinicaPK) {
        this.detalleHistoriaClinicaPK = detalleHistoriaClinicaPK;
    }

    public DetalleHistoriaClinica(int codigo, int codigoHistoriaClinica) {
        this.detalleHistoriaClinicaPK = new DetalleHistoriaClinicaPK(codigo, codigoHistoriaClinica);
    }

    public DetalleHistoriaClinicaPK getDetalleHistoriaClinicaPK() {
        return detalleHistoriaClinicaPK;
    }

    public void setDetalleHistoriaClinicaPK(DetalleHistoriaClinicaPK detalleHistoriaClinicaPK) {
        this.detalleHistoriaClinicaPK = detalleHistoriaClinicaPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Cita getIdCita() {
        return idCita;
    }

    public void setIdCita(Cita idCita) {
        this.idCita = idCita;
    }

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(HistoriaClinica historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleHistoriaClinicaPK != null ? detalleHistoriaClinicaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleHistoriaClinica)) {
            return false;
        }
        DetalleHistoriaClinica other = (DetalleHistoriaClinica) object;
        if ((this.detalleHistoriaClinicaPK == null && other.detalleHistoriaClinicaPK != null) || (this.detalleHistoriaClinicaPK != null && !this.detalleHistoriaClinicaPK.equals(other.detalleHistoriaClinicaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ucuenca.servidorsistemaclinica.DetalleHistoriaClinica[ detalleHistoriaClinicaPK=" + detalleHistoriaClinicaPK + " ]";
    }
    
}
