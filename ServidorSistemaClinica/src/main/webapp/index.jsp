<%@page import="java.util.Date"%>
<%@page import="Controlador.GenericController"%>
<%@page import="com.ucuenca.servidorsistemaclinica.entity.Asistente"%>
<%@page import="com.ucuenca.servidorsistemaclinica.entity.Sucursal"%>
<%@page import="com.ucuenca.servidorsistemaclinica.entity.Persona"%>
<%@page import="com.ucuenca.servidorsistemaclinica.entity.Cita"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ola Ke Ase!</h1>
        <%
            GenericController<Asistente> controller = new GenericController<Asistente>();
            //Asistente p = new Asistente("123456789");
            //Sucursal s=new Sucursal(1);            
            //p.setIdSucursal(s);
            //p.setFechaIngreso(new Date());                        
            //controller.create(p);
            
                        
            //Asistente p2 = controller.find(Asistente.class, "123456789");
            //out.println(p2.getCedula() + " " + p2.getIdSucursal().getNumSucursal());
        %>
    </body>
</html>
