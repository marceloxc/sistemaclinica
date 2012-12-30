/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Valex
 */
import javax.persistence.Persistence;

public final class EntityManagerUtil {
    private static final javax.persistence.EntityManagerFactory emfInstance =
        Persistence.createEntityManagerFactory("ServidorPU");

    private EntityManagerUtil() {}

    public static javax.persistence.EntityManagerFactory get() {
        return emfInstance;
    }
}
