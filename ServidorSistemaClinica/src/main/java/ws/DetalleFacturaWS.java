/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Controlador.GenericController;
import com.ucuenca.servidorsistemaclinica.entity.Cita;
import com.ucuenca.servidorsistemaclinica.entity.Detallefactura;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author DELL
 */
@WebService(serviceName = "DetalleFacturaWS")
public class DetalleFacturaWS {

        /**
     * This is a sample web service operation
     */
    private GenericController<Detallefactura> ctr= new GenericController<Detallefactura>();
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "creardf")
    public boolean creardf(@WebParam(name = "detallefactura") Detallefactura detallefactura) {
        boolean aux=true;
        try
        {
            ctr.create(detallefactura);                
        }
        catch(Exception e){aux=false;
        e.printStackTrace();
        }
        return aux;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editdf")
    public boolean editdf(@WebParam(name = "detallefactura") Detallefactura detallefactura) {
        //TODO write your implementation code here:
        boolean aux=true;
        try
        {
            ctr.edit(detallefactura);                
        }
        catch(Exception e){aux=false;}
        return aux;            
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "finddf")
    public Detallefactura finddf(@WebParam(name = "id") String id) {
        //TODO write your implementation code here:
        Detallefactura aux= new Detallefactura();
        try
        {            
            aux=ctr.find(Detallefactura.class, id);                
        }
        catch(Exception e){aux=null;}
        return aux;
    }
}
