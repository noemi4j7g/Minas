package juego;

import Tablero.Tablero;

/**
 *
 * @author 
 */
public class MarcarCelda {

    private Tablero tablero;
    private MarcarRecursivo marcarRecursivo;

    public int marcarCelda(int fila, int col, Tablero tablero) {
        int celdasMarcadas = 0;
        this.tablero = tablero;
        if (validarPosicion(fila, col)) {
            marcarRecursivo = new MarcarRecursivo();
            int tipo = tablero.getCelda(fila, col).getTipo();
            switch (tipo) {
                case -1:
                    celdasMarcadas = -1;
                    break;
                case 0:
                    celdasMarcadas = marcarRecursivo.descubrirRecursivo(fila, col, tablero);
                    break;
                default:
                    celdasMarcadas = 1;
                    tablero.getCelda(fila, col).marcarCelda();
                    break;
            }
        }
        return celdasMarcadas;
    }

    private boolean validarPosicion(int f, int c) {
        boolean valido = false;
        int fila = tablero.getTableroInicial().length;
        int col = tablero.getTableroInicial()[0].length;
        if (f>=0&&f<fila && c>=0&&c<col) {
            if (!tablero.getCelda(f, c).estaMarcado()) {
                valido = true;
            }
        }
        return valido;
    }
}
