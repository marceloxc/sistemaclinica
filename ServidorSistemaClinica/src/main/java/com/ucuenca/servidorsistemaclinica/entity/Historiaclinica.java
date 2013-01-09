/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.servidorsistemaclinica.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "historiaclinica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historiaclinica.findAll", query = "SELECT h FROM Historiaclinica h"),
    @NamedQuery(name = "Historiaclinica.findByCodigo", query = "SELECT h FROM Historiaclinica h WHERE h.codigo = :codigo"),
    @NamedQuery(name = "Historiaclinica.findByFechaCreacion", query = "SELECT h FROM Historiaclinica h WHERE h.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Historiaclinica.findByPresionArterial", query = "SELECT h FROM Historiaclinica h WHERE h.presionArterial = :presionArterial"),
    @NamedQuery(name = "Historiaclinica.findByTSanguineos", query = "SELECT h FROM Historiaclinica h WHERE h.tSanguineos = :tSanguineos"),
    @NamedQuery(name = "Historiaclinica.findByCoagulacion", query = "SELECT h FROM Historiaclinica h WHERE h.coagulacion = :coagulacion"),
    @NamedQuery(name = "Historiaclinica.findByTransfusiones", query = "SELECT h FROM Historiaclinica h WHERE h.transfusiones = :transfusiones"),
    @NamedQuery(name = "Historiaclinica.findByAlergias", query = "SELECT h FROM Historiaclinica h WHERE h.alergias = :alergias"),
    @NamedQuery(name = "Historiaclinica.findByMedActualCronica", query = "SELECT h FROM Historiaclinica h WHERE h.medActualCronica = :medActualCronica"),
    @NamedQuery(name = "Historiaclinica.findByDiabetes", query = "SELECT h FROM Historiaclinica h WHERE h.diabetes = :diabetes"),
    @NamedQuery(name = "Historiaclinica.findByEpilepsia", query = "SELECT h FROM Historiaclinica h WHERE h.epilepsia = :epilepsia"),
    @NamedQuery(name = "Historiaclinica.findByCancer", query = "SELECT h FROM Historiaclinica h WHERE h.cancer = :cancer"),
    @NamedQuery(name = "Historiaclinica.findByHalitosis", query = "SELECT h FROM Historiaclinica h WHERE h.halitosis = :halitosis"),
    @NamedQuery(name = "Historiaclinica.findByHFrioCalor", query = "SELECT h FROM Historiaclinica h WHERE h.hFrioCalor = :hFrioCalor"),
    @NamedQuery(name = "Historiaclinica.findByHDulce", query = "SELECT h FROM Historiaclinica h WHERE h.hDulce = :hDulce"),
    @NamedQuery(name = "Historiaclinica.findBySangradoEncias", query = "SELECT h FROM Historiaclinica h WHERE h.sangradoEncias = :sangradoEncias"),
    @NamedQuery(name = "Historiaclinica.findByXerostomia", query = "SELECT h FROM Historiaclinica h WHERE h.xerostomia = :xerostomia"),
    @NamedQuery(name = "Historiaclinica.findByBruxismo", query = "SELECT h FROM Historiaclinica h WHERE h.bruxismo = :bruxismo"),
    @NamedQuery(name = "Historiaclinica.findByObservaciones", query = "SELECT h FROM Historiaclinica h WHERE h.observaciones = :observaciones")})
public class Historiaclinica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Codigo")
    private Integer codigo;
    @Column(name = "FechaCreacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "PresionArterial")
    private Character presionArterial;
    @Size(max = 45)
    @Column(name = "TSanguineos")
    private String tSanguineos;
    @Size(max = 45)
    @Column(name = "Coagulacion")
    private String coagulacion;
    @Size(max = 45)
    @Column(name = "Transfusiones")
    private String transfusiones;
    @Size(max = 45)
    @Column(name = "Alergias")
    private String alergias;
    @Size(max = 45)
    @Column(name = "MedActualCronica")
    private String medActualCronica;
    @Column(name = "Diabetes")
    private Character diabetes;
    @Column(name = "Epilepsia")
    private Character epilepsia;
    @Column(name = "Cancer")
    private Character cancer;
    @Column(name = "Halitosis")
    private Character halitosis;
    @Column(name = "HFrioCalor")
    private Character hFrioCalor;
    @Column(name = "HDulce")
    private Character hDulce;
    @Column(name = "SangradoEncias")
    private Character sangradoEncias;
    @Column(name = "Xerostomia")
    private Character xerostomia;
    @Column(name = "Bruxismo")
    private Character bruxismo;
    @Size(max = 45)
    @Column(name = "Observaciones")
    private String observaciones;
    @JoinColumn(name = "IdPaciente", referencedColumnName = "Cedula")
    @ManyToOne(fetch = FetchType.LAZY)
    private Paciente idPaciente;


    public Historiaclinica() {
    }

    public Historiaclinica(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Character getPresionArterial() {
        return presionArterial;
    }

    public void setPresionArterial(Character presionArterial) {
        this.presionArterial = presionArterial;
    }

    public String getTSanguineos() {
        return tSanguineos;
    }

    public void setTSanguineos(String tSanguineos) {
        this.tSanguineos = tSanguineos;
    }

    public String getCoagulacion() {
        return coagulacion;
    }

    public void setCoagulacion(String coagulacion) {
        this.coagulacion = coagulacion;
    }

    public String getTransfusiones() {
        return transfusiones;
    }

    public void setTransfusiones(String transfusiones) {
        this.transfusiones = transfusiones;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getMedActualCronica() {
        return medActualCronica;
    }

    public void setMedActualCronica(String medActualCronica) {
        this.medActualCronica = medActualCronica;
    }

    public Character getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(Character diabetes) {
        this.diabetes = diabetes;
    }

    public Character getEpilepsia() {
        return epilepsia;
    }

    public void setEpilepsia(Character epilepsia) {
        this.epilepsia = epilepsia;
    }

    public Character getCancer() {
        return cancer;
    }

    public void setCancer(Character cancer) {
        this.cancer = cancer;
    }

    public Character getHalitosis() {
        return halitosis;
    }

    public void setHalitosis(Character halitosis) {
        this.halitosis = halitosis;
    }

    public Character getHFrioCalor() {
        return hFrioCalor;
    }

    public void setHFrioCalor(Character hFrioCalor) {
        this.hFrioCalor = hFrioCalor;
    }

    public Character getHDulce() {
        return hDulce;
    }

    public void setHDulce(Character hDulce) {
        this.hDulce = hDulce;
    }

    public Character getSangradoEncias() {
        return sangradoEncias;
    }

    public void setSangradoEncias(Character sangradoEncias) {
        this.sangradoEncias = sangradoEncias;
    }

    public Character getXerostomia() {
        return xerostomia;
    }

    public void setXerostomia(Character xerostomia) {
        this.xerostomia = xerostomia;
    }

    public Character getBruxismo() {
        return bruxismo;
    }

    public void setBruxismo(Character bruxismo) {
        this.bruxismo = bruxismo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Paciente getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Paciente idPaciente) {
        this.idPaciente = idPaciente;
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
        if (!(object instanceof Historiaclinica)) {
            return false;
        }
        Historiaclinica other = (Historiaclinica) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ucuenca.servidorsistemaclinica.entity.Historiaclinica[ codigo=" + codigo + " ]";
    }
    
}
