/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.xml.ws.WebServiceRef;
import ws.PacienteWS_Service;
import ws.PersonaWS_Service;

/**
 *
 * @author Fernanda
 */
@ManagedBean
@SessionScoped
public class mbPersona {

    /**
     * Creates a new instance of mbPersona
     */
    public mbPersona() {
    }
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ServidorSistemaClinica/PersonaWS.wsdl")
    private PersonaWS_Service service_1;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ServidorSistemaClinica/PacienteWS.wsdl")
    private PacienteWS_Service service;
    
    private String cedula;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String telfCelular;

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    
    private String email;
    private int sexo;
    private Date fechaNacimiento;
    private String formatfechaNacimiento;

    public String getFormatfechaNacimiento() {
        return formatfechaNacimiento;
    }

    public void setFormatfechaNacimiento(String formatfechaNacimiento) {
        this.formatfechaNacimiento = formatfechaNacimiento;
    }

    public String getNombres() {
        return nombres;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    

    

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    
    public String cargarDatos()
    {
        
        try { // Call Web Service Operation
            ws.PersonaWS port = service_1.getPersonaWSPort();
            // TODO initialize WS operation arguments here
            java.lang.String id = cedula;
            // TODO process result here
            ws.Persona result = port.findp(id);
            nombres=result.getNombres();
            apellidos=result.getApellidos();
            direccion=result.getDireccion();
            telefono=result.getTelefono();
            telfCelular=result.getTelfCelular();
            email=result.getEmail();
            sexo=result.getSexo();
            fechaNacimiento= result.getFechaNacimiento().toGregorianCalendar().getTime();
            SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatfechaNacimiento=formatoDeFecha.format(fechaNacimiento);
            return "";
        } catch (Exception ex) {
        // TODO handle custom exceptions here
            return "";
        }

       
  
    }

}
