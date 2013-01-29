<%-- 
    Document   : selecDoc
    Created on : 19-oct-2010, 10:40:48
    Author     : Graciela
--%>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%
            String tipo = request.getParameter("tipo");
            if (tipo == null) {
                tipo="";
            }
            System.out.println("Tipo: " + tipo);
            try {
                java.util.List<java.lang.Object> result;

                if (tipo.equals("paciente")) {
                    ws.PacienteWS_Service service = new ws.PacienteWS_Service();
                    ws.PacienteWS port = service.getPacienteWSPort();
                    // TODO process result here
                    result = port.reporte();


                } else {
                    ws.SucursalWS_Service service = new ws.SucursalWS_Service();
                    ws.SucursalWS port = service.getSucursalWSPort();
                    // TODO process result here
                    result = port.reporte();
                }
                out.println("Result = " + result);


                byte[] datos = (byte[]) result.get(0);
                //Enviar el archivo al cliente
                ServletOutputStream ouputStream = response.getOutputStream();
                response.setContentType("application/octet-stream");
                response.setHeader("Content-Disposition", "attachment;filename=reporte.pdf");
                ouputStream.write(datos);
                ouputStream.flush();
                ouputStream.close();

            } catch (Exception e) {
                System.out.println("Error Abriendo el archivo" + e.getLocalizedMessage());
            }
        %>
    </body>
</html>
