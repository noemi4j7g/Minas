

import Minas.Juego;
import java.util.stream.IntStream;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Tests for @link{Minas} class
 * @author arquitectura de software I 2016
*/
public class JuegoTest {
    
    @Test
    public void testDestaparCasillaSinBomba() {
        Juego juegoM = new Juego(1,1,0);
        int [][] obtenido = juegoM.optenerTablero();       
        int [][] esperado = { {0} };
        assertArrayEquals(esperado,obtenido);   
    }
    @Test(expected = UnsupportedOperationException.class)
    public void testDestaparCasillaConBomba() {
        Juego juegoM = new Juego(1,1,1);
        int [][] obtenido = juegoM.optenerTablero(); 
      
    }
    
    @Test
    public void testJuego2por2ConBomba() {
        Juego juegoM = new Juego(1,2,1);
        int [][] tablero = juegoM.optenerTablero();       
        int  esperado = 0; //1 y -1
        int obtenido = IntStream.of(tablero[0]).sum();        
        assertEquals(esperado,obtenido);   
      
       
    }
    
    @Test
    public void testJuego2por2SinBomba() {
        int sum=0;
        Juego juegoM = new Juego(2,2,0);
        int [][] tablero = juegoM.optenerTablero();       
        int  esperado = 0; 
        for(int[] i: tablero) {
            sum += IntStream.of(i).sum(); ;
        }       
        assertEquals(esperado,sum);   
    }   
    
    @Test

    public void testJuego3por3casillaterminarCon8Jugadas() {
        Juego juegoM = new Juego(3,3,1);
        int [][] tablero = juegoM.optenerTablero();
        for (int i=0;i<9;i++){
            juegoM.regitrarJugada();
        }  
        juegoM.calcularCasillasPorAbrir();
        boolean obtenido = juegoM.terminoJuego();
        boolean esperado = true;
        assertEquals(esperado,obtenido);    
    }
    @Test
    
    public void testJuego3por3casillaNoterminaroCon3Jugadas() {
        Juego juegoM = new Juego(3,3,1);
        int [][] tablero = juegoM.optenerTablero();
        for (int i=0;i<3;i++){
            juegoM.regitrarJugada();
        }            
        juegoM.calcularCasillasPorAbrir();
        boolean obtenido = juegoM.terminoJuego();
        boolean esperado = false;
        assertEquals(esperado,obtenido);    
    }
    /*
    @Test
    public void testJuego3por3casillaCercaDeDosBombas() {
        Minas juego = new Minas(3,3);
        juego.cargarBombasJuntas(2,0,0);
        int obtenido = juego.abrirJugada(0,0);
        int esperado = 2;  
        assertEquals(esperado,obtenido);    
    }
    
    @Test
    public void testJuego5por5casillaNoTieneBombaCerca() {
        Minas juego = new Minas(5,5);
        juego.cargarBombasJuntas(0,1,1);
        int obtenido = juego.abrirJugada(1,1);
        int esperado = 0;        
        assertEquals(esperado,obtenido);    
    }
    
    @Test
    public void testJuego6por6casillaTiene5BombasCerca() {
        Minas juego = new Minas(6,6);
        juego.cargarBombasJuntas(5,3,2);
        int obtenido = juego.abrirJugada(3,2);
        int esperado = 5;
        assertEquals(esperado,obtenido);    
    }   
    @Test
    public void testJuego6por6NegativoBombasCerca() {
        Minas juego = new Minas(6,6);
        juego.cargarBombasJuntas(-5,3,2);
        int obtenido = juego.abrirJugada(3,2);
        int esperado = 0;
        assertEquals(esperado,obtenido);    
    }
*/
}
