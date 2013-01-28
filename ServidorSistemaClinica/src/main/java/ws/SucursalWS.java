/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Controlador.GenericController;
import com.ucuenca.servidorsistemaclinica.entity.Sucursal;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author DELL
 */
@WebService(serviceName = "SucursalWS")
public class SucursalWS {

    /**
     * This is a sample web service operation
     */
    private GenericController<Sucursal> ctr= new GenericController<Sucursal>();
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "crears")
    public boolean crears(@WebParam(name = "sucursal") Sucursal sucursal) {
        boolean aux=true;
        try
        {
            ctr.create(sucursal);                
        }
        catch(Exception e){aux=false;
        e.printStackTrace();
        }
        return aux;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "edits")
    public boolean edits(@WebParam(name = "sucursal") Sucursal sucursal) {
        //TODO write your implementation code here:
        boolean aux=true;
        try
        {            
            ctr.edit(sucursal);                
        }
        catch(Exception e){aux=false;}
        return aux;            
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "finds")
    public Sucursal finds(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        Sucursal aux= new Sucursal();
        try
        {            
            aux=ctr.find(Sucursal.class, id);                
        }
        catch(Exception e){aux=null;}
        return aux;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "findentitiess")
    public List<Sucursal> findentitiess(@WebParam(name = "fi") int fi, @WebParam(name = "max") int max) {
        //TODO write your implementation code here:
        List<Sucursal> aux= new ArrayList<Sucursal>();
        try
        {            
            aux=ctr.findEntities(max, fi,new Sucursal());                
        }
        catch(Exception e){aux=null;}
        return aux;
    }
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "counts")
    public int counts() {
        //TODO write your implementation code here:
        int aux= 0;
        try
        {            
            aux=ctr.getCount(new Sucursal());                
        }
        catch(Exception e){aux=0;}
        return aux;
    }
}
