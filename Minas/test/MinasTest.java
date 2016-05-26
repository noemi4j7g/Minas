

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Tests for @link{Minas} class
 * @author arquitectura de software I 2016
*/

public class MinasTest {
    
    @Test
    public void testDestaparCasillaSinBomba() {
        Minas juego = new Minas(1,1);
        boolean obtenido = juego.esBomba(0,0);
        boolean esperado = false;
        assertEquals(esperado,obtenido);
    }

    @Test
    public void testDestaparCasillaConBomba() {
        Minas juego = new Minas(1,1);
        juego.cargarBombas11();
        boolean obtenido = juego.esBomba(0,0);
        boolean esperado = true;
        assertEquals(esperado,obtenido);    
    }
    
    @Test
    public void testJuego2por2ConBomba() {
        Minas juego = new Minas(2,2);
        juego.cargarBombas11();
        boolean obtenido = juego.esBomba(0,0);
        boolean esperado = true;
        assertEquals(esperado,obtenido);    
    }
    
    @Test
    public void testJuego2por2SinBomba() {
        Minas juego = new Minas(2,2);
        juego.cargarBombas11();
        boolean obtenido = juego.esBomba(1,0);
        boolean esperado = false;
        assertEquals(esperado,obtenido);    
    }   
    
    @Test
    public void testJuego3por3casillaCercaDeUnaBomba1() {
        Minas juego = new Minas(3,3);
        juego.cargarBombasJuntas(1,0,0);
        int obtenido = juego.abrirJugada(0,0);
        int esperado = 1;
        assertEquals(esperado,obtenido);    
    }
    
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

}
