/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.util.Date;
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
    private String nombres;

    /**
     * Get the value of nombres
     *
     * @return the value of nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Set the value of nombres
     *
     * @param nombres new value of nombres
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
        private String apellidos;

    /**
     * Get the value of apellidos
     *
     * @return the value of apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Set the value of apellidos
     *
     * @param apellidos new value of apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
        private String direccion;

    /**
     * Get the value of direccion
     *
     * @return the value of direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Set the value of direccion
     *
     * @param direccion new value of direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
        private String telefono;

    /**
     * Get the value of telefono
     *
     * @return the value of telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Set the value of telefono
     *
     * @param telefono new value of telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
        private String telfCelular;

    /**
     * Get the value of telfCelular
     *
     * @return the value of telfCelular
     */
    public String getTelfCelular() {
        return telfCelular;
    }

    /**
     * Set the value of telfCelular
     *
     * @param telfCelular new value of telfCelular
     */
    public void setTelfCelular(String telfCelular) {
        this.telfCelular = telfCelular;
    }
        private String email;

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }
        private int sexo;

    /**
     * Get the value of sexo
     *
     * @return the value of sexo
     */
    public int getSexo() {
        return sexo;
    }

    /**
     * Set the value of sexo
     *
     * @param sexo new value of sexo
     */
    public void setSexo(int sexo) {
        this.sexo = sexo;
    }
        private Date fechaNacimiento;

    /**
     * Get the value of fechaNacimiento
     *
     * @return the value of fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Set the value of fechaNacimiento
     *
     * @param fechaNacimiento new value of fechaNacimiento
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
        private String strFecha;

    /**
     * Get the value of strFecha
     *
     * @return the value of strFecha
     */
    public String getStrFecha() {
        return strFecha;
    }

    /**
     * Set the value of strFecha
     *
     * @param strFecha new value of strFecha
     */
    public void setStrFecha(String strFecha) {
        this.strFecha = strFecha;
    }
        private String password;

    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }
        private String rol;

    /**
     * Get the value of rol
     *
     * @return the value of rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * Set the value of rol
     *
     * @param rol new value of rol
     */
    public void setRol(String rol) {
        this.rol = rol;
    }
        private String ocupacion;

    /**
     * Get the value of ocupacion
     *
     * @return the value of ocupacion
     */
    public String getOcupacion() {
        return ocupacion;
    }

    /**
     * Set the value of ocupacion
     *
     * @param ocupacion new value of ocupacion
     */
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public void guardar() {
        
    }
    
}
