/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.xml.ws.WebServiceRef;
import org.primefaces.event.RowEditEvent;
import ws.Receta;
import ws.RecetaWS_Service;

/**
 *
 * @author DELL
 */
@ManagedBean
@SessionScoped
public class mgreceta {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ServidorSistemaClinica/RecetaWS.wsdl")
    private RecetaWS_Service service;

    public List<Receta> getListado() {
        return listado;
    }

    public void setListado(List<Receta> listado) {
        this.listado = listado;
    }

    private String indicaciones;
    private List<Receta> listado;
    public RecetaWS_Service getService() {
        return service;
    }

    public void setService(RecetaWS_Service service) {
        this.service = service;
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdcita() {
        return idcita;
    }

    public void setIdcita(int idcita) {
        this.idcita = idcita;
    }
    private String descripcion;
    private int idcita;
    /**
     * Creates a new instance of mgreceta
     */
    public mgreceta() {
    }
    
    public void crearreceta()
    {                        
        try { // Call Web Service Operation
            ws.RecetaWS port = service.getRecetaWSPort();
            // TODO initialize WS operation arguments here
            ws.Receta receta = new ws.Receta();
            receta.setIdCita(idcita);
            receta.setDescripcion(descripcion);
            receta.setIndicaciones(indicaciones);
            // TODO process result here
            boolean result = port.crearr(receta);
            System.out.println("Result = "+result);
        } catch (Exception ex) {
        // TODO handle custom exceptions here
        }
    }

    public void onEdit(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("Sucursal Editada", ((Receta) event.getObject()).getIdReceta()+"");    
        FacesContext.getCurrentInstance().addMessage(null, msg);
                
        try { // Call Web Service Operation
            ws.RecetaWS port = service.getRecetaWSPort();
            // TODO initialize WS operation arguments here
            ws.Receta receta = (Receta)event.getObject();                       
            // TODO process result here
            boolean result = port.editr(receta);
            System.out.println("Result = "+result);
        } catch (Exception ex) {
        // TODO handle custom exceptions here
        }               
    }
    
    public void Listar(){               
        try { // Call Web Service Operation
            ws.RecetaWS port = service.getRecetaWSPort();
            // TODO initialize WS operation arguments here
            int fi = 0;
            int max = 0;
            try { // Call Web Service Operation                
                max = port.countr();
                System.out.println("Result = "+max);
            } catch (Exception ex) {
            // TODO handle custom exceptions here
            }

            // TODO process result here
            java.util.List<ws.Receta> result = port.findentitier(fi, max);
            listado = result;
            System.out.println("Result = "+result);
        } catch (Exception ex) {
        // TODO handle custom exceptions here
        }        
    }
    
}
