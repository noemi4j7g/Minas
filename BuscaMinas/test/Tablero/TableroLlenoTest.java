
package Tablero;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author 
 */
public class TableroLlenoTest {
    
    @Test
    public void testLlenar1sUnaMina() {
        int [][]tableroInicial = { { 0, 0, 0},
                                   { 0,-1, 0},
                                   { 0, 0, 0}};
        
        int [][]tableroEsperado = { { 1, 1, 1},
                                    { 1,-1, 1},
                                    { 1, 1, 1}};
        TableroLleno tableroLleno = new TableroLleno(tableroInicial);
        int[][] tableroActual = tableroLleno.getTableroLleno();
        Assert.assertArrayEquals(tableroEsperado, tableroActual);
    }
    
    @Test
    public void testLlenar1sDosMinas() {
        int [][]tableroInicial = { {-1, 0, 0},
                                   { 0, 0, 0},
                                   { 0, 0,-1}};
        
        int [][]tableroEsperado = { {-1, 1, 0},
                                    { 1, 2, 1},
                                    { 0, 1,-1}};
        TableroLleno tableroLleno = new TableroLleno(tableroInicial);
        int[][] tableroActual = tableroLleno.getTableroLleno();
        Assert.assertArrayEquals(tableroEsperado, tableroActual);
    }
    
    @Test
    public void testLlenar1s4Minas() {
        int [][]tableroInicial = { {-1, 0,-1},
                                   { 0, 0, 0},
                                   {-1, 0,-1}};
        
        int [][]tableroEsperado = { {-1, 2,-1},
                                    { 2, 4, 2},
                                    {-1, 2,-1}};
        TableroLleno tableroLleno = new TableroLleno(tableroInicial);
        int[][] tableroActual = tableroLleno.getTableroLleno();
        Assert.assertArrayEquals(tableroEsperado, tableroActual);
    }
    
}
