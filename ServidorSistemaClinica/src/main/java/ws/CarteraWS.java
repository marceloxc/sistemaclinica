/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Controlador.GenericController;
import com.ucuenca.servidorsistemaclinica.entity.Cartera;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author DELL
 */
@WebService(serviceName = "CarteraWS")
public class CarteraWS {

    /**
     * This is a sample web service operation
     */
private GenericController<Cartera> ctr= new GenericController<Cartera>();
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "crearc")
    public boolean crearc(@WebParam(name = "cartera") Cartera cartera) {
        boolean aux=true;
        try
        {
            ctr.create(cartera);                
        }
        catch(Exception e){aux=false;
        e.printStackTrace();
        }
        return aux;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editc")
    public boolean editc(@WebParam(name = "cartera") Cartera cartera) {
        //TODO write your implementation code here:
        boolean aux=true;
        try
        {
            ctr.edit(cartera);                
        }
        catch(Exception e){aux=false;}
        return aux;            
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findc")
    public Cartera findc(@WebParam(name = "id") String id) {
        //TODO write your implementation code here:
        Cartera aux= new Cartera();
        try
        {            
            aux=ctr.find(Cartera.class, id);                
        }
        catch(Exception e){aux=null;}
        return aux;
    }
}
