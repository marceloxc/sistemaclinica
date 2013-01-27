/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Controlador.GenericController;
import com.ucuenca.servidorsistemaclinica.entity.HistoriaClinica;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author DELL
 */
@WebService(serviceName = "HistoriaClinicaWS")
public class HistoriaClinicaWS {

    private GenericController<HistoriaClinica> ctr= new GenericController<HistoriaClinica>();
    /**
     * Web service operation
     */
    @WebMethod(operationName = "crearhc")
    public boolean crearhc(@WebParam(name = "historiaclinica") HistoriaClinica historiaclinica) {
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
    public boolean edithc(@WebParam(name = "historiaclinica") HistoriaClinica historiaclinica) {
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
    public HistoriaClinica findhc(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        HistoriaClinica aux= new HistoriaClinica();
        try
        {            
            aux=ctr.find(HistoriaClinica.class, id);                
        }
        catch(Exception e){aux=null;}
        return aux;
    }
}
