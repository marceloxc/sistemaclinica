/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.servidorsistemaclinica.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcelo
 */
@Entity
@Table(name = "servicioodontologico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicioodontologico.findAll", query = "SELECT s FROM Servicioodontologico s"),
    @NamedQuery(name = "Servicioodontologico.findByCodigo", query = "SELECT s FROM Servicioodontologico s WHERE s.codigo = :codigo"),
    @NamedQuery(name = "Servicioodontologico.findByDescripcion", query = "SELECT s FROM Servicioodontologico s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "Servicioodontologico.findByPrecio", query = "SELECT s FROM Servicioodontologico s WHERE s.precio = :precio"),
    @NamedQuery(name = "Servicioodontologico.findByIva", query = "SELECT s FROM Servicioodontologico s WHERE s.iva = :iva")})
public class Servicioodontologico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Codigo")
    private Integer codigo;
    @Size(max = 45)
    @Column(name = "Descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Precio")
    private Double precio;
    @Column(name = "IVA")
    private Character iva;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idServicioOdontologico", fetch = FetchType.LAZY)
    private Set<Detallefactura> detallefacturaSet;

    public Servicioodontologico() {
    }

    public Servicioodontologico(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Character getIva() {
        return iva;
    }

    public void setIva(Character iva) {
        this.iva = iva;
    }

    @XmlTransient
    public Set<Detallefactura> getDetallefacturaSet() {
        return detallefacturaSet;
    }

    public void setDetallefacturaSet(Set<Detallefactura> detallefacturaSet) {
        this.detallefacturaSet = detallefacturaSet;
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
        if (!(object instanceof Servicioodontologico)) {
            return false;
        }
        Servicioodontologico other = (Servicioodontologico) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ucuenca.servidorsistemaclinica.entity.Servicioodontologico[ codigo=" + codigo + " ]";
    }
    
}
