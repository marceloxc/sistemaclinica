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
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.ws.WebServiceRef;
import ws.CarteraWS_Service;
import ws.Factura;
import ws.FacturaWS_Service;

/**
 *
 * @author Fernanda
 */
@ManagedBean
@SessionScoped
public class mbCartera {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ServidorSistemaClinica/CarteraWS.wsdl")
    private CarteraWS_Service service_1;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ServidorSistemaClinica/FacturaWS.wsdl")
    private FacturaWS_Service service;
    
    String descripcion;
    Date fecha;
    String ffecha;
    double totalDeuda;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFfecha() {
        return ffecha;
    }

    public void setFfecha(String ffecha) {
        this.ffecha = ffecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotalDeuda() {
        return totalDeuda;
    }

    public void setTotalDeuda(double totalDeuda) {
        this.totalDeuda = totalDeuda;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }
    int idFactura;
    

    /**
     * Creates a new instance of mbCartera
     */
    public mbCartera() {
        descripcion="";
    }
    
    public String cargarFactura(){
        try { // Call Web Service Operation
            ws.FacturaWS port = service.getFacturaWSPort();
            // TODO initialize WS operation arguments here
            int id = idFactura;
            // TODO process result here
            ws.Factura result = port.findf(id);
            System.out.println("Result = "+result);
            fecha= result.getFecha().toGregorianCalendar().getTime();
            SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
            ffecha=formatoDeFecha.format(fecha);
            totalDeuda=result.getTotal();
            return "";
            
        } catch (Exception ex) {
        // TODO handle custom exceptions here
            return "";
        }
    }

    public String crearCartera() throws DatatypeConfigurationException
    {
        //XMLGregorianCalendar xgc=DatatypeFactory.newInstance().newXMLGregorianCalendar(ffecha);
        try { // Call Web Service Operation
            ws.CarteraWS port = service_1.getCarteraWSPort();
            // TODO initialize WS operation arguments here
            ws.Cartera cartera = new ws.Cartera();
            // TODO process result here
            Factura f= new Factura();
            f.setNumFactura(idFactura);
            cartera.setIdFactura(f);
            cartera.setFecha(null);
            cartera.setDescripcion("");
            cartera.setTotalDeuda(totalDeuda);
            
            
            boolean result = port.crearc(cartera);
            System.out.println("Result = "+result);
            return "";
        } catch (Exception ex) {
        // TODO handle custom exceptions here
            return "";
        }

    }
}
