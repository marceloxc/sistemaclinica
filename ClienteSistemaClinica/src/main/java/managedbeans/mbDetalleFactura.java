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
import ws.ServicioOdontologicoWS_Service;
import ws.SucursalWS_Service;

/**
 *
 * @author karina
 */
@ManagedBean(name="mbDetalleFactura")
@SessionScoped
public class mbDetalleFactura implements Serializable{
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ServidorSistemaClinica/ServicioOdontologicoWS.wsdl")
    private ServicioOdontologicoWS_Service service_1;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ServidorSistemaClinica/SucursalWS.wsdl")
    private SucursalWS_Service service;
        private int cant=1;

    /**
     * Get the value of cant
     *
     * @return the value of cant
     */
    public int getCant() {
        return cant;
    }

    /**
     * Set the value of cant
     *
     * @param cant new value of cant
     */
    public void setCant(int cant) {
        this.cant = cant;
    }
    private String descrip;

    /**
     * Get the value of descrip
     *
     * @return the value of descrip
     */
    public String getDescrip() {
        return descrip;
    }

    /**
     * Set the value of descrip
     *
     * @param descrip new value of descrip
     */
    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    private double punit;

    /**
     * Get the value of punit
     *
     * @return the value of punit
     */
    public double getPunit() {
        return punit;
    }

    /**
     * Set the value of punit
     *
     * @param punit new value of punit
     */
    public void setPunit(double punit) {
        this.punit = punit;
    }
    private double ptot;

    /**
     * Get the value of ptot
     *
     * @return the value of ptot
     */
    public double getPtot() {
        return ptot;
    }

    /**
     * Set the value of ptot
     *
     * @param ptot new value of ptot
     */
    public void setPtot(double ptot) {
        this.ptot = ptot;
    }
    private Integer sucursalSel = null;
    
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
        obtenerServicio();
    }
     public void agregarDetalle()
     {

         try { // Call Web Service Operation
             ws.ServicioOdontologicoWS port = service_1.getServicioOdontologicoWSPort();
             // TODO initialize WS operation arguments here
             int id = sucursalSel;
             // TODO process result here
             ws.ServicioOdontologico result = port.findso(id);
             this.detalle.add(new Detalle(cant,result.getDescripcion(),result.getPrecio(), cant*result.getPrecio()));
             System.out.println("Result = "+result);
         } catch (Exception ex) {
         // TODO handle custom exceptions here
         }

         
         
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
            ws.ServicioOdontologicoWS port = service_1.getServicioOdontologicoWSPort();
            // TODO initialize WS operation arguments here
            int fi = 0;
            int max = 10;
            // TODO process result here
            java.util.List<ws.ServicioOdontologico> result = port.findentitieso(fi, max);
            System.out.println("Result = "+result);
            serv=new String[result.size()];
            for(ws.ServicioOdontologico var:result)
            {
                SelectItem si = new SelectItem(var.getCodigo(), var.getDescripcion());
                lsel.add(si);
            }
        } catch (Exception ex) {
        // TODO handle custom exceptions here
        }
            // TODO process result here
        
        return "";
    }

    public List<SelectItem> getLsel() {
        return lsel;
    }

    public void setLsel(List<SelectItem> lsel) {
        this.lsel = lsel;
    }

    public Integer getSucursalSel() {
        return sucursalSel;
    }

    public void setSucursalSel(Integer sucursalSel) {
        this.sucursalSel = sucursalSel;
    }
    
    public String agregarSucursal() {
        Integer s = this.sucursalSel;
        System.out.println("Sel: " + s);
        return "";
    }
}
