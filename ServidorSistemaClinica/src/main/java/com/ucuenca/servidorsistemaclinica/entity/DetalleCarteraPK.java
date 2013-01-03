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
public class DetalleCarteraPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idDetalleCartera")
    private int idDetalleCartera;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCartera")
    private int idCartera;

    public DetalleCarteraPK() {
    }

    public DetalleCarteraPK(int idDetalleCartera, int idCartera) {
        this.idDetalleCartera = idDetalleCartera;
        this.idCartera = idCartera;
    }

    public int getIdDetalleCartera() {
        return idDetalleCartera;
    }

    public void setIdDetalleCartera(int idDetalleCartera) {
        this.idDetalleCartera = idDetalleCartera;
    }

    public int getIdCartera() {
        return idCartera;
    }

    public void setIdCartera(int idCartera) {
        this.idCartera = idCartera;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idDetalleCartera;
        hash += (int) idCartera;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCarteraPK)) {
            return false;
        }
        DetalleCarteraPK other = (DetalleCarteraPK) object;
        if (this.idDetalleCartera != other.idDetalleCartera) {
            return false;
        }
        if (this.idCartera != other.idCartera) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ucuenca.servidorsistemaclinica.DetalleCarteraPK[ idDetalleCartera=" + idDetalleCartera + ", idCartera=" + idCartera + " ]";
    }
    
}
