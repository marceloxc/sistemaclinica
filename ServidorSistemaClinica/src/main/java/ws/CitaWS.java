/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Controlador.GenericController;
import com.ucuenca.servidorsistemaclinica.entity.Cartera;
import com.ucuenca.servidorsistemaclinica.entity.Cita;
import com.ucuenca.servidorsistemaclinica.entity.Paciente;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author DELL
 */
@WebService(serviceName = "CitaWS")
public class CitaWS {

    /**
     * This is a sample web service operation
     */
private GenericController<Cita> ctr= new GenericController<Cita>();
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "crearci")
    public boolean crearci(@WebParam(name = "cita") Cita cita) {
        boolean aux=true;
        try
        {
            ctr.create(cita);                
        }
        catch(Exception e){aux=false;
        e.printStackTrace();
        }
        return aux;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editci")
    public boolean editci(@WebParam(name = "cita") Cita cita) {
        //TODO write your implementation code here:
        boolean aux=true;
        try
        {
            ctr.edit(cita);                
        }
        catch(Exception e){aux=false;}
        return aux;            
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findci")
    public Cita findci(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        Cita aux= new Cita();
        try
        {            
            aux=ctr.find(Cita.class, id);                
        }
        catch(Exception e){aux=null;}
        return aux;
    }
    
    
    @WebMethod(operationName = "findentitiesci")
    public List<Cita> findentitiesci(@WebParam(name = "fi") int fi, @WebParam(name = "max") int max) {
        //TODO write your implementation code here:
        List<Cita> aux= new ArrayList<Cita>();
        try
        {            
            aux=ctr.findEntities(max, fi,new Cita());                
        }
        catch(Exception e){aux=null;}
        return aux;
    }
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "countci")
    public int countci() {
        //TODO write your implementation code here:
        int aux= 0;
        try
        {            
            aux=ctr.getCount(new Cita());                
        }
        catch(Exception e){aux=0;}
        return aux;
    }
    
    
}
