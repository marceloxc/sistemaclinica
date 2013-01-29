/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Controlador.GenericController;
import com.ucuenca.servidorsistemaclinica.entity.Sucursal;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author DELL
 */
@WebService(serviceName = "SucursalWS")
public class SucursalWS {

    /**
     * This is a sample web service operation
     */
    private GenericController<Sucursal> ctr = new GenericController<Sucursal>();

    /**
     * Web service operation
     */
    @WebMethod(operationName = "crears")
    public boolean crears(@WebParam(name = "sucursal") Sucursal sucursal) {
        boolean aux = true;
        try {
            ctr.create(sucursal);
        } catch (Exception e) {
            aux = false;
            e.printStackTrace();
        }
        return aux;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "edits")
    public boolean edits(@WebParam(name = "sucursal") Sucursal sucursal) {
        //TODO write your implementation code here:
        boolean aux = true;
        try {
            ctr.edit(sucursal);
        } catch (Exception e) {
            aux = false;
        }
        return aux;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "finds")
    public Sucursal finds(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        Sucursal aux = new Sucursal();
        try {
            aux = ctr.find(Sucursal.class, id);
        } catch (Exception e) {
            aux = null;
        }
        return aux;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findentitiess")
    public List<Sucursal> findentitiess(@WebParam(name = "fi") int fi, @WebParam(name = "max") int max) {
        //TODO write your implementation code here:
        List<Sucursal> aux = new ArrayList<Sucursal>();
        try {
            aux = ctr.findEntities(max, fi, new Sucursal());
        } catch (Exception e) {
            aux = null;
        }
        return aux;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "counts")
    public int counts() {
        //TODO write your implementation code here:
        int aux = 0;
        try {
            aux = ctr.getCount(new Sucursal());
        } catch (Exception e) {
            aux = 0;
        }
        return aux;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "reporte")
    public java.lang.Object[] reporte() {

        List<Sucursal> lista = this.findentitiess(0, 1000);
        try {
            File f = new File("sucursal.jasper");
            System.out.println("Arc: " + f.getAbsolutePath());
            JasperReport reporte = (JasperReport) JRLoader.loadObject(f);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(lista));
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            File archivoPdf = new File("reporteEnPdf.pdf");
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, archivoPdf);
            exporter.exportReport();

            File auxFile = archivoPdf;

            //Se pasa el File a un byte[]
            int size = (int) auxFile.length();//gets the number of bytes of the file
            InputStream in;
            try {
                in = new FileInputStream(auxFile);
                byte content[] = new byte[size];
                in.read(content);
                in.close();
                Object o[] = {content};
                return o;
            } catch (IOException ex) {
                Logger.getLogger(SucursalWS.class.getName()).log(Level.SEVERE, null, ex);
            }

            return null;

        } catch (JRException e) {
            e.printStackTrace();
        }

        //TODO write your implementation code here:
        return null;
    }
}
