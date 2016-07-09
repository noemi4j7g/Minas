
package InterfazConsola;

import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author 
 */
public class PrintConsolaTest {

    @Test
    public void testIsNumber() {
        String num = "12331";
        String notNum = "213,54+";

        PrintConsola consola= new PrintConsola();

        boolean esNumero = consola.isNumber(num);
        boolean noNumero = consola.isNumber(notNum);
        Assert.assertTrue(esNumero);
        Assert.assertFalse(noNumero);

    }

    @Test
    public void testDatosValidos() {
        String datosValidos = "62 32";
        String datosInvalidos = "213,54+ ds" ;

        PrintConsola consola= new PrintConsola();

        boolean esValido = consola.datosValidos(datosValidos);
        boolean noValido = consola.datosValidos(datosInvalidos);
        Assert.assertTrue(esValido);
        Assert.assertFalse(noValido);

    }

}
