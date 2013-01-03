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
import org.hibernate.envers.Audited;

/**
 *
 * @author Marcelo
 */
@Entity
@Audited 
@Table(name = "servicioodontologico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServicioOdontologico.findAll", query = "SELECT s FROM ServicioOdontologico s"),
    @NamedQuery(name = "ServicioOdontologico.findByCodigo", query = "SELECT s FROM ServicioOdontologico s WHERE s.codigo = :codigo"),
    @NamedQuery(name = "ServicioOdontologico.findByDescripcion", query = "SELECT s FROM ServicioOdontologico s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "ServicioOdontologico.findByPrecio", query = "SELECT s FROM ServicioOdontologico s WHERE s.precio = :precio"),
    @NamedQuery(name = "ServicioOdontologico.findByIva", query = "SELECT s FROM ServicioOdontologico s WHERE s.iva = :iva")})
public class ServicioOdontologico implements Serializable {
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicioOdontologico", fetch = FetchType.LAZY)
    private Set<DetalleFactura> detalleFacturaSet;

    public ServicioOdontologico() {
    }

    public ServicioOdontologico(Integer codigo) {
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
    public Set<DetalleFactura> getDetalleFacturaSet() {
        return detalleFacturaSet;
    }

    public void setDetalleFacturaSet(Set<DetalleFactura> detalleFacturaSet) {
        this.detalleFacturaSet = detalleFacturaSet;
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
        if (!(object instanceof ServicioOdontologico)) {
            return false;
        }
        ServicioOdontologico other = (ServicioOdontologico) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ucuenca.servidorsistemaclinica.ServicioOdontologico[ codigo=" + codigo + " ]";
    }
    
}