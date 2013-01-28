/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.servidorsistemaclinica.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import org.hibernate.envers.Audited;

/**
 *
 * @author DELL
 */
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE)
@Audited
@Table(name = "cartera")
@NamedQueries({
    @NamedQuery(name = "Cartera.findAll", query = "SELECT c FROM Cartera c"),
    @NamedQuery(name = "Cartera.findByIdCartera", query = "SELECT c FROM Cartera c WHERE c.idCartera = :idCartera"),
    @NamedQuery(name = "Cartera.findByDescripcion", query = "SELECT c FROM Cartera c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Cartera.findByFecha", query = "SELECT c FROM Cartera c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Cartera.findByTotalDeuda", query = "SELECT c FROM Cartera c WHERE c.totalDeuda = :totalDeuda")})
public class Cartera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCartera")
    private Integer idCartera;
    @Size(max = 45)
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TotalDeuda")
    private Double totalDeuda;
    @JoinColumn(name = "idFactura", referencedColumnName = "NumFactura")
    @ManyToOne(optional = false)
    private Factura idFactura;

    public Cartera() {
    }

    public Cartera(Integer idCartera) {
        this.idCartera = idCartera;
    }

    public Integer getIdCartera() {
        return idCartera;
    }

    public void setIdCartera(Integer idCartera) {
        this.idCartera = idCartera;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getTotalDeuda() {
        return totalDeuda;
    }

    public void setTotalDeuda(Double totalDeuda) {
        this.totalDeuda = totalDeuda;
    }

    public Factura getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Factura idFactura) {
        this.idFactura = idFactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCartera != null ? idCartera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cartera)) {
            return false;
        }
        Cartera other = (Cartera) object;
        if ((this.idCartera == null && other.idCartera != null) || (this.idCartera != null && !this.idCartera.equals(other.idCartera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ucuenca.servidorsistemaclinica.entity.Cartera[ idCartera=" + idCartera + " ]";
    }
    
}
