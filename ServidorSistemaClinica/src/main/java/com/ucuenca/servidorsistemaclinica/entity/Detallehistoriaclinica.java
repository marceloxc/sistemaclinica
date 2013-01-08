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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
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
    @NamedQuery(name = "Detallehistoriaclinica.findAll", query = "SELECT d FROM Detallehistoriaclinica d"),
    @NamedQuery(name = "Detallehistoriaclinica.findByCodigo", query = "SELECT d FROM Detallehistoriaclinica d WHERE d.codigo = :codigo"),
    @NamedQuery(name = "Detallehistoriaclinica.findByFecha", query = "SELECT d FROM Detallehistoriaclinica d WHERE d.fecha = :fecha"),
    @NamedQuery(name = "Detallehistoriaclinica.findByMaterial", query = "SELECT d FROM Detallehistoriaclinica d WHERE d.material = :material"),
    @NamedQuery(name = "Detallehistoriaclinica.findByTratamiento", query = "SELECT d FROM Detallehistoriaclinica d WHERE d.tratamiento = :tratamiento"),
    @NamedQuery(name = "Detallehistoriaclinica.findByCodigoHistoriaClinica", query = "SELECT d FROM Detallehistoriaclinica d WHERE d.codigoHistoriaClinica = :codigoHistoriaClinica")})
public class Detallehistoriaclinica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodigoHistoriaClinica")
    private int codigoHistoriaClinica;
    @JoinColumn(name = "idCita", referencedColumnName = "idCita")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cita idCita;
    @JoinColumn(name = "Codigo", referencedColumnName = "Codigo", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Historiaclinica historiaclinica;

    public Detallehistoriaclinica() {
    }

    public Detallehistoriaclinica(Integer codigo) {
        this.codigo = codigo;
    }

    public Detallehistoriaclinica(Integer codigo, int codigoHistoriaClinica) {
        this.codigo = codigo;
        this.codigoHistoriaClinica = codigoHistoriaClinica;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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

    public int getCodigoHistoriaClinica() {
        return codigoHistoriaClinica;
    }

    public void setCodigoHistoriaClinica(int codigoHistoriaClinica) {
        this.codigoHistoriaClinica = codigoHistoriaClinica;
    }

    public Cita getIdCita() {
        return idCita;
    }

    public void setIdCita(Cita idCita) {
        this.idCita = idCita;
    }

    public Historiaclinica getHistoriaclinica() {
        return historiaclinica;
    }

    public void setHistoriaclinica(Historiaclinica historiaclinica) {
        this.historiaclinica = historiaclinica;
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
        if (!(object instanceof Detallehistoriaclinica)) {
            return false;
        }
        Detallehistoriaclinica other = (Detallehistoriaclinica) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ucuenca.servidorsistemaclinica.entity.Detallehistoriaclinica[ codigo=" + codigo + " ]";
    }
    
}
