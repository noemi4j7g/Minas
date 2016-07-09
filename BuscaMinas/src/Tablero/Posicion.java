package Tablero;

/**
 *
 * @author 
 */
public class Posicion {

    private int fila;
    private int columna;

    public Posicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (o == this) {
            return true;
        } else if (!(o instanceof Posicion)) {
            return false;
        } else {
            Posicion p = (Posicion) o;
            if (fila == p.fila && columna == p.columna) {
                return true;
            } else {
                return false;
            }
        }
    }
}
