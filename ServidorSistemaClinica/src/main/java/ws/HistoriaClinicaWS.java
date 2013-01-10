/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Controlador.GenericController;

import com.ucuenca.servidorsistemaclinica.entity.Historiaclinica;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author DELL
 */
@WebService(serviceName = "HistoriaClinicaWS")
public class HistoriaClinicaWS {

      /**
     * This is a sample web service operation
     */
    private GenericController<Historiaclinica> ctr= new GenericController<Historiaclinica>();
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "crearhc")
    public boolean crearhc(@WebParam(name = "historiaclinica") Historiaclinica historiaclinica) {
        boolean aux=true;
        try
        {
            ctr.create(historiaclinica);                
        }
        catch(Exception e){aux=false;
        e.printStackTrace();
        }
        return aux;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "edithc")
    public boolean edithc(@WebParam(name = "historiaclinica") Historiaclinica historiaclinica) {
        //TODO write your implementation code here:
        boolean aux=true;
        try
        {
            ctr.edit(historiaclinica);                
        }
        catch(Exception e){aux=false;}
        return aux;            
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findhc")
    public Historiaclinica findhc(@WebParam(name = "id") String id) {
        //TODO write your implementation code here:
        Historiaclinica aux= new Historiaclinica();
        try
        {            
            aux=ctr.find(Historiaclinica.class, id);                
        }
        catch(Exception e){aux=null;}
        return aux;
    }
}
