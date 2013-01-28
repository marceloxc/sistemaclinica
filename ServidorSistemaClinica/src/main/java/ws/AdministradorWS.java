/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Controlador.GenericController;
import com.ucuenca.servidorsistemaclinica.entity.Administrador;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author DELL
 */
@WebService(serviceName = "AdministradorWS")
public class AdministradorWS {

    private GenericController<Administrador> ctr= new GenericController<Administrador>();
    /**
     * Web service operation
     */
    @WebMethod(operationName = "crearad")
    public boolean crearad(@WebParam(name = "administrador") Administrador administrador) {
        //TODO write your implementation code here:
        boolean aux=true;
        try
        {
            ctr.create(administrador);                
        }
        catch(Exception e){aux=false;
        e.printStackTrace();
        }
        return aux;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editad")
    public boolean editad(@WebParam(name = "admistrador") Administrador administrador) {
        //TODO write your implementation code here:
        boolean aux=true;
        try
        {
            ctr.edit(administrador);                
        }
        catch(Exception e){aux=false;}
        return aux;        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findad")
    public Administrador findad(@WebParam(name = "id") String id) {
        //TODO write your implementation code here:
        Administrador aux= new Administrador();
        try
        {            
            aux=ctr.find(Administrador.class, id);                
        }
        catch(Exception e){aux=null;}
        return aux;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "findentitiesad")
    public List<Administrador> findentitiesad(@WebParam(name = "fi") int fi, @WebParam(name = "max") int max) {
        //TODO write your implementation code here:
        List<Administrador> aux= new ArrayList<Administrador>();
        try
        {            
            aux=ctr.findEntities(max, fi,new Administrador());                
        }
        catch(Exception e){aux=null;}
        return aux;
    }
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "countad")
    public int countad() {
        //TODO write your implementation code here:
        int aux= 0;
        try
        {            
            aux=ctr.getCount(new Administrador());                
        }
        catch(Exception e){aux=0;}
        return aux;
    }
}
