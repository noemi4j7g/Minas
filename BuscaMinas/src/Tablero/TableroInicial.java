package Tablero;

import java.util.ArrayList;

/**
 *
 * @author 
 */
public class TableroInicial {

    private int[][] tableroInicial;
    private int nroMinas;
    private int nroCeldas;
    private ArrayList<Posicion> listaMinas;

    public TableroInicial(int fila, int col, int porcentaje) {
        tableroInicial = new int[fila][col];
        listaMinas = new ArrayList<>();
        nroCeldas = fila * col;
        generarNroMinas(porcentaje);
        generarTableroInicial();
    }

    public int[][] getTableroInicial() {
        return tableroInicial.clone();
    }

    public ArrayList<Posicion> getListaMinas() {
        return (ArrayList<Posicion>) listaMinas.clone();
    }

    private void generarNroMinas(int porcentaje) {
        if (porcentaje >= 0 && porcentaje <= 100) {
            nroMinas = (nroCeldas * porcentaje) / 100;
        } else {
            nroMinas = 1;
        }
    }

    private void generarTableroInicial() {
        int contMinas = 0;
        while (contMinas < nroMinas) {
            int fil = (int) (Math.random() * tableroInicial.length);
            int col = (int) (Math.random() * tableroInicial[0].length);
            if (tableroInicial[fil][col] == 0) {
                tableroInicial[fil][col] = -1;
                Posicion posicion = new Posicion(fil, col);
                listaMinas.add(posicion);
                contMinas++;
            }
        }
    }
}
