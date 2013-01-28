/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Controlador.GenericController;
import com.ucuenca.servidorsistemaclinica.entity.Asistente;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author DELL
 */
@WebService(serviceName = "AsistenteWS")
public class AsistenteWS {
    private GenericController<Asistente> ctr= new GenericController<Asistente>();
    /**
     * Web service operation
     */
    @WebMethod(operationName = "crear")
    public boolean crear(@WebParam(name = "asistente") Asistente asistente) {
        //TODO write your implementation code here:
        boolean aux=true;
        try
        {
            ctr.create(asistente);                
        }
        catch(Exception e){aux=false;
        e.printStackTrace();
        }
        return aux;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "edit")
    public boolean edit(@WebParam(name = "asistente") Asistente asistente) {
        //TODO write your implementation code here:
        boolean aux=true;
        try
        {
            ctr.edit(asistente);                
        }
        catch(Exception e){aux=false;}
        return aux;        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "find")
    public Asistente find(@WebParam(name = "id") String id) {
        //TODO write your implementation code here:
        Asistente aux= new Asistente();
        try
        {            
            aux=ctr.find(Asistente.class, id);                
        }
        catch(Exception e){aux=null;}
        return aux;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "findentities")
    public List<Asistente> findentities(@WebParam(name = "fi") int fi, @WebParam(name = "max") int max) {
        //TODO write your implementation code here:
        List<Asistente> aux= new ArrayList<Asistente>();
        try
        {            
            aux=ctr.findEntities(max, fi,new Asistente());                
        }
        catch(Exception e){aux=null;}
        return aux;
    }
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "count")
    public int count() {
        //TODO write your implementation code here:
        int aux= 0;
        try
        {            
            aux=ctr.getCount(new Asistente());                
        }
        catch(Exception e){aux=0;}
        return aux;
    }
}
