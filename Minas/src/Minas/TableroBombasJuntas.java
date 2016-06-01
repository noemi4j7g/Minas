/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Minas;

/**
 *
 * @author Noemi Guzman
 */
class TableroBombasJuntas {
    ValidadorTablero validador;        
    private int[][] tableroBJ;
    private static final int BOMBA_VALOR = -1;

    public TableroBombasJuntas() {
        validador = new ValidadorTablero();
    }

    
    public int[][] calcularNumeroDeBombasJuntas(int[][] tablero) {
        tableroBJ=tablero.clone();
        for (int coordX = 0; coordX <= tableroBJ.length - 1; coordX++) {
            for (int coordY = 0; coordY <= tableroBJ[coordX].length- 1; coordY++) {
                if (tableroBJ[coordX][coordY] == BOMBA_VALOR) {
                    calcularBombasJuntasPorCasilla(coordX, coordY);
                }
            }
        }
        return tableroBJ.clone();
    }

    private void calcularBombasJuntasPorCasilla(int x, int y) {
        int bombasSerca;
        bombasSerca = 0;
        int maxMinX[] = validador.optenerMaxMinX(x);
        int maxMinY[] = validador.optenerMaxMinY(y);

        for (int coordX = maxMinX[1]; coordX <= maxMinX[0]; coordX++) {
            for (int coordY = maxMinY[1]; coordY <= maxMinY[0]; coordY++) {
                if (tableroBJ[coordX][coordY] == BOMBA_VALOR) {
                    bombasSerca += 1;
                }
            }
        }
        tableroBJ[x][y] = bombasSerca;
    }
}
