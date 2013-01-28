/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author johnny
 */
public class validaciones {

    public String encripta(String clave) {
        char lc_comodin;
        String encriptado = "";
        for (int i = 0; i <= clave.length() - 1; i++) {
            lc_comodin = clave.charAt(i);
            for (int i2 = 0; i2 <= encriptado.length(); i2++) {
                lc_comodin++;
            }
            encriptado = encriptado + lc_comodin;

        }
        return encriptado;
    }
}
