package Tablero;

import java.util.ArrayList;

/**
 *
 * @author 
 */
public class Tablero {

    private Celda[][] tableroJuego;
    private int[][] tableroInicial;
    private ArrayList<Posicion> listaMinas;

    public Tablero(int fila, int col, int porcentaje) {
        if(!tableroValido(fila, col)){
            fila = 1;
            col=1;
        }
        tableroJuego = new Celda[fila][col];
        tableroInicial = new int[fila][col];
        TableroInicial tabInit = new TableroInicial(fila, col, porcentaje);
        tableroInicial = tabInit.getTableroInicial();
        tableroJuego = new TableroLleno(tableroInicial).getTableroJuego();
        listaMinas = tabInit.getListaMinas();
    }

    public Tablero(int[][] inicial) {
        tableroInicial = inicial.clone();
        tableroJuego = new TableroLleno(tableroInicial).getTableroJuego();
        listaMinas = new ListaMinas(inicial).getListaMinas();
    }

    public Celda getCelda(int fila, int col) {
        return tableroJuego[fila][col];
    }

    public int[][] getTableroInicial() {
        return tableroInicial.clone();
    }

    public ArrayList<Posicion> getListaMinas() {
        return listaMinas;
    }

    public void mostrarMinas() {
        for (Posicion p : listaMinas) {
            getCelda(p.getFila(), p.getColumna()).marcarCelda();
        }
    }

    private boolean tableroValido(int fila, int col){
        return (fila>0&&fila<=500 && col>0&&col<=500);
    }
}
