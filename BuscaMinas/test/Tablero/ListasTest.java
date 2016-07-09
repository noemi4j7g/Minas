
package Tablero;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author 
 */
public class ListasTest {

    @Test
    public void testGetListaMinas() {
        int[][] tableroLleno = {{-1, 1, 0, 0},
                                { 2, 3, 1, 1},
                                {-1, 2,-1, 2},
                                { 1, 2, 2,-1}};
        ArrayList<Posicion> listaMinasEsperada = new ArrayList<Posicion>();
        listaMinasEsperada.add(new Posicion(0,0));
        listaMinasEsperada.add(new Posicion(2,0));
        listaMinasEsperada.add(new Posicion(2,2));
        listaMinasEsperada.add(new Posicion(3,3));
        ListaMinas listas = new ListaMinas(tableroLleno);
        Assert.assertEquals(listaMinasEsperada, listas.getListaMinas());
    }
    
}
