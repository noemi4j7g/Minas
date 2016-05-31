package Minas;

import java.util.Random;

/**
 *
 * @author Noemi Guzman
 */
public class TableroMinas {

    private int[][] tableroM;
    ValidadorTablero validador;
    private int altura;
    private int ancho;
    private double tamanio;
    private static final int BOMBA_VALOR = -1;

    TableroMinas(int alturaT, int anchoT) {
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
            System.out.println("El tablero es pequeño para el numero de Bombas");
        } else {
            cargarBombasAleatorias(numeroBombas);
            calcularNumeroDeBombasJuntas();
        }
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
            coordX = randomGenerator.nextInt(altura - 1);
            coordY = randomGenerator.nextInt(ancho - 1);
        } while (esBomba(coordX, coordY) != false);
        return new int[]{coordX, coordY};

    }

    private void calcularNumeroDeBombasJuntas() {
        for (int coordX = 0; coordX <= altura - 1; coordX++) {
            for (int coordY = 0; coordY <= ancho - 1; coordY++) {
                if (!esBomba(coordX, coordY)) {
                    calcularBombasJuntasPorCasilla(coordX, coordY);
                }
            }
        }
    }

    private void calcularBombasJuntasPorCasilla(int x, int y) {
        int bombasSerca;
        bombasSerca = 0;
        int maxMinX[] = validador.optenerMaxMinX(x);
        int maxMinY[] = validador.optenerMaxMinY(y);

        for (int coordX = maxMinX[1]; coordX <= maxMinX[0]; coordX++) {
            for (int coordY = maxMinY[1]; coordY <= maxMinY[0]; coordY++) {
                if (esBomba(coordX, coordY)) {
                    bombasSerca += 1;
                }
            }
        }
        tableroM[x][y] = bombasSerca;
    }
    public int[][] cargarBombasJuntas(int bombasACargar, int x, int y) {
        int maxMinX[] = validador.optenerMaxMinX(x);
        int maxMinY[] = validador.optenerMaxMinY(y);

        for (int coordX = maxMinX[1]; coordX <= maxMinX[0]; coordX++) {
            for (int coordY = maxMinY[1]; coordY <= maxMinY[0]; coordY++) {
                if (bombasACargar > 0 && (coordX == x && coordY == y) == false) {
                    cargarBombaEnCoordenadas(coordX, coordY);
                    bombasACargar -= 1;
                }
                if (bombasACargar == 0) {
                    break;

                }
            }
        }
        calcularBombasJuntasPorCasilla(x, y);
        return tableroM.clone();
    }
  
    public boolean esBomba(int x, int y) {
        return abrirCasilla(x, y) == BOMBA_VALOR;
    }

    private void cargarBombaEnCoordenadas(int x, int y) {
        tableroM[x][y] = BOMBA_VALOR;
    }

    private int abrirCasilla(int x, int y) {
        return tableroM[x][y];
    }
 
}
