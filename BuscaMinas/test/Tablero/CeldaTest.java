package Tablero;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author 
 */
public class CeldaTest {

    @Test
    public void testGetContenido() {
        Celda celdaBomba = new Celda(-1);
        Celda celdaVacia = new Celda(0);
        Celda celda1 = new Celda(1);
        Celda celda2 = new Celda(2);
        Celda celda3 = new Celda(3);
        Celda celda4 = new Celda(4);
        Celda celda5 = new Celda(5);
        Celda celda6 = new Celda(6);
        Celda celda7 = new Celda(7);
        Celda celda8 = new Celda(8);
        Celda celda9 = new Celda(9);
        
        celdaBomba.marcarCelda();
        celdaVacia.marcarCelda();
        celda1.marcarCelda();
        celda2.marcarCelda();
        celda3.marcarCelda();
        celda4.marcarCelda();
        celda5.marcarCelda();
        celda6.marcarCelda();
        celda7.marcarCelda();
        celda8.marcarCelda();
        celda9.marcarCelda();
        
        
        
        Assert.assertEquals("*", celdaBomba.getContenido());
        Assert.assertEquals(" ", celdaVacia.getContenido());
        Assert.assertEquals("1", celda1.getContenido());
        Assert.assertEquals("2", celda2.getContenido());
        Assert.assertEquals("3", celda3.getContenido());
        Assert.assertEquals("4", celda4.getContenido());
        Assert.assertEquals("5", celda5.getContenido());
        Assert.assertEquals("6", celda6.getContenido());
        Assert.assertEquals("7", celda7.getContenido());
        Assert.assertEquals("8", celda8.getContenido());
        Assert.assertEquals("9", celda9.getContenido());
    }

    @Test
    public void testClone() {
        Celda celda = new Celda(5);
        Celda celdaClone = celda.clone();
        int tipoEsperado = celda.getTipo();
        String contenidoEsperado = celda.getContenido();
        boolean esMarcadoEsperado = celda.estaMarcado();

        Assert.assertEquals(tipoEsperado, celdaClone.getTipo());
        Assert.assertEquals(contenidoEsperado, celdaClone.getContenido());
        Assert.assertEquals(esMarcadoEsperado, celdaClone.estaMarcado());
    }
}
