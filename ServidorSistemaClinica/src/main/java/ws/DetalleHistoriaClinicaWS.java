/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Controlador.GenericController;
import com.ucuenca.servidorsistemaclinica.entity.DetalleHistoriaClinica;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author DELL
 */
@WebService(serviceName = "DetalleHistoriaClinicaWS")
public class DetalleHistoriaClinicaWS {

    private GenericController<DetalleHistoriaClinica> ctr= new GenericController<DetalleHistoriaClinica>();
    /**
     * Web service operation
     */
    @WebMethod(operationName = "creardhc")
    public boolean creardhc(@WebParam(name = "detallehistoriaclinica") DetalleHistoriaClinica detallehistoriaclinica) {
        boolean aux=true;
        try
        {
            ctr.create(detallehistoriaclinica);                
        }
        catch(Exception e){aux=false;
        e.printStackTrace();
        }
        return aux;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editdhc")
    public boolean editdhc(@WebParam(name = "detallehistoriaclinica") DetalleHistoriaClinica detallehistoriaclinica) {
        //TODO write your implementation code here:
        boolean aux=true;
        try
        {            
            ctr.edit(detallehistoriaclinica);                
        }
        catch(Exception e){aux=false;}
        return aux;            
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "finddhc")
    public DetalleHistoriaClinica finddhc(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        DetalleHistoriaClinica aux= new DetalleHistoriaClinica();
        try
        {            
            aux=ctr.find(DetalleHistoriaClinica.class, id);                
        }
        catch(Exception e){aux=null;}
        return aux;
    }
}
