/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Fernanda
 */
@ManagedBean
@SessionScoped
public class mbDetalleCartera {

    /**
     * Creates a new instance of mbDetalleCartera
     */
    String fecha;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getAbono() {
        return abono;
    }

    public void setAbono(double abono) {
        this.abono = abono;
    }

    public int getIdCartera() {
        return idCartera;
    }

    public void setIdCartera(int idCartera) {
        this.idCartera = idCartera;
    }
    double abono;
    int idCartera;
    
    public mbDetalleCartera() {
        java.util.Date fecha2 = new Date();;
        fecha=fecha2.getDate()+"/"+(Integer.parseInt(fecha2.getMonth()+"")+1)+"/"+(Integer.parseInt(fecha2.getYear()+"")+1900);
        

    }
    
    
    
    
}
