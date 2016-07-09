package Tablero;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author 
 */
public class TableroInicialTest {

    @Test
    public void testGenerarNroMinas() {
        TableroInicial tablero = new TableroInicial(4, 4, 50);
        int nroEsperado = tablero.getListaMinas().size();
        Assert.assertEquals(8, nroEsperado);
    }

    @Test
    public void testGenerarTableroAleatorio() {
        TableroInicial tablero = new TableroInicial(4, 4, 25);
        int[][] tableroInicial = tablero.getTableroInicial();
        ArrayList<Posicion> listaMinas = tablero.getListaMinas();
        int nroMinas = listaMinas.size();
        int[][] tableroEsperado = new int[4][4];
        for (Posicion p : listaMinas) {
            tableroEsperado[p.getFila()][p.getColumna()] = -1;
        }
        Assert.assertArrayEquals(tableroEsperado, tableroInicial);
    }

}
