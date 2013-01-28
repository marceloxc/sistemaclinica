/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author karina
 */
public class Detalle {
    int cantidad;
    String descripcion;
    double pactual;
    double ptotal;

    public Detalle() {
    }

    public Detalle(int cantidad, String descripcion, double pactual, double ptotal) {
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.pactual = pactual;
        this.ptotal = ptotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPactual() {
        return pactual;
    }

    public void setPactual(double pactual) {
        this.pactual = pactual;
    }

    public double getPtotal() {
        return ptotal;
    }

    public void setPtotal(double ptotal) {
        this.ptotal = ptotal;
    }
}
