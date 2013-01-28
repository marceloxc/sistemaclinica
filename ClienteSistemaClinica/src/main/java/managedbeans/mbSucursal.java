/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.ws.WebServiceRef;
import org.primefaces.model.LazyDataModel;
import ws.Sucursal;
import ws.SucursalWS_Service;

/**
 *
 * @author Valex
 */
@ManagedBean
@SessionScoped
public class mbSucursal implements Serializable{
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ServidorSistemaClinica/SucursalWS.wsdl")
    private SucursalWS_Service service;
    private int dato;
    private String direccion;
    private String telefono;
    private LazyDataModel<Sucursal> lazySucursal;  
    private Sucursal selectSucursal; 

    public LazyDataModel<Sucursal> getLazySucursal() {
        return lazySucursal;
    }

    public void setLazySucursal(LazyDataModel<Sucursal> lazySucursal) {
        this.lazySucursal = lazySucursal;
    }

    public Sucursal getSelectSucursal() {
        return selectSucursal;
    }

    public void setSelectSucursal(Sucursal selectSucursal) {
        this.selectSucursal = selectSucursal;
    }

    
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

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }
    
    
    /**
     * Creates a new instance of mbSucursal
     */
    public mbSucursal() {
    }
    
    public String crear() {
        
        try { // Call Web Service Operation
            ws.SucursalWS port = service.getSucursalWSPort();
            // TODO initialize WS operation arguments here
            ws.Sucursal sucursal = new ws.Sucursal();
            sucursal.setDireccion(direccion);
            sucursal.setTelefono(telefono);
      //      sucursal.setTelefono('0999855');
            // TODO process result here
            boolean result = port.crears(sucursal);
            System.out.println("Result = "+result);       
        } catch (Exception ex) {
        // TODO handle custom exceptions here
        }

        return "";
    }
    
    public void find(){
        
        try { // Call Web Service Operation
            ws.SucursalWS port = service.getSucursalWSPort();
            // TODO initialize WS operation arguments here
            int id = dato;
            // TODO process result her
            ws.Sucursal result = port.finds(id);
            direccion=result.getDireccion();
            System.out.println("Result = "+result);
        } catch (Exception ex) {
        // TODO handle custom exceptions here
        }

        
    }
}
