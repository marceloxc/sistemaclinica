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
}
