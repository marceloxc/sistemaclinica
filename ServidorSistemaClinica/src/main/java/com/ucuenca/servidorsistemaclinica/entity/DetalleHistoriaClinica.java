/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.servidorsistemaclinica.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "detallehistoriaclinica")
@NamedQueries({
    @NamedQuery(name = "DetalleHistoriaClinica.findAll", query = "SELECT d FROM DetalleHistoriaClinica d"),
    @NamedQuery(name = "DetalleHistoriaClinica.findByCodigo", query = "SELECT d FROM DetalleHistoriaClinica d WHERE d.codigo = :codigo"),
    @NamedQuery(name = "DetalleHistoriaClinica.findByFecha", query = "SELECT d FROM DetalleHistoriaClinica d WHERE d.fecha = :fecha"),
    @NamedQuery(name = "DetalleHistoriaClinica.findByMaterial", query = "SELECT d FROM DetalleHistoriaClinica d WHERE d.material = :material"),
    @NamedQuery(name = "DetalleHistoriaClinica.findByTratamiento", query = "SELECT d FROM DetalleHistoriaClinica d WHERE d.tratamiento = :tratamiento"),
    @NamedQuery(name = "DetalleHistoriaClinica.findByCodigoHistoriaClinica", query = "SELECT d FROM DetalleHistoriaClinica d WHERE d.codigoHistoriaClinica = :codigoHistoriaClinica")})
public class DetalleHistoriaClinica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Codigo")
    private Integer codigo;
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 45)
    @Column(name = "Material")
    private String material;
    @Size(max = 45)
    @Column(name = "Tratamiento")
    private String tratamiento;    
    @JoinColumn(name = "codigoHistoriaClinica", referencedColumnName = "Codigo")
    @ManyToOne(optional = false)
    private HistoriaClinica codigoHistoriaClinica;    
    @JoinColumn(name = "idCita", referencedColumnName = "idCita")
    @ManyToOne(optional = false)
    private Cita idCita;

    public DetalleHistoriaClinica() {
    }

    public DetalleHistoriaClinica(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public HistoriaClinica getCodigoHistoriaClinica() {
        return codigoHistoriaClinica;
    }

    public void setCodigoHistoriaClinica(HistoriaClinica codigoHistoriaClinica) {
        this.codigoHistoriaClinica = codigoHistoriaClinica;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleHistoriaClinica)) {
            return false;
        }
        DetalleHistoriaClinica other = (DetalleHistoriaClinica) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ucuenca.servidorsistemaclinica.entity.DetalleHistoriaClinica[ codigo=" + codigo + " ]";
    }
    
}
