/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author johnny
 */
@ManagedBean
@RequestScoped
public class mbPaciente {

    /**
     * Creates a new instance of mbPaciente
     */
    public mbPaciente() {
    }
        private String cedula;

    /**
     * Get the value of cedula
     *
     * @return the value of cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Set the value of cedula
     *
     * @param cedula new value of cedula
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public void guardar()
    {
}
}
