
import Minas.Minas;
import Minas.TableroMinas;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Noemi Guzman
 */
public class TableroMinasTest {
    @Test
    public void testJuego6por6casillaCargar5Bombas() {
        Minas juego = new Minas(6,6);
        juego.cargarUnNumeroDeBombas(5);
        int obtenido = juego.contadorBombas();
        int esperado = 5;
        assertEquals(esperado,obtenido);    
    }
    @Test
    public void testJuego6por6casillaTratardeCargarMas80porciento() {
        Minas juego35 = new Minas(6,6);
        juego35.cargarUnNumeroDeBombas(35);
        int obtenido = juego35.contadorBombas();
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
    public void testJuego6por6casillaTiene1BombaCerca() {
        Minas juego = new Minas(6,6);
        juego.cargarBombasJuntas(1,3,2);
        int obtenido = juego.contadorBombas();
        int esperado = 1;
        assertEquals(esperado,obtenido);    
    } 
    @Test
    public void testJuego6por6casillaTiene6BombasCercaBombaEncontrada() {
        Minas juego = new Minas(6,6);
        juego.cargarBombasJuntas(6,3,2);
        boolean obtenido = juego.esBomba(3,3);
        boolean esperado = true;
        assertEquals(esperado,obtenido);    
    }
    @Test
    public void testJuego6por6casillaTiene0BombasCercaNoBombaEncontrada() {
        Minas juego = new Minas(6,6);
        juego.cargarBombasJuntas(0,3,2);
        boolean obtenido = juego.esBomba(3,3);
        boolean esperado = false;
        assertEquals(esperado,obtenido);    
    }
}
