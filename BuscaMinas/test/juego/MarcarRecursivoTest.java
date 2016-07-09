
package juego;

import Tablero.Tablero;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author 
 */
public class MarcarRecursivoTest {
    
    @Test
    public void testMarcarCeldaLibreDevolverN() {
        int [][]tableroInicial ={   { 0,-1, 0, 0},
                                    {-1, 0, 0, 0},
                                    { 0, 0, 0, 0},
                                    {-1, 0, 0, 0}};
        
        int [][]tableroLleno ={     { 2,-1, 1, 0},
                                    {-1, 2, 1, 0},
                                    { 2, 2, 0, 0},
                                    {-1, 1, 0, 0}};
        
        char [][]tableroEsperado={  { '?', '?', '_', '_'},
                                    { '?', '_', '_', '_'},
                                    { '?', '_', '_', '_'},
                                    { '?', '_', '_', '_'}};
        MarcarCelda marcar = new MarcarCelda();
        Tablero tablero = new Tablero(tableroInicial);
        int esperado = 11;
        int actual = marcar.marcarCelda(3,3,tablero);
        Assert.assertEquals(esperado, actual);
    } 
    
}
