
import Minas.ValidadorTablero;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Tests for @link{ValidadorTablero} class
 *
 * @author arquitectura de software I 2016
 */
public class ValidadorTest {

    @Test
    public void testValidadorTamanio0() {
        ValidadorTablero validador = new ValidadorTablero();
        int obtenido = validador.validarTamanio("0");
        int esperado = 9;
        assertEquals(esperado, obtenido);
    }
    @Test
    public void testValidadorTamanioMenor9() {
        ValidadorTablero validador = new ValidadorTablero();
        int obtenido = validador.validarTamanio("6");
        int esperado = 9;
        assertEquals(esperado, obtenido);
    }
    @Test
    public void testValidadorTamanioMayor24() {
        ValidadorTablero validador = new ValidadorTablero();
        int obtenido = validador.validarTamanio("25");
        int esperado = 24;
        assertEquals(esperado, obtenido);
    }
    @Test
    public void testValidadorTamanioNoInt() {
        ValidadorTablero validador = new ValidadorTablero();
        int obtenido = validador.validarTamanio("25sss");
        int esperado = 9;
        assertEquals(esperado, obtenido);
    }
    @Test
    public void testValidadorTamanioVacio() {
        ValidadorTablero validador = new ValidadorTablero();
        int obtenido = validador.validarTamanio("");
        int esperado = 9;
        assertEquals(esperado, obtenido);
    }
    @Test
    public void testNumeroBombasMenos10default() {
        ValidadorTablero validador = new ValidadorTablero();
        int obtenido = validador.validarNumeroBombas("5",91);
        int esperado = 10;
        assertEquals(esperado, obtenido);
    }
    @Test
    public void testNumeroBombasmayor80default() {
        ValidadorTablero validador = new ValidadorTablero();
        int obtenido = validador.validarNumeroBombas("900",91);
        int esperado = 72;
        assertEquals(esperado, obtenido);
    }
}
