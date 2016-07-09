
package juego;

import Tablero.Posicion;
import Tablero.Tablero;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author 
 */
public class MarcarCeldaTest {
    
    @Test
    public void testMarcarCeldaMinaDevolver1Negativo() {
        MarcarCelda marcar = new MarcarCelda();
        Tablero tablero = new Tablero(4,4,25);
        Posicion mina = tablero.getListaMinas().get(0);
        int esperado = -1;
        int actual = marcar.marcarCelda(mina.getFila(), mina.getColumna(),tablero);
        Assert.assertEquals(esperado, actual);
    }  
    
    @Test
    public void testMarcarCeldaLlenaDevolver1() {
        MarcarCelda marcar = new MarcarCelda();
        int [][]tableroInicial ={   { 0,-1, 0, 0},
                                    {-1, 0, 0, 0},
                                    { 0, 0, -1, 0},
                                    {-1, 0, 0, 0}};
        
        Tablero tablero = new Tablero(tableroInicial);
        int esperado = 1;
        int actual = marcar.marcarCelda(1,1,tablero);
        Assert.assertEquals(esperado, actual);
    }  
    
    @Test
    public void testCeldaValidaDevolverMayor0() {
        MarcarCelda marcar = new MarcarCelda();
        int [][] tabIni = { {-1, 0, 0},
                            { 0, 0, 0},
                            {-1, 0, 0},};
        Tablero tablero = new Tablero(tabIni); 
        int esperado = 1;
        int actual = marcar.marcarCelda( 1, 1, tablero);
        Assert.assertEquals(esperado, actual);
    } 
    
    @Test
    public void testCeldaInvalidaDevolver0() {
        MarcarCelda marcar = new MarcarCelda();
        Tablero tablero = new Tablero(4,4,10); 
        int esperado = 0;
        int actual = marcar.marcarCelda( 4, 4, tablero);
        Assert.assertEquals(esperado, actual);
    } 
     
}
