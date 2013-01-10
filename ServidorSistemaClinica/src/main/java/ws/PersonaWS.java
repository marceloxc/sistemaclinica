/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Controlador.GenericController;
import com.ucuenca.servidorsistemaclinica.entity.Persona;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 *
 * @author DELL
 */
@WebService(serviceName = "PersonaWS")
public class PersonaWS {

    /**
     * This is a sample web service operation
     */
private GenericController<Persona> ctr= new GenericController<Persona>();
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "crearp")
    public boolean crearp(@WebParam(name = "persona") Persona persona) {
        boolean aux=true;
        try
        {
            ctr.create(persona);                
        }
        catch(Exception e){aux=false;
        e.printStackTrace();
        }
        return aux;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editp")
    public boolean editp(@WebParam(name = "persona") Persona persona) {
        //TODO write your implementation code here:
        boolean aux=true;
        try
        {
            ctr.edit(persona);                
        }
        catch(Exception e){aux=false;}
        return aux;            
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findp")
    public Persona findp(@WebParam(name = "id") String id) {
        //TODO write your implementation code here:
        Persona aux= new Persona();
        try
        {            
            aux=ctr.find(Persona.class, id);                
        }
        catch(Exception e){aux=null;}
        return aux;
    }

    

}