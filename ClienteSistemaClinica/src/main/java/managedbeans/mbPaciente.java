/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.xml.ws.WebServiceRef;
import org.primefaces.event.RowEditEvent;
import util.CPaciente;
import util.validaciones;
import ws.PacienteWS_Service;
import ws.Persona;
import ws.PersonaWS_Service;

/**
 *
 * @author johnny
 */
@ManagedBean
@SessionScoped
public class mbPaciente {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ServidorSistemaClinica/PacienteWS.wsdl")
    private PacienteWS_Service service_1;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ServidorSistemaClinica/PersonaWS.wsdl")
    private PersonaWS_Service service;

    /**
     * Creates a new instance of mbPaciente
     */
        private List <Persona> listaPersonas;

    /**
     * Get the value of listaPersonas
     *
     * @return the value of listaPersonas
     */
    public List <Persona> getListaPersonas() {
        return listaPersonas;
    }

    /**
     * Set the value of listaPersonas
     *
     * @param listaPersonas new value of listaPersonas
     */
    public void setListaPersonas(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }
        private String pruebaCedula;

    /**
     * Get the value of pruebaCedula
     *
     * @return the value of pruebaCedula
     */
    public String getPruebaCedula() {
        return pruebaCedula;
    }

    /**
     * Set the value of pruebaCedula
     *
     * @param pruebaCedula new value of pruebaCedula
     */
    public void setPruebaCedula(String pruebaCedula) {
        this.pruebaCedula = pruebaCedula;
    }

    public mbPaciente() {
        

    }
        private List<CPaciente> listaPacientes;

    /**
     * Get the value of listaPacientes
     *
     * @return the value of listaPacientes
     */
    public List<CPaciente> getListaPacientes() {
        return listaPacientes;
    }

    /**
     * Set the value of listaPacientes
     *
     * @param listaPacientes new value of listaPacientes
     */
    public void setListaPacientes(List<CPaciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    public void cargarDatos()
    {
        try { // Call Web Service Operation
            ws.PersonaWS port = service.getPersonaWSPort();
            // TODO initialize WS operation arguments here
            int fi = 0;
            int max = 10;
            // TODO process result here
            java.util.List<ws.Persona> result = port.findentitiesp(fi, max);
            
            System.out.println("Result = "+result);
            listaPersonas=result;
            
            pruebaCedula=listaPersonas.get(0).getCedula();
        } catch (Exception ex) {
        // TODO handle custom exceptions here
            
        }
        
        try { // Call Web Service Operation
            ws.PacienteWS port = service_1.getPacienteWSPort();
            // TODO initialize WS operation arguments here
            int fi = 0;
            int max = 10;
            // TODO process result here
            java.util.List<ws.Paciente> result = port.findentitiespa(fi, max);
            listaPacientes=new ArrayList();
            for(int i=0; i<result.size();i++)
            {
                for(int j=0; j<listaPersonas.size();j++)
                {
                    if(result.get(i).getCedula().equals(listaPersonas.get(j).getCedula()))
                    {
                        CPaciente pas = new CPaciente(listaPersonas.get(j).getApellidos(),listaPersonas.get(j).getCedula(),listaPersonas.get(j).getContraseña(), listaPersonas.get(j).getDireccion(), listaPersonas.get(j).getEmail(),listaPersonas.get(j).getFechaNacimiento(),listaPersonas.get(j).getNombres(), listaPersonas.get(j).getRol(), listaPersonas.get(j).getSexo(), listaPersonas.get(j).getTelefono(),listaPersonas.get(j).getTelfCelular(), result.get(j).getOcupacion());
                        listaPacientes.add(pas);
                    }
                }
            }
            System.out.println("Result = "+result);
        } catch (Exception ex) {
        // TODO handle custom exceptions here
        }

        
    }
        private CPaciente selectedPaciente;

    /**
     * Get the value of selectedPaciente
     *
     * @return the value of selectedPaciente
     */
    public CPaciente getSelectedPaciente() {
        return selectedPaciente;
    }

    /**
     * Set the value of selectedPaciente
     *
     * @param selectedPaciente new value of selectedPaciente
     */
    public void setSelectedPaciente(CPaciente selectedPaciente) {
        this.selectedPaciente = selectedPaciente;
    }

    private Persona selectedPersona;

    /**
     * Get the value of selectedPersona
     *
     * @return the value of selectedPersona
     */
    public Persona getSelectedPersona() {
        return selectedPersona;
    }

    /**
     * Set the value of selectedPersona
     *
     * @param selectedPersona new value of selectedPersona
     */
    public void setSelectedPersona(Persona selectedPersona) {
        this.selectedPersona = selectedPersona;
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
    private String estado;

    /**
     * Get the value of estado
     *
     * @return the value of estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Set the value of estado
     *
     * @param estado new value of estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String guardar() {
        boolean band=true;
        try { // Call Web Service Operation
            ws.PersonaWS port = service.getPersonaWSPort();
            // TODO initialize WS operation arguments here
            ws.Persona persona = new ws.Persona();
            persona.setCedula(cedula);
            persona.setNombres(nombres);
            persona.setApellidos(apellidos);
            persona.setDireccion(direccion);
            persona.setTelefono(telefono);
            persona.setTelfCelular(telfCelular);
            persona.setEmail(email);
            persona.setSexo(sexo);
            persona.setFechaNacimiento(null);
            validaciones val=new validaciones();
            persona.setContraseña(val.encripta(password));
            persona.setRol(1);
            // TODO process result here
            boolean result = port.crearp(persona);
            if(!result)
                band=false;
            
        } catch (Exception ex) {
            estado="No se pudo guardar";
            return null;
        // TODO handle custom exceptions here
        }
        
        try { // Call Web Service Operation
            ws.PacienteWS port = service_1.getPacienteWSPort();
            // TODO initialize WS operation arguments here
            ws.Paciente paciente = new ws.Paciente();
            // TODO process result here
            paciente.setCedula(cedula);
            paciente.setOcupacion(ocupacion);
            boolean result = port.crearpa(paciente);
            if(!result)
                band=false;
            System.out.println("Result = "+result);
        } catch (Exception ex) {
        // TODO handle custom exceptions here
            estado="No se pudo guardar";
            return null;
        }
        if(band)
        {
            estado="Guardado Correctamente";
            return "index";
        }
        else{
            estado="No se pudo guardar";
            return null;
        } 
    }

    /**
     *
     * @param event
     */
    public void onEdit(RowEditEvent event) {  
     
     try { // Call Web Service Operation
         ws.PersonaWS port = service.getPersonaWSPort();
         // TODO initialize WS operation arguments here
         CPaciente paciente = (CPaciente)event.getObject();
         ws.Persona persona = new ws.Persona();
         persona.setCedula(paciente.getCedula());
         persona.setNombres(paciente.getNombres());
         persona.setApellidos(paciente.getApellidos());
         persona.setDireccion(paciente.getDireccion());
         persona.setTelefono(paciente.getTelefono());
         persona.setTelfCelular(paciente.getTelfCelular());
         persona.setSexo(paciente.getSexo());
         persona.setContraseña(paciente.getContraseña());
         persona.setEmail(paciente.getEmail());
         persona.setRol(paciente.getRol());
         // TODO process result here
         
         boolean result = port.editp(persona);
         System.out.println("Result = "+result);
     } catch (Exception ex) {
     // TODO handle custom exceptions here
     }
 
 }   
}