/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.ws.WebServiceRef;
import ws.PacienteWS_Service;
import ws.PersonaWS_Service;

/**
 *
 * @author Fernanda
 */
@ManagedBean
@RequestScoped
public class mbFactura {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ServidorSistemaClinica/PersonaWS.wsdl")
    private PersonaWS_Service service_1;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ServidorSistemaClinica/PacienteWS.wsdl")
    private PacienteWS_Service service;
    
    private String cliente;
    private int numFactura;
    private String ruc;
    private String nombre;
    private String direccion;
    private String fecha;    
    private String num1;
    private String num2;
    
    
    private double total;

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public String cargarDatos()
    {
        
        try { // Call Web Service Operation
            ws.PersonaWS port = service_1.getPersonaWSPort();
            // TODO initialize WS operation arguments here
            java.lang.String id = ruc;
            // TODO process result here
            ws.Persona result = port.findp(id);
            nombre=result.getNombres()+" "+result.getApellidos();
            //apellido=result.getApellidos();
            direccion=result.getDireccion();
            //telefono=result.getTelefono();
            //telfCelular=result.getTelfCelular();
            //email=result.getEmail();
            //sexo=result.getSexo();
            //fechaNacimiento= result.getFechaNacimiento().toGregorianCalendar().getTime();
            SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
            //formatfechaNacimiento=formatoDeFecha.format(fechaNacimiento);
            return "";
        } catch (Exception ex) {
        // TODO handle custom exceptions here
            return "";
        }
    }
    public String calcularTotal() {  
        total=Double.parseDouble(num1)+Double.parseDouble(num2);
       System.out.println("holaaaaaaaaaaaaaaaaa.......");
       return "";
    }
    
    public String Guardar() {  
        
       return "";
    }
    
    public String crearCartera() {  
       
        
       return "";
    }
    
    /**
     * Creates a new instance of mbFactura2
     */
    public mbFactura() {
        java.util.Date fecha2 = new Date();
          System.out.println("Saxcvxcvme text in cddddonsole");
        fecha=fecha2.getDate()+"-"+(Integer.parseInt(fecha2.getMonth()+"")+1)+"-"+(Integer.parseInt(fecha2.getYear()+"")+1900);

    }
}
