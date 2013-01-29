/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Controlador.GenericController;
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
@WebService(serviceName = "PacienteWS")
public class PacienteWS {

      /**
     * This is a sample web service operation
     */
    private GenericController<Paciente> ctr= new GenericController<Paciente>();
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "crearpa")
    public boolean crearpa(@WebParam(name = "paciente") Paciente paciente) {
        boolean aux=true;
        try
        {
            ctr.create(paciente);                
        }
        catch(Exception e){aux=false;
        e.printStackTrace();
        }
        return aux;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editpa")
    public boolean editpa(@WebParam(name = "paciente") Paciente paciente) {
        //TODO write your implementation code here:
        boolean aux=true;
        try
        {
            ctr.edit(paciente);                
        }
        catch(Exception e){aux=false;}
        return aux;            
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findpa")
    public Paciente findpa(@WebParam(name = "id") String id) {
        //TODO write your implementation code here:
        Paciente aux= new Paciente();
        try
        {            
            aux=ctr.find(Paciente.class, id);                
        }
        catch(Exception e){aux=null;}
        return aux;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "findentitiespa")
    public List<Paciente> findentitiespa(@WebParam(name = "fi") int fi, @WebParam(name = "max") int max) {
        //TODO write your implementation code here:
        List<Paciente> aux= new ArrayList<Paciente>();
        try
        {            
            aux=ctr.findEntities(max, fi,new Paciente());                
        }
        catch(Exception e){aux=null;}
        return aux;
    }
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "countpa")
    public int countpa() {
        //TODO write your implementation code here:
        int aux= 0;
        try
        {            
            aux=ctr.getCount(new Paciente());                
        }
        catch(Exception e){aux=0;}
        return aux;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "reporte")
    public java.lang.Object[] reporte() {
        //TODO write your implementation code here:
        return ctr.report("paciente", "pacientes.jasper", new Paciente());
    }
}
