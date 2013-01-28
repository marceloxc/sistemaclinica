/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Controlador.GenericController;
import com.ucuenca.servidorsistemaclinica.entity.Cartera;
import com.ucuenca.servidorsistemaclinica.entity.DetalleFactura;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author DELL
 */
@WebService(serviceName = "DetalleFacturaWS")
public class DetalleFacturaWS {

    private GenericController<DetalleFactura> ctr= new GenericController<DetalleFactura>();
    /**
     * Web service operation
     */
    @WebMethod(operationName = "creardf")
    public boolean creardf(@WebParam(name = "detallefactura") DetalleFactura detallefactura) {
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
    public boolean editdf(@WebParam(name = "detallehistoriaclinica") DetalleFactura detallefactura) {
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
    public DetalleFactura finddf(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        DetalleFactura aux= new DetalleFactura();
        try
        {            
            aux=ctr.find(DetalleFactura.class, id);                
        }
        catch(Exception e){aux=null;}
        return aux;
    }
    
    
    @WebMethod(operationName = "findentitiede")
    public List<DetalleFactura> findentitiede(@WebParam(name = "fi") int fi, @WebParam(name = "max") int max) {
        //TODO write your implementation code here:
        List<DetalleFactura> aux= new ArrayList<DetalleFactura>();
        try
        {            
            aux=ctr.findEntities(max, fi,new DetalleFactura());                
        }
        catch(Exception e){aux=null;}
        return aux;
    }
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "countca")
    public int countca() {
        //TODO write your implementation code here:
        int aux= 0;
        try
        {            
            aux=ctr.getCount(new DetalleFactura());                
        }
        catch(Exception e){aux=0;}
        return aux;
    }
    
}
