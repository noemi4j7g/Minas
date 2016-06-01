/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Minas;

import java.util.Arrays;

/**
 *
 * @author Noemi Guzman
 */

public class ImprimirTableroConsola {
    public void imprimitTablero(int [][] tableroAImprimir) {     
        System.out.println(Arrays.deepToString(tableroAImprimir).replaceAll("],", "]," + System.getProperty("line.separator")));       
    }
}
