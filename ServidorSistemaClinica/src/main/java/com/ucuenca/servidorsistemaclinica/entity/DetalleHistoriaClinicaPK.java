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
public class DetalleHistoriaClinicaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Codigo")
    private int codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodigoHistoriaClinica")
    private int codigoHistoriaClinica;

    public DetalleHistoriaClinicaPK() {
    }

    public DetalleHistoriaClinicaPK(int codigo, int codigoHistoriaClinica) {
        this.codigo = codigo;
        this.codigoHistoriaClinica = codigoHistoriaClinica;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigoHistoriaClinica() {
        return codigoHistoriaClinica;
    }

    public void setCodigoHistoriaClinica(int codigoHistoriaClinica) {
        this.codigoHistoriaClinica = codigoHistoriaClinica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigo;
        hash += (int) codigoHistoriaClinica;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleHistoriaClinicaPK)) {
            return false;
        }
        DetalleHistoriaClinicaPK other = (DetalleHistoriaClinicaPK) object;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.codigoHistoriaClinica != other.codigoHistoriaClinica) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ucuenca.servidorsistemaclinica.DetalleHistoriaClinicaPK[ codigo=" + codigo + ", codigoHistoriaClinica=" + codigoHistoriaClinica + " ]";
    }
    
}
