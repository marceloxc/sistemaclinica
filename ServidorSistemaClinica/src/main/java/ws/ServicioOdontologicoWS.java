/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Controlador.GenericController;
import com.ucuenca.servidorsistemaclinica.entity.ServicioOdontologico;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author DELL
 */
@WebService(serviceName = "ServicioOdontologicoWS")
public class ServicioOdontologicoWS {
    
    private GenericController<ServicioOdontologico> ctr= new GenericController<ServicioOdontologico>();
    /**
     * Web service operation
     */
    @WebMethod(operationName = "crearso")
    public boolean crearso(@WebParam(name = "servicioodontologico") ServicioOdontologico servicioodontologico) {
        boolean aux=true;
        try
        {
            ctr.create(servicioodontologico);                
        }
        catch(Exception e){aux=false;
        e.printStackTrace();
        }
        return aux;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editso")
    public boolean editso(@WebParam(name = "servicioodontologico") ServicioOdontologico servicioodontologico) {
        //TODO write your implementation code here:
        boolean aux=true;
        try
        {            
            ctr.edit(servicioodontologico);                
        }
        catch(Exception e){aux=false;}
        return aux;            
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findso")
    public ServicioOdontologico findso(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        ServicioOdontologico aux= new ServicioOdontologico();
        try
        {            
            aux=ctr.find(ServicioOdontologico.class, id);                
        }
        catch(Exception e){aux=null;}
        return aux;
    }
}
