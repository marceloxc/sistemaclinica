/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.servidorsistemaclinica.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcelo
 */
@Entity
@Table(name = "cita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cita.findAll", query = "SELECT c FROM Cita c"),
    @NamedQuery(name = "Cita.findByIdCita", query = "SELECT c FROM Cita c WHERE c.citaPK.idCita = :idCita"),
    @NamedQuery(name = "Cita.findByIdPaciente", query = "SELECT c FROM Cita c WHERE c.citaPK.idPaciente = :idPaciente"),
    @NamedQuery(name = "Cita.findByFecha", query = "SELECT c FROM Cita c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Cita.findByMotivo", query = "SELECT c FROM Cita c WHERE c.motivo = :motivo")})
public class Cita implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CitaPK citaPK;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 45)
    @Column(name = "motivo")
    private String motivo;
    @OneToMany(mappedBy = "idCita", fetch = FetchType.LAZY)
    private Set<Receta> recetaSet;
    @OneToMany(mappedBy = "idCita", fetch = FetchType.LAZY)
    private Set<Factura> facturaSet;
    @OneToMany(mappedBy = "idPaciente", fetch = FetchType.LAZY)
    private Set<Factura> facturaSet1;
    @JoinColumn(name = "idAsistente", referencedColumnName = "Cedula")
    @ManyToOne(fetch = FetchType.LAZY)
    private Asistente idAsistente;
    @JoinColumn(name = "idOdontologo", referencedColumnName = "Cedula")
    @ManyToOne(fetch = FetchType.LAZY)
    private Odontologo idOdontologo;
    @JoinColumn(name = "idPaciente", referencedColumnName = "Cedula", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Paciente paciente;
    @OneToMany(mappedBy = "idCita", fetch = FetchType.LAZY)
    private Set<DetalleHistoriaClinica> detalleHistoriaClinicaSet;

    public Cita() {
    }

    public Cita(CitaPK citaPK) {
        this.citaPK = citaPK;
    }

    public Cita(int idCita, String idPaciente) {
        this.citaPK = new CitaPK(idCita, idPaciente);
    }

    public CitaPK getCitaPK() {
        return citaPK;
    }

    public void setCitaPK(CitaPK citaPK) {
        this.citaPK = citaPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @XmlTransient
    public Set<Receta> getRecetaSet() {
        return recetaSet;
    }

    public void setRecetaSet(Set<Receta> recetaSet) {
        this.recetaSet = recetaSet;
    }

    @XmlTransient
    public Set<Factura> getFacturaSet() {
        return facturaSet;
    }

    public void setFacturaSet(Set<Factura> facturaSet) {
        this.facturaSet = facturaSet;
    }

    @XmlTransient
    public Set<Factura> getFacturaSet1() {
        return facturaSet1;
    }

    public void setFacturaSet1(Set<Factura> facturaSet1) {
        this.facturaSet1 = facturaSet1;
    }

    public Asistente getIdAsistente() {
        return idAsistente;
    }

    public void setIdAsistente(Asistente idAsistente) {
        this.idAsistente = idAsistente;
    }

    public Odontologo getIdOdontologo() {
        return idOdontologo;
    }

    public void setIdOdontologo(Odontologo idOdontologo) {
        this.idOdontologo = idOdontologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @XmlTransient
    public Set<DetalleHistoriaClinica> getDetalleHistoriaClinicaSet() {
        return detalleHistoriaClinicaSet;
    }

    public void setDetalleHistoriaClinicaSet(Set<DetalleHistoriaClinica> detalleHistoriaClinicaSet) {
        this.detalleHistoriaClinicaSet = detalleHistoriaClinicaSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (citaPK != null ? citaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cita)) {
            return false;
        }
        Cita other = (Cita) object;
        if ((this.citaPK == null && other.citaPK != null) || (this.citaPK != null && !this.citaPK.equals(other.citaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ucuenca.servidorsistemaclinica.Cita[ citaPK=" + citaPK + " ]";
    }
    
}
