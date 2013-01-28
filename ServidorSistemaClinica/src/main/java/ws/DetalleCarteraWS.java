/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Controlador.GenericController;
import com.ucuenca.servidorsistemaclinica.entity.DetalleCartera;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author DELL
 */
@WebService(serviceName = "DetalleCarteraWS")
public class DetalleCarteraWS {

    /**
     * This is a sample web service operation
     */
private GenericController<DetalleCartera> ctr= new GenericController<DetalleCartera>();
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "creardc")
    public boolean creardc(@WebParam(name = "detallecartera") DetalleCartera detallecartera) {
        boolean aux=true;
        try
        {
            ctr.create(detallecartera);                
        }
        catch(Exception e){aux=false;
        e.printStackTrace();
        }
        return aux;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editdc")
    public boolean editdc(@WebParam(name = "detallecartera") DetalleCartera detallecartera) {
        //TODO write your implementation code here:
        boolean aux=true;
        try
        {
            ctr.edit(detallecartera);                
        }
        catch(Exception e){aux=false;}
        return aux;            
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "finddc")
    public DetalleCartera finddc(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        DetalleCartera aux= new DetalleCartera();
        try
        {            
            aux=ctr.find(DetalleCartera.class, id);                
        }
        catch(Exception e){aux=null;}
        return aux;
    }
    
    
    
    @WebMethod(operationName = "findentitiedc")
    public List<DetalleCartera> findentitiedc(@WebParam(name = "fi") int fi, @WebParam(name = "max") int max) {
        //TODO write your implementation code here:
        List<DetalleCartera> aux= new ArrayList<DetalleCartera>();
        try
        {            
            aux=ctr.findEntities(max, fi,new DetalleCartera());                
        }
        catch(Exception e){aux=null;}
        return aux;
    }
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "countdc")
    public int countdc() {
        //TODO write your implementation code here:
        int aux= 0;
        try
        {            
            aux=ctr.getCount(new DetalleCartera());                
        }
        catch(Exception e){aux=0;}
        return aux;
    }
}
