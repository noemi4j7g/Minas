
import Minas.CasillasJuntasVacias;
import java.util.Arrays;
import static org.junit.Assert.assertArrayEquals;
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
public class CasillasJuntasTest {
    @Test
    public void cargarUnTablero1por1sinbomba() {
        
        int [][] tablero = { {0} };
        boolean [][] obtenido = CasillasJuntasVacias.casillaV(0, 0,  tablero);
        boolean [][] esperado = new boolean[1][1];
        esperado[0][0]= Boolean.TRUE;
        assertArrayEquals(esperado,obtenido);    
    }
    @Test
    public void cargarUnTablero2por2conbomba() {
        
        int [][] tablero = { {0,0}, {0,-1}};
        boolean [][] obtenido = CasillasJuntasVacias.casillaV(0, 0,  tablero);
        boolean [][] esperado = new boolean[2][2];
        esperado[0][0]= Boolean.TRUE;
        esperado[0][1]= Boolean.TRUE;
        esperado[1][0]= Boolean.TRUE;
        assertArrayEquals(esperado,obtenido);    
    }
    @Test
    public void cargarUnTablero3por3con2bomba() {
        
        int [][] tablero = { {0,0,0}, {0,0,-1}, {0,0,-1}};
        boolean [][] obtenido = CasillasJuntasVacias.casillaV(2, 2,  tablero);
        boolean [][] esperado = new boolean[3][3];      
        assertArrayEquals(esperado,obtenido);    
    }
        @Test
    public void cargarUnTablero3por3bombas() {
        
        int [][] tablero = { {1,-1,2}, {1,2,-1}, {0,1,1}};
        boolean [][] obtenido = CasillasJuntasVacias.casillaV(2,0,  tablero);
        boolean [][] esperado = new boolean[3][3];      
        esperado[1][0]= Boolean.TRUE;
        esperado[2][0]= Boolean.TRUE;
        esperado[2][1]= Boolean.TRUE;      
        assertArrayEquals(esperado,obtenido);    
    }
}
