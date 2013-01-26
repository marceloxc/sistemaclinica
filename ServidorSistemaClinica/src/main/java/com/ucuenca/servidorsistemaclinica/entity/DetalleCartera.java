/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.servidorsistemaclinica.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author Fernanda
 */
@Entity
@Table(name = "detallecartera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleCartera.findAll", query = "SELECT d FROM DetalleCartera d"),
    @NamedQuery(name = "DetalleCartera.findByIdDetalleCartera", query = "SELECT d FROM DetalleCartera d WHERE d.idDetalleCartera = :idDetalleCartera"),
    @NamedQuery(name = "DetalleCartera.findByFecha", query = "SELECT d FROM DetalleCartera d WHERE d.fecha = :fecha"),
    @NamedQuery(name = "DetalleCartera.findByAbono", query = "SELECT d FROM DetalleCartera d WHERE d.abono = :abono")})
public class DetalleCartera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetalleCartera")
    private Integer idDetalleCartera;
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Abono")
    private Double abono;
    @JoinColumn(name = "idCartera", referencedColumnName = "idCartera")
    @ManyToOne(optional = false)
    private Cartera idCartera;

    public DetalleCartera() {
    }

    public DetalleCartera(Integer idDetalleCartera) {
        this.idDetalleCartera = idDetalleCartera;
    }

    public Integer getIdDetalleCartera() {
        return idDetalleCartera;
    }

    public void setIdDetalleCartera(Integer idDetalleCartera) {
        this.idDetalleCartera = idDetalleCartera;
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

    public Cartera getIdCartera() {
        return idCartera;
    }

    public void setIdCartera(Cartera idCartera) {
        this.idCartera = idCartera;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleCartera != null ? idDetalleCartera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCartera)) {
            return false;
        }
        DetalleCartera other = (DetalleCartera) object;
        if ((this.idDetalleCartera == null && other.idDetalleCartera != null) || (this.idDetalleCartera != null && !this.idDetalleCartera.equals(other.idDetalleCartera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ucuenca.servidorsistemaclinica.entity.DetalleCartera[ idDetalleCartera=" + idDetalleCartera + " ]";
    }
    
}
