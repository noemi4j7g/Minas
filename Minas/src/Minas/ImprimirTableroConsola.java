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
        //System.out.println(Arrays.toString(tableroAImprimir));
        System.out.println(Arrays.deepToString(tableroAImprimir).replaceAll("],", "]," + System.getProperty("line.separator")));       
    }

    public static void imprimitTableroJugador(String [][] tableroAImprimir) {   
        for (int i = 0; i < tableroAImprimir.length; i++) {           
            for (int j = 0; j < tableroAImprimir[i].length; j++) {
                 if (tableroAImprimir[i][j] == null) {
                     tableroAImprimir[i][j] = "*";
                 }
            }            
         }
        System.out.println(Arrays.deepToString(tableroAImprimir).replaceAll("],", "]," + System.getProperty("line.separator")));       
    }
}
