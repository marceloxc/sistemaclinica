/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Controlador.GenericController;
import com.ucuenca.servidorsistemaclinica.entity.Cartera;
import com.ucuenca.servidorsistemaclinica.entity.Cita;
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
    public Cita findci(@WebParam(name = "id") String id) {
        //TODO write your implementation code here:
        Cita aux= new Cita();
        try
        {            
            aux=ctr.find(Cita.class, id);                
        }
        catch(Exception e){aux=null;}
        return aux;
    }
}
