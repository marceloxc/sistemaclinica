<%@page import="Controlador.GenericController"%>
<%@page import="com.ucuenca.servidorsistemaclinica.entity.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            GenericController<Persona> controller = new GenericController<Persona>();
            Persona p = new Persona("123456789");
            p.setNombres("Juan");
            p.setApellidos("perez");
            controller.create(p);
            
            Persona p2 = controller.find(Persona.class, "123456789");
            out.println(p2.getNombres() + " " + p2.getApellidos());
        %>
    </body>
</html>
