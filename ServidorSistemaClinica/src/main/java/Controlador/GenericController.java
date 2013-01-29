/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.ucuenca.servidorsistemaclinica.entity.Sucursal;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import util.EntityManagerUtil;
import ws.SucursalWS;
/*
import controller.exceptions.NonexistentEntityException;
import controller.exceptions.PreexistingEntityException;
import controller.exceptions.RollbackFailureException;
*/
/**
 *
 * @author Valex
 */
public class GenericController<T> {
    
     private T objeto;

    public void GenericContoller(T objeto) {
        this.objeto = objeto;
    }
    
    public void GenericContoller() {
        
    }

    public T getObjeto() {
        return objeto;
    }

    public void setObjeto(T objeto) {
        this.objeto = objeto;
    }

    public EntityManager getEntityManager() {
        return EntityManagerUtil.get().createEntityManager();
    }

    public void create(T objeto) {

        EntityManager em = null;
        em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            try {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
            } catch (Exception re) {
                re.printStackTrace();
                //throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            ex.printStackTrace();
           //throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
      public void edit(T obj) throws Exception  {
    	 EntityManager em = null;
         em = getEntityManager();
        try {
        	em.getTransaction().begin();                               
            obj = em.merge(obj);         
            em.getTransaction().commit();
        } catch (Exception ex) {
            try {
            	em.getTransaction().rollback();
            } catch (Exception re) {
                re.printStackTrace();
            }
            
            ex.printStackTrace();
            throw new Exception(ex);
          /*  String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Method [] metodos = obj.getClass().getDeclaredMethods();
                Object id = metodos[0].invoke(obj,null);
                if (find(obj,id) == null) {
                    throw new NonexistentEntityException("The categoria with id " + id + " no longer exists.");
                }
            }*/
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
       
    public T find(Class <T> obj, Object id) {
        EntityManager em = getEntityManager();
        System.out.println("Clase: " + obj.getClass().getName() + id);
        try {
            return (T)em.find(obj, id);
        } finally {
            em.close();
        }
    }  
    
    public int getCount(T obj) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Object> rt = cq.from(obj.getClass());
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } catch (Exception c){
            c.getMessage();
            return 0;
        }
        finally {
            em.close();
        }
    }
        
    public List<T> findEntities(int maxResults, int firstResult,T obj) {
        return findEntities(false, maxResults, firstResult,obj);
    }
    
    private List<T> findEntities(boolean all, int maxResults, int firstResult,T obj) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(obj.getClass()));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
   public List<Object> findWhere(T obj,String where) {
    	EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery(" from "+ obj.getClass().getName() + "c " + where);
            
            List<Object> lp = q.getResultList();
            return lp;
        }catch(Exception e){
        	System.out.println(e.getMessage());
        }
        return null;
    }

   public Object[] report(String tipo, String archivo, T obj) {
        List<T> lista = findEntities(true, -1,-1, obj);
        try {
            File f = new File(archivo);
            System.out.println("Arc: " + f.getAbsolutePath());
            JasperReport reporte = (JasperReport) JRLoader.loadObject(f);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(lista));
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            File archivoPdf = new File("reporte.pdf");
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
