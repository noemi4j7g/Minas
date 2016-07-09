package Tablero;

/**
 *
 * @author 
 */
public class TableroLleno {

    private int[][] tableroLleno;
    private int[][] tableroInicial;
    private Celda[][] tableroJuego;

    public TableroLleno(int[][] tableroInicial) {
        tableroLleno = new int[tableroInicial.length][tableroInicial[0].length];
        tableroJuego = new Celda[tableroInicial.length][tableroInicial[0].length];
        this.tableroInicial = tableroInicial;
        generarTableroLleno();
        generarTableroJuego();
    }

    public int[][] getTableroLleno() {
        return tableroLleno;
    }

    public Celda[][] getTableroJuego() {
        return tableroJuego;
    }

    private void generarTableroLleno() {
        for (int fila = 0; fila < tableroInicial.length; fila++) {
            for (int col = 0; col < tableroInicial[0].length; col++) {
                if (tableroInicial[fila][col] == -1) {
                    llenarPerimetro(fila, col);
                }
            }
        }
    }

    private void llenarPerimetro(int fila, int col) {
        for (int i = Math.max(0, fila - 1); i <= Math.min(tableroInicial.length - 1, fila + 1); i++) {
            for (int j = Math.max(0, col - 1); j <= Math.min(tableroInicial[0].length - 1, col + 1); j++) {
                if (tableroInicial[i][j] == -1) {
                    tableroLleno[i][j] = -1;
                } else {
                    tableroLleno[i][j] += 1;
                }
            }
        }
    }

    private void generarTableroJuego() {
        for (int fila = 0; fila < tableroLleno.length; fila++) {
            for (int col = 0; col < tableroLleno[0].length; col++) {
                tableroJuego[fila][col] = new Celda(tableroLleno[fila][col]);
            }
        }
    }
}
