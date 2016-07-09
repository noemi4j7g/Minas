
package juego;

import Tablero.Tablero;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author 
 */
public class JuegoTest {
    
    @Test
    public void testMarcarCeldaConMina() {
        int [][]tableroInicial ={   { 0,-1, 0, 0},
                                    {-1, 0, 0, 0},
                                    { 0, 0, -1, 0},
                                    {-1, 0, 0, 0}};
        
        Tablero tablero = new Tablero(tableroInicial);
        Juego juego = new Juego(tablero);
        juego.marcarCelda( 2, 2);
        boolean juegoActivo = juego.getJugando();
        Assert.assertFalse(juegoActivo);
    }
    
    @Test
    public void testMarcarCeldaSinMina() {
        int [][]tableroInicial ={   { 0,-1, 0, 0},
                                    {-1, 0, 0, 0},
                                    { 0, 0, -1, 0},
                                    {-1, 0, 0, 0}};
        
        Tablero tablero = new Tablero(tableroInicial);
        Juego juego = new Juego(tablero);
        juego.marcarCelda( 3, 3);
        boolean juegoActivo = juego.getJugando();
        Assert.assertTrue(juegoActivo);
    }  
    
    @Test
    public void testVerificarVictoria() {
        int [][]tableroInicial ={   { 0,-1, 0, 0},
                                    {-1, 0, 0, 0},
                                    { 0, 0, 0, 0},
                                    {-1, 0, 0, 0}};
        
        int [][]tableroLleno ={     { 2,-1, 1, 0},
                                    {-1, 2, 1, 0},
                                    { 2, 2, 0, 0},
                                    {-1, 1, 0, 0}};
        
        Tablero tablero = new Tablero(tableroInicial);
        Juego juego = new Juego(tablero);
        juego.marcarCelda(3,3);
        juego.marcarCelda(2,0);
        juego.marcarCelda(0,0);
        boolean victoria= juego.esVictoria();  
        Assert.assertTrue(victoria);
    }
    
    @Test
    public void testVerificarDerrota() {
        int [][]tableroInicial ={   { 0,-1, 0, 0},
                                    {-1, 0, 0, 0},
                                    { 0, 0, 0, 0},
                                    {-1, 0, 0, 0}};
        
        int [][]tableroLleno ={     { 2,-1, 1, 0},
                                    {-1, 2, 1, 0},
                                    { 2, 2, 0, 0},
                                    {-1, 1, 0, 0}};
        
        Tablero tablero = new Tablero(tableroInicial);
        Juego juego = new Juego(tablero);
        juego.marcarCelda(3,3);
        juego.marcarCelda(0,0);
        juego.marcarCelda(3,0);
        boolean derrota= juego.esDerrota();  
        Assert.assertTrue(derrota);
    }
    
    @Test
    public void testActivarTodasLasMinas() {
        int [][]inicial = { {-1, 0, 0,-1},
                            { 0, 0, 0, 0},
                            { 0,-1, 0, 0},
                            { 0, 0, 0,-1},};
        Tablero tablero = new Tablero(inicial);
        Juego juego = new Juego(tablero);
        juego.marcarCelda(0, 0);
        boolean actual =tablero.getCelda(0,0).estaMarcado()&&
                        tablero.getCelda(0,3).estaMarcado()&&
                        tablero.getCelda(2,1).estaMarcado()&&
                        tablero.getCelda(3,3).estaMarcado();
        Assert.assertTrue(actual);
    } 
 
}
