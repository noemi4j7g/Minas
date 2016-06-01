
package Minas;

/**
 *
 * @author arquitectura de software I 2016
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
        validador.copiarTamanioTablero(tableroBJ.length, tableroBJ[0].length);
        for (int coordX = 0; coordX <tableroBJ.length ; coordX++) {
            for (int coordY = 0; coordY < tableroBJ[coordX].length; coordY++) {
                if (tableroBJ[coordX][coordY] != BOMBA_VALOR) {
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
