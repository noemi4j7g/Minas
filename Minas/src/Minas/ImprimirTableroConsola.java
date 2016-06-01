/**
 *
 * @author arquitectura de software I 2016
 */
package Minas;

import java.util.Arrays;

/**
 *
 * @author Noemi Guzman
 */

public class ImprimirTableroConsola {
    public static void imprimitTablero(int [][] tableroAImprimir) {     
        System.out.println(Arrays.deepToString(tableroAImprimir).replaceAll("],", "]," + System.getProperty("line.separator")));       
    }
}
