/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucuenca.servidorsistemaclinica.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Marcelo
 */
@Embeddable
public class DetalleFacturaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idDetalle")
    private int idDetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idFactura")
    private int idFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idServicioOdontologico")
    private int idServicioOdontologico;

    public DetalleFacturaPK() {
    }

    public DetalleFacturaPK(int idDetalle, int idFactura, int idServicioOdontologico) {
        this.idDetalle = idDetalle;
        this.idFactura = idFactura;
        this.idServicioOdontologico = idServicioOdontologico;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdServicioOdontologico() {
        return idServicioOdontologico;
    }

    public void setIdServicioOdontologico(int idServicioOdontologico) {
        this.idServicioOdontologico = idServicioOdontologico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idDetalle;
        hash += (int) idFactura;
        hash += (int) idServicioOdontologico;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFacturaPK)) {
            return false;
        }
        DetalleFacturaPK other = (DetalleFacturaPK) object;
        if (this.idDetalle != other.idDetalle) {
            return false;
        }
        if (this.idFactura != other.idFactura) {
            return false;
        }
        if (this.idServicioOdontologico != other.idServicioOdontologico) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ucuenca.servidorsistemaclinica.DetalleFacturaPK[ idDetalle=" + idDetalle + ", idFactura=" + idFactura + ", idServicioOdontologico=" + idServicioOdontologico + " ]";
    }
    
}
