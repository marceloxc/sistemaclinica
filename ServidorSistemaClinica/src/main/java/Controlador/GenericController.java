/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import util.EntityManagerUtil;
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

}
