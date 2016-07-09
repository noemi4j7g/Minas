package juego;

import Tablero.Celda;
import Tablero.Tablero;

/**
 *
 * @author 
 */
public class MarcarRecursivo {

    private int recursivo;
    private Tablero tablero;
    private int filas;
    private int columnas;

    public int descubrirRecursivo(int fil, int col, Tablero tablero) {
        recursivo = 0;
        filas = tablero.getTableroInicial().length;
        columnas = tablero.getTableroInicial()[0].length;
        this.tablero = tablero;
        descubrir(fil, col);
        return recursivo;
    }

    private void descubrir(int fila, int col) {
        for (int i = Math.max(0, fila - 1); i <= Math.min(filas - 1, fila + 1); i++) {
            for (int j = Math.max(0, col - 1); j <= Math.min(columnas - 1, col + 1); j++) {
                Celda celda = tablero.getCelda(i, j);
                if (celda.getTipo() == 0 && !celda.estaMarcado()) {
                    celda.marcarCelda();
                    recursivo++;
                    descubrir(i, j);
                }
                if (celda.getTipo() >= 1 && !celda.estaMarcado()) {
                    celda.marcarCelda();
                    recursivo++;
                }
            }
        }
    }
}
