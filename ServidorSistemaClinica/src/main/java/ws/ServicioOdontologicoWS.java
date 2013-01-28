/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Controlador.GenericController;
import com.ucuenca.servidorsistemaclinica.entity.ServicioOdontologico;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author DELL
 */
@WebService(serviceName = "ServicioOdontologicoWS")
public class ServicioOdontologicoWS {
    
    private GenericController<ServicioOdontologico> ctr= new GenericController<ServicioOdontologico>();
    /**
     * Web service operation
     */
    @WebMethod(operationName = "crearso")
    public boolean crearso(@WebParam(name = "servicioodontologico") ServicioOdontologico servicioodontologico) {
        boolean aux=true;
        try
        {
            ctr.create(servicioodontologico);                
        }
        catch(Exception e){aux=false;
        e.printStackTrace();
        }
        return aux;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editso")
    public boolean editso(@WebParam(name = "servicioodontologico") ServicioOdontologico servicioodontologico) {
        //TODO write your implementation code here:
        boolean aux=true;
        try
        {            
            ctr.edit(servicioodontologico);                
        }
        catch(Exception e){aux=false;}
        return aux;            
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findso")
    public ServicioOdontologico findso(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        ServicioOdontologico aux= new ServicioOdontologico();
        try
        {            
            aux=ctr.find(ServicioOdontologico.class, id);                
        }
        catch(Exception e){aux=null;}
        return aux;
    }
    
    @WebMethod(operationName = "findentitieso")
    public List<ServicioOdontologico> findentitiedc(@WebParam(name = "fi") int fi, @WebParam(name = "max") int max) {
        //TODO write your implementation code here:
        List<ServicioOdontologico> aux= new ArrayList<ServicioOdontologico>();
        try
        {            
            aux=ctr.findEntities(max, fi,new ServicioOdontologico());                
        }
        catch(Exception e){aux=null;}
        return aux;
    }
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "countso")
    public int countso() {
        //TODO write your implementation code here:
        int aux= 0;
        try
        {            
            aux=ctr.getCount(new ServicioOdontologico());                
        }
        catch(Exception e){aux=0;}
        return aux;
    }
}
