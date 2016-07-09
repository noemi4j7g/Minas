package Tablero;

import java.util.ArrayList;

/**
 *
 * @author 
 */
public class ListaMinas {

    private ArrayList<Posicion> listaMinas;
    private int[][] tablero;

    public ListaMinas(int[][] tablero) {
        listaMinas = new ArrayList<Posicion>();
        this.tablero = tablero;
        generarListas();
    }

    public ArrayList<Posicion> getListaMinas() {
        return (ArrayList<Posicion>) listaMinas.clone();
    }

    private void generarListas() {
        for (int fila = 0; fila < tablero.length; fila++) {
            for (int col = 0; col < tablero[0].length; col++) {
                Posicion pos = new Posicion(fila, col);
                if (tablero[fila][col] == -1) {
                    listaMinas.add(pos);
                }
            }
        }
    }
}
