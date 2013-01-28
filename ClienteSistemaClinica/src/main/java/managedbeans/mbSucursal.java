
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;


import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.xml.ws.WebServiceRef;
import org.primefaces.event.RowEditEvent;
import ws.Sucursal;
import ws.SucursalWS_Service;

/**
 *
 * @author Valex
 */
@ManagedBean
@SessionScoped
public final class mbSucursal implements Serializable{
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ServidorSistemaClinica/SucursalWS.wsdl")
    private SucursalWS_Service service;
    private int dato;
    private String nombre;
    private String direccion;
    private List<Sucursal> listado;

    public List<Sucursal> getListado() {
        return listado;
    }

    public void setListado(List<Sucursal> listado) {
        this.listado = listado;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        //Listar();
    }
    
    public String crear() {
        
        try { // Call Web Service Operation
            ws.SucursalWS port = service.getSucursalWSPort();
            // TODO initialize WS operation arguments here
            ws.Sucursal sucursal = new ws.Sucursal();
            //sucursal.setNumSucursal(dato);
            sucursal.setDireccion(direccion);
            sucursal.setTelefono(nombre);
      //      sucursal.setTelefono('0999855');
            // TODO process result here
            boolean result = port.crears(sucursal);
            System.out.println("Result = "+result);
            return "index";
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
            nombre=result.getTelefono();
            System.out.println("Result = "+result);
        } catch (Exception ex) {
        // TODO handle custom exceptions here
        }

        
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void onEdit(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("Sucursal Editada", ((Sucursal) event.getObject()).getNumSucursal()+"");    
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
        try { // Call Web Service Operation
            ws.SucursalWS port = service.getSucursalWSPort();
            // TODO initialize WS operation arguments here
            ws.Sucursal sucursal = (Sucursal)event.getObject();
            // TODO process result here
            direccion = sucursal.getDireccion();
            nombre =sucursal.getTelefono();
            boolean result = port.edits(sucursal);
            System.out.println("Result = "+result);
        } catch (Exception ex) {
        // TODO handle custom exceptions here
        }

        
        
    }  
    
    public void onCancel(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("Car Cancelled", ((Sucursal) event.getObject()).toString());  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
    
    public void Listar(){
        
        try { // Call Web Service Operation
           int fi = 0;
            int max = 2;
            ws.SucursalWS port = service.getSucursalWSPort();
            // TODO initialize WS operation arguments here
            
            // TODO process result here
            java.util.List<ws.Sucursal> result = port.findentitiess(fi, max);
            listado = result;
            System.out.println("Result = "+result);
        } catch (Exception ex) {
        // TODO handle custom exceptions here
        }

    }
}

