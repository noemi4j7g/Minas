package Minas;

import static java.lang.Integer.max;
import java.util.Random;

/**
 *
 * @author arquitectura de software I 2016
 */
public class TableroMinas {

    private int[][] tableroM;
    ValidadorTablero validador;

    private int altura;
    private int ancho;
    private double tamanio;
    private static final int BOMBA_VALOR = -1;    
    ImprimirTableroConsola ImprimirT; 

    public TableroMinas(int alturaT, int anchoT) {
        altura = alturaT;
        ancho = anchoT;
        tamanio = altura * ancho;
        tableroM = new int[altura][ancho];                
        validador = new ValidadorTablero();
        validador.copiarTamanioTablero(altura, ancho);
        
    }
    public int[][] copiarTableroMinas() {
        return tableroM.clone();
    }
    public int[][] cargarUnNumeroDeBombas(int numeroBombas) {
        if (numeroBombas > tamanio * 0.8) {
            throw new UnsupportedOperationException("El tablero es pequeño para el numero de Bombas.");

        } else {
            cargarBombasAleatorias(numeroBombas);
    
        }
        ImprimirT.imprimitTablero(tableroM.clone());
        return tableroM.clone();
    }
    private void cargarBombasAleatorias(int numeroBombas) {
        int bombasCargadas;
        bombasCargadas = 0;
        while (bombasCargadas < numeroBombas) {
            int casillaXY[] = optenerCasillaEnBlanco();
            cargarBombaEnCoordenadas(casillaXY[0], casillaXY[1]);
            bombasCargadas += 1;
        }       

    }
    private int[] optenerCasillaEnBlanco() {
        int coordX;
        int coordY;
        Random randomGenerator = new Random();
        do {
            coordX = randomGenerator.nextInt(max(altura - 1, 1));
            coordY = randomGenerator.nextInt(max(ancho - 1, 1));
        } while (esBomba(coordX, coordY) != false);
        return new int[]{coordX, coordY};
        
    }  
  
    private boolean esBomba(int x, int y) {
        return abrirCasilla(x, y) == BOMBA_VALOR;
    }

    private void cargarBombaEnCoordenadas(int x, int y) {
        tableroM[x][y] = BOMBA_VALOR;
    }

    private int abrirCasilla(int x, int y) {
        return tableroM[x][y];
    }
 
}
