/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Controlador.GenericController;
import com.ucuenca.servidorsistemaclinica.entity.Odontologo;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author DELL
 */
@WebService(serviceName = "OdontologoWS")
public class OdontologoWS {

      /**
     * This is a sample web service operation
     */
    private GenericController<Odontologo> ctr= new GenericController<Odontologo>();
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "crearo")
    public boolean crearo(@WebParam(name = "odontologo") Odontologo odontologo) {
        boolean aux=true;
        try
        {
            ctr.create(odontologo);                
        }
        catch(Exception e){aux=false;
        e.printStackTrace();
        }
        return aux;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "edito")
    public boolean edito(@WebParam(name = "odontologo") Odontologo odontologo) {
        //TODO write your implementation code here:
        boolean aux=true;
        try
        {
            ctr.edit(odontologo);                
        }
        catch(Exception e){aux=false;}
        return aux;            
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findo")
    public Odontologo findo(@WebParam(name = "id") String id) {
        //TODO write your implementation code here:
        Odontologo aux= new Odontologo();
        try
        {            
            aux=ctr.find(Odontologo.class, id);                
        }
        catch(Exception e){aux=null;}
        return aux;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "findentitieso")
    public List<Odontologo> findentitieso(@WebParam(name = "fi") int fi, @WebParam(name = "max") int max) {
        //TODO write your implementation code here:
        List<Odontologo> aux= new ArrayList<Odontologo>();
        try
        {            
            aux=ctr.findEntities(max, fi,new Odontologo());                
        }
        catch(Exception e){aux=null;}
        return aux;
    }
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "counto")
    public int counto() {
        //TODO write your implementation code here:
        int aux= 0;
        try
        {            
            aux=ctr.getCount(new Odontologo());                
        }
        catch(Exception e){aux=0;}
        return aux;
    }
}
