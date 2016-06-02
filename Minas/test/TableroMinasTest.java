
import Minas.TableroMinas;
import java.util.stream.IntStream;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 *
 * @author Noemi Guzman
 */
public class TableroMinasTest {
    @Test
    public void cargarUnTablero1por1sinbomba() {
        TableroMinas juego = new TableroMinas(1,1); 
        int [][] obtenido = juego.cargarUnNumeroDeBombas(0);
        int [][] esperado = { {0} };
        assertArrayEquals(esperado,obtenido);    
    }
    @Test
    public void cargarUnTablero2por2sinbomba() {
        TableroMinas juego = new TableroMinas(2,2); 
        int [][] obtenido = juego.cargarUnNumeroDeBombas(0);
        int [][] esperado = { {0,0}, {0,0}};
        assertArrayEquals(esperado,obtenido);   
    }
    @Test
    public void cargarUnTablero2por2conbomba() {
        TableroMinas juego = new TableroMinas(1,2); 
        int [][] tablero = juego.cargarUnNumeroDeBombas(1);
        int sum = IntStream.of(tablero[0]).sum();        
        assertEquals(-1,sum);   
    }
    
    @Test
    public void testTablero6por6Tiene5Bombas() {
        int sum = 0;
        TableroMinas juego = new TableroMinas(6,6); 
        int [][] tablero = juego.cargarUnNumeroDeBombas(5);     
        for(int[] i: tablero) {
            sum += IntStream.of(i).sum(); ;
        }
        assertEquals(-5,sum);    
    }
    @Test
    public void testCopiarTableroSinBombas() {
        
        TableroMinas juego = new TableroMinas(6,2); 
        int [][] obtenido = juego.copiarTableroMinas();  
        int [][] esperado = { {0,0}, {0,0}, {0,0}, {0,0}, {0,0}, {0,0}};        
        assertArrayEquals(esperado,obtenido);    
    }

}
