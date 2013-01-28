/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.servidorsistemaclinica.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
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
@Table(name = "historiaclinica")
@NamedQueries({
    @NamedQuery(name = "HistoriaClinica.findAll", query = "SELECT h FROM HistoriaClinica h"),
    @NamedQuery(name = "HistoriaClinica.findByCodigo", query = "SELECT h FROM HistoriaClinica h WHERE h.codigo = :codigo"),
    @NamedQuery(name = "HistoriaClinica.findByFechaCreacion", query = "SELECT h FROM HistoriaClinica h WHERE h.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "HistoriaClinica.findByPresionArterial", query = "SELECT h FROM HistoriaClinica h WHERE h.presionArterial = :presionArterial"),
    @NamedQuery(name = "HistoriaClinica.findByTSanCoagTrans", query = "SELECT h FROM HistoriaClinica h WHERE h.tSanCoagTrans = :tSanCoagTrans"),
    @NamedQuery(name = "HistoriaClinica.findByAlergias", query = "SELECT h FROM HistoriaClinica h WHERE h.alergias = :alergias"),
    @NamedQuery(name = "HistoriaClinica.findByMedActualCronica", query = "SELECT h FROM HistoriaClinica h WHERE h.medActualCronica = :medActualCronica"),
    @NamedQuery(name = "HistoriaClinica.findByOtrasEnfermedades", query = "SELECT h FROM HistoriaClinica h WHERE h.otrasEnfermedades = :otrasEnfermedades"),
    @NamedQuery(name = "HistoriaClinica.findByHalitosis", query = "SELECT h FROM HistoriaClinica h WHERE h.halitosis = :halitosis"),
    @NamedQuery(name = "HistoriaClinica.findByXerostomia", query = "SELECT h FROM HistoriaClinica h WHERE h.xerostomia = :xerostomia"),
    @NamedQuery(name = "HistoriaClinica.findByBruxismo", query = "SELECT h FROM HistoriaClinica h WHERE h.bruxismo = :bruxismo"),
    @NamedQuery(name = "HistoriaClinica.findByObservaciones", query = "SELECT h FROM HistoriaClinica h WHERE h.observaciones = :observaciones"),
    @NamedQuery(name = "HistoriaClinica.findByIdPaciente", query = "SELECT h FROM HistoriaClinica h WHERE h.idPaciente = :idPaciente"),
    @NamedQuery(name = "HistoriaClinica.findBySangradoEncias", query = "SELECT h FROM HistoriaClinica h WHERE h.sangradoEncias = :sangradoEncias"),
    @NamedQuery(name = "HistoriaClinica.findByHipersensibilidad", query = "SELECT h FROM HistoriaClinica h WHERE h.hipersensibilidad = :hipersensibilidad"),
    @NamedQuery(name = "HistoriaClinica.findByEnfermCardiacas", query = "SELECT h FROM HistoriaClinica h WHERE h.enfermCardiacas = :enfermCardiacas")})
public class HistoriaClinica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Codigo")
    private Integer codigo;
    @Column(name = "FechaCreacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "PresionArterial")
    private Character presionArterial;
    @Size(max = 45)
    @Column(name = "TSanCoagTrans")
    private String tSanCoagTrans;
    @Size(max = 45)
    @Column(name = "Alergias")
    private String alergias;
    @Size(max = 45)
    @Column(name = "MedActualCronica")
    private String medActualCronica;
    @Size(max = 100)
    @Column(name = "OtrasEnfermedades")
    private String otrasEnfermedades;
    @Column(name = "Halitosis")
    private Character halitosis;
    @Column(name = "Xerostomia")
    private Character xerostomia;
    @Column(name = "Bruxismo")
    private Character bruxismo;
    @Size(max = 45)
    @Column(name = "Observaciones")
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "IdPaciente")
    private String idPaciente;
    @Column(name = "SangradoEncias")
    private Character sangradoEncias;
    @Column(name = "Hipersensibilidad")
    private Character hipersensibilidad;
    @Size(max = 50)
    @Column(name = "EnfermCardiacas")
    private String enfermCardiacas;

    public HistoriaClinica() {
    }

    public HistoriaClinica(Integer codigo) {
        this.codigo = codigo;
    }

    public HistoriaClinica(Integer codigo, String idPaciente) {
        this.codigo = codigo;
        this.idPaciente = idPaciente;
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

    public String getTSanCoagTrans() {
        return tSanCoagTrans;
    }

    public void setTSanCoagTrans(String tSanCoagTrans) {
        this.tSanCoagTrans = tSanCoagTrans;
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

    public String getOtrasEnfermedades() {
        return otrasEnfermedades;
    }

    public void setOtrasEnfermedades(String otrasEnfermedades) {
        this.otrasEnfermedades = otrasEnfermedades;
    }

    public Character getHalitosis() {
        return halitosis;
    }

    public void setHalitosis(Character halitosis) {
        this.halitosis = halitosis;
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

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Character getSangradoEncias() {
        return sangradoEncias;
    }

    public void setSangradoEncias(Character sangradoEncias) {
        this.sangradoEncias = sangradoEncias;
    }

    public Character getHipersensibilidad() {
        return hipersensibilidad;
    }

    public void setHipersensibilidad(Character hipersensibilidad) {
        this.hipersensibilidad = hipersensibilidad;
    }

    public String getEnfermCardiacas() {
        return enfermCardiacas;
    }

    public void setEnfermCardiacas(String enfermCardiacas) {
        this.enfermCardiacas = enfermCardiacas;
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
        if (!(object instanceof HistoriaClinica)) {
            return false;
        }
        HistoriaClinica other = (HistoriaClinica) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ucuenca.servidorsistemaclinica.entity.HistoriaClinica[ codigo=" + codigo + " ]";
    }
    
}
