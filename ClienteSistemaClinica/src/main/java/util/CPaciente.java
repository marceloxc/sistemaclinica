/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author johnny
 */
public class CPaciente {

    public CPaciente(String apellidos, String cedula, String contraseña, String direccion, String email, XMLGregorianCalendar fechaNacimiento, String nombres, Integer rol, Integer sexo, String telefono, String telfCelular, String ocupacion) {
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.contraseña = contraseña;
        this.direccion = direccion;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.nombres = nombres;
        this.rol = rol;
        this.sexo = sexo;
        this.telefono = telefono;
        this.telfCelular = telfCelular;
        this.ocupacion = ocupacion;
    }
     protected String apellidos;
    protected String cedula;
    protected String contraseña;
    protected String direccion;
    protected String email;
    protected XMLGregorianCalendar fechaNacimiento;
    protected String nombres;
    protected Integer rol;
    protected Integer sexo;
    protected String telefono;
    protected String telfCelular;
    protected String ocupacion;

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public XMLGregorianCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(XMLGregorianCalendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Integer getRol() {
        return rol;
    }

    public void setRol(Integer rol) {
        this.rol = rol;
    }

    public Integer getSexo() {
        return sexo;
    }

    public void setSexo(Integer sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelfCelular() {
        return telfCelular;
    }

    public void setTelfCelular(String telfCelular) {
        this.telfCelular = telfCelular;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    
    
}
