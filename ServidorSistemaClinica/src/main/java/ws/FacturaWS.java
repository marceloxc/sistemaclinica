/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Controlador.GenericController;
import com.ucuenca.servidorsistemaclinica.entity.Detallefactura;
import com.ucuenca.servidorsistemaclinica.entity.Factura;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author DELL
 */
@WebService(serviceName = "FacturaWS")
public class FacturaWS {

       /**
     * This is a sample web service operation
     */
    private GenericController<Factura> ctr= new GenericController<Factura>();
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "crearf")
    public boolean crearf(@WebParam(name = "factura") Factura factura) {
        boolean aux=true;
        try
        {
            ctr.create(factura);                
        }
        catch(Exception e){aux=false;
        e.printStackTrace();
        }
        return aux;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editf")
    public boolean editf(@WebParam(name = "Factura") Factura factura) {
        //TODO write your implementation code here:
        boolean aux=true;
        try
        {
            ctr.edit(factura);                
        }
        catch(Exception e){aux=false;}
        return aux;            
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findf")
    public Factura findf(@WebParam(name = "id") String id) {
        //TODO write your implementation code here:
        Factura aux= new Factura();
        try
        {            
            aux=ctr.find(Factura.class, id);                
        }
        catch(Exception e){aux=null;}
        return aux;
    }
}
