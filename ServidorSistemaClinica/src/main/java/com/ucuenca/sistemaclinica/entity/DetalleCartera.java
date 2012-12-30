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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcelo
 */
@Entity
@Table(name = "detallecartera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleCartera.findAll", query = "SELECT d FROM DetalleCartera d"),
    @NamedQuery(name = "DetalleCartera.findByIdDetalleCartera", query = "SELECT d FROM DetalleCartera d WHERE d.detalleCarteraPK.idDetalleCartera = :idDetalleCartera"),
    @NamedQuery(name = "DetalleCartera.findByFecha", query = "SELECT d FROM DetalleCartera d WHERE d.fecha = :fecha"),
    @NamedQuery(name = "DetalleCartera.findByAbono", query = "SELECT d FROM DetalleCartera d WHERE d.abono = :abono"),
    @NamedQuery(name = "DetalleCartera.findByIdCartera", query = "SELECT d FROM DetalleCartera d WHERE d.detalleCarteraPK.idCartera = :idCartera")})
public class DetalleCartera implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleCarteraPK detalleCarteraPK;
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Abono")
    private Double abono;
    @JoinColumn(name = "idCartera", referencedColumnName = "idCartera", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cartera cartera;

    public DetalleCartera() {
    }

    public DetalleCartera(DetalleCarteraPK detalleCarteraPK) {
        this.detalleCarteraPK = detalleCarteraPK;
    }

    public DetalleCartera(int idDetalleCartera, int idCartera) {
        this.detalleCarteraPK = new DetalleCarteraPK(idDetalleCartera, idCartera);
    }

    public DetalleCarteraPK getDetalleCarteraPK() {
        return detalleCarteraPK;
    }

    public void setDetalleCarteraPK(DetalleCarteraPK detalleCarteraPK) {
        this.detalleCarteraPK = detalleCarteraPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getAbono() {
        return abono;
    }

    public void setAbono(Double abono) {
        this.abono = abono;
    }

    public Cartera getCartera() {
        return cartera;
    }

    public void setCartera(Cartera cartera) {
        this.cartera = cartera;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleCarteraPK != null ? detalleCarteraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCartera)) {
            return false;
        }
        DetalleCartera other = (DetalleCartera) object;
        if ((this.detalleCarteraPK == null && other.detalleCarteraPK != null) || (this.detalleCarteraPK != null && !this.detalleCarteraPK.equals(other.detalleCarteraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ucuenca.servidorsistemaclinica.DetalleCartera[ detalleCarteraPK=" + detalleCarteraPK + " ]";
    }
    
}
