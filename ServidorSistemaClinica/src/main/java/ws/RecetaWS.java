/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Controlador.GenericController;
import com.ucuenca.servidorsistemaclinica.entity.Receta;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author DELL
 */
@WebService(serviceName = "RecetaWS")
public class RecetaWS {

     /**
     * This is a sample web service operation
     */
    private GenericController<Receta> ctr= new GenericController<Receta>();
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "crearr")
    public boolean crearr(@WebParam(name = "receta") Receta receta) {
        boolean aux=true;
        try
        {
            ctr.create(receta);                
        }
        catch(Exception e){aux=false;
        e.printStackTrace();
        }
        return aux;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editr")
    public boolean editr(@WebParam(name = "receta") Receta receta) {
        //TODO write your implementation code here:
        boolean aux=true;
        try
        {
            ctr.edit(receta);                
        }
        catch(Exception e){aux=false;}
        return aux;            
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findr")
    public Receta findr(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        Receta aux= new Receta();
        try
        {            
            aux=ctr.find(Receta.class, id);                
        }
        catch(Exception e){aux=null;}
        return aux;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "findentitier")
    public List<Receta> findentitier(@WebParam(name = "fi") int fi, @WebParam(name = "max") int max) {
        //TODO write your implementation code here:
        List<Receta> aux= new ArrayList<Receta>();
        try
        {            
            aux=ctr.findEntities(max, fi,new Receta());                
        }
        catch(Exception e){aux=null;}
        return aux;
    }
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "countr")
    public int countr() {
        //TODO write your implementation code here:
        int aux= 0;
        try
        {            
            aux=ctr.getCount(new Receta());                
        }
        catch(Exception e){aux=0;}
        return aux;
    }
}
