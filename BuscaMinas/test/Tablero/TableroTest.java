
package Tablero;

import org.junit.Assert;
import org.junit.Test;
/**
 *
 * @author
 */
public class TableroTest {
    
    @Test
    public void testMarcar1x1sinBomba() {
        Tablero tablero = new Tablero(1,1,0);
        Celda celda = tablero.getCelda(0, 0);
        celda.marcarCelda();
        boolean estaMarcado = celda.estaMarcado();
        int tieneBomba = celda.getTipo();
        Assert.assertTrue(estaMarcado);
        Assert.assertNotSame(tieneBomba,-1);
    }
    
    @Test
    public void testMarcar1x1conBomba() {
        Tablero tablero = new Tablero(1,1,100);
        Celda celda = tablero.getCelda(0, 0);
        celda.marcarCelda();
        boolean estaMarcado = celda.estaMarcado();
        int tieneBomba =  celda.getTipo();
        Assert.assertTrue(estaMarcado);
        Assert.assertEquals(-1,tieneBomba);
    }
    
    @Test
    public void testMarcar2x2sinBomba() {
        Tablero tablero = new Tablero(2,2,0);
        boolean estaMarcado = true;
        boolean tieneBomba = false;
        for(int fila=0; fila<2;fila++){
            for(int col=0; col<2;col++){
                Celda celda = tablero.getCelda(fila, col);
                celda.marcarCelda();
                estaMarcado &= celda.estaMarcado();
                tieneBomba |=(celda.getTipo()==-1) ;
            }
        }
        Assert.assertTrue(estaMarcado);
        Assert.assertFalse(tieneBomba);
    }
    
    @Test
    public void testMarcar2x2conBomba() {
        Tablero tablero = new Tablero(2,2,25);
        boolean estaMarcado = true;
        boolean tieneBomba = false;
        for(int fila=0; fila<2;fila++){
            for(int col=0; col<2;col++){
                Celda celda = tablero.getCelda(fila, col);
                celda.marcarCelda();
                estaMarcado &= celda.estaMarcado();
                tieneBomba |=(celda.getTipo()==-1) ;
            }
        }
        Assert.assertTrue(estaMarcado);
        Assert.assertTrue(tieneBomba);
    } 
    
    @Test
    public void testMarcarNxNsinBomba() {
        Tablero tablero = new Tablero(5,4,0);
        boolean estaMarcado = true;
        boolean tieneBomba = false;
        for(int fila=0; fila<5;fila++){
            for(int col=0; col<4;col++){
                Celda celda = tablero.getCelda(fila, col);
                celda.marcarCelda();
                estaMarcado &= celda.estaMarcado();
                tieneBomba |=(celda.getTipo()==-1) ;
            }
        }
        Assert.assertTrue(estaMarcado);
        Assert.assertFalse(tieneBomba);
    } 
    
    @Test
    public void testMarcarNxNconBomba() {
        Tablero tablero = new Tablero(10,4,50);
        boolean estaMarcado = true;
        boolean tieneBomba = false;
        for(int fila=0; fila<5;fila++){
            for(int col=0; col<4;col++){
                Celda celda = tablero.getCelda(fila, col);
                celda.marcarCelda();
                estaMarcado &= celda.estaMarcado();
                tieneBomba |=(celda.getTipo()==-1) ;
            }
        }
        Assert.assertTrue(estaMarcado);
        Assert.assertTrue(tieneBomba);
    }
}
