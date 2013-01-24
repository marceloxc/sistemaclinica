/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.ws.WebServiceRef;
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
            sucursal.setNumSucursal(dato);
            sucursal.setDireccion("dir");
      //      sucursal.setTelefono('0999855');
            // TODO process result here
            boolean result = port.crears(sucursal);
            System.out.println("Result = "+result);
        } catch (Exception ex) {
        // TODO handle custom exceptions here
        }

        return "";
    }
}
