/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.servidorsistemaclinica.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Valex
 */
@Entity
@Table(name = "cita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cita.findAll", query = "SELECT c FROM Cita c"),
    @NamedQuery(name = "Cita.findByIdCita", query = "SELECT c FROM Cita c WHERE c.idCita = :idCita"),
    @NamedQuery(name = "Cita.findByFecha", query = "SELECT c FROM Cita c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Cita.findByMotivo", query = "SELECT c FROM Cita c WHERE c.motivo = :motivo")})
public class Cita implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCita")
    private Integer idCita;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 45)
    @Column(name = "motivo")
    private String motivo;
    @OneToMany(mappedBy = "idCita", fetch = FetchType.EAGER)
    private List<Receta> recetaList;
    @OneToMany(mappedBy = "idPaciente", fetch = FetchType.EAGER)
    private List<Factura> facturaList;
    @OneToMany(mappedBy = "idCita", fetch = FetchType.EAGER)
    private List<Factura> facturaList1;
    @JoinColumn(name = "idPaciente", referencedColumnName = "Cedula")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Paciente idPaciente;
    @JoinColumn(name = "idOdontologo", referencedColumnName = "Cedula")
    @ManyToOne(fetch = FetchType.EAGER)
    private Odontologo idOdontologo;
    @JoinColumn(name = "idAsistente", referencedColumnName = "Cedula")
    @ManyToOne(fetch = FetchType.EAGER)
    private Asistente idAsistente;
    @OneToMany(mappedBy = "idCita", fetch = FetchType.EAGER)
    private List<Detallehistoriaclinica> detallehistoriaclinicaList;

    public Cita() {
    }

    public Cita(Integer idCita) {
        this.idCita = idCita;
    }

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
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
    public List<Receta> getRecetaList() {
        return recetaList;
    }

    public void setRecetaList(List<Receta> recetaList) {
        this.recetaList = recetaList;
    }

    @XmlTransient
    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    @XmlTransient
    public List<Factura> getFacturaList1() {
        return facturaList1;
    }

    public void setFacturaList1(List<Factura> facturaList1) {
        this.facturaList1 = facturaList1;
    }

    public Paciente getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Paciente idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Odontologo getIdOdontologo() {
        return idOdontologo;
    }

    public void setIdOdontologo(Odontologo idOdontologo) {
        this.idOdontologo = idOdontologo;
    }

    public Asistente getIdAsistente() {
        return idAsistente;
    }

    public void setIdAsistente(Asistente idAsistente) {
        this.idAsistente = idAsistente;
    }

    @XmlTransient
    public List<Detallehistoriaclinica> getDetallehistoriaclinicaList() {
        return detallehistoriaclinicaList;
    }

    public void setDetallehistoriaclinicaList(List<Detallehistoriaclinica> detallehistoriaclinicaList) {
        this.detallehistoriaclinicaList = detallehistoriaclinicaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCita != null ? idCita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cita)) {
            return false;
        }
        Cita other = (Cita) object;
        if ((this.idCita == null && other.idCita != null) || (this.idCita != null && !this.idCita.equals(other.idCita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ucuenca.servidorsistemaclinica.entity.Cita[ idCita=" + idCita + " ]";
    }
    
}
