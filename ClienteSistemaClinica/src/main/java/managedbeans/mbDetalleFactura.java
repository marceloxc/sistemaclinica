/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.xml.ws.WebServiceRef;
import util.Detalle;
import ws.SucursalWS_Service;

/**
 *
 * @author karina
 */
@ManagedBean(name="mbDetalleFactura")
@SessionScoped
public class mbDetalleFactura implements Serializable{
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ServidorSistemaClinica/SucursalWS.wsdl")
    private SucursalWS_Service service;
    
    private List<Detalle> detalle;
    private String[] serv;
    private List<SelectItem> lsel;
    /**
     * Creates a new instance of DetalleFactura
     */
    
    
    public String redirDetalle(){
        lsel = new ArrayList<SelectItem>();
        obtenerServicio();
        return "IngresoFactura";
    }
    public mbDetalleFactura() {
        detalle = new ArrayList<Detalle>();
        serv= new String[1];
        serv[0]="Seleccionar";
        lsel=new ArrayList<SelectItem>();
    }
     public void agregarDetalle(List<Detalle> det, int cant, String detalle, double punit)
     {
         det.add(new Detalle(cant,detalle,punit, cant*punit));
     }

    public List<Detalle> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<Detalle> detalle) {
        this.detalle = detalle;
    }

    public String[] getServ() {
        return serv;
    }

    public void setServ(String[] serv) {
        this.serv = serv;
    }
    public static mbDetalleFactura getInstance()
    {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ELContext context = facesContext.getELContext();
        ValueExpression ex = facesContext.getApplication().getExpressionFactory().createValueExpression(context, "#{mbDetalleFactura}",mbDetalleFactura.class);
        return (mbDetalleFactura)ex.getValue(context);
    }
     
    public String obtenerServicio()
    {
        
        try { // Call Web Service Operation
            ws.SucursalWS port = service.getSucursalWSPort();
            // TODO initialize WS operation arguments here
            int fi = 0;
            int max = 10;
            // TODO process result here
            java.util.List<ws.Sucursal> result = port.findentitiess(fi, max);
            System.out.println("Result = "+result);
            serv=new String[result.size()];
            for(ws.Sucursal var:result)
            {
                SelectItem si = new SelectItem(var.getNumSucursal(), var.getDireccion());
                lsel.add(si);
            }
        } catch (Exception ex){
            ex.printStackTrace();
            System.out.print(ex.getMessage());
        // TODO handle custom exceptions here
        }
        
        return "";
    }

    public List<SelectItem> getLsel() {
        return lsel;
    }

    public void setLsel(List<SelectItem> lsel) {
        this.lsel = lsel;
    }
}
