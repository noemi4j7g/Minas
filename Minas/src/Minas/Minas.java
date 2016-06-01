package Minas;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author arquitectura de software I 2016
 */
public class Minas {

    int[][] tablero;
    String[][] tableroJugador;
    int casillasJugadas;
    int tamanio;
    int bombas;
    int altura;
    int ancho;
    ValidadorTablero validador;
    TableroMinas myTableroDeNinas;
    
    private static final int BOMBA_VALOR = -1;

    public Minas(int alturaT, int anchoT) {
        altura = alturaT;
        ancho = anchoT;
        tamanio = altura * ancho;
        casillasJugadas = 0;
        if (tamanio > 0) {
            tablero = new int[altura][ancho];
            tableroJugador = new String[altura][ancho];
        } else {
            System.out.println("Tamaño no valido,el tamaño debe ser entero positivo ");
        }
        validador = new ValidadorTablero();
        validador.copiarTamanioTablero(altura, ancho);
        myTableroDeNinas = new TableroMinas(alturaT, anchoT);
    }

    public void cargarUnNumeroDeBombas(int numeroBombas) {
        if (numeroBombas > tamanio * 0.8) {
            System.out.println("El tablero es pequeño para el numero de Bombas");
        } else {
            tablero = myTableroDeNinas.cargarUnNumeroDeBombas(numeroBombas);
        }
       
    }

    public int[][] copiarTablero() {
        return tablero.clone();
    }

    private int abrirCasilla(int x, int y) {
        return tablero[x][y];
    }

    public boolean esBomba(int x, int y) {
        return abrirCasilla(x, y) == BOMBA_VALOR;
    }

    private void cargarBombaEnCoordenadas(int x, int y) {
        tablero[x][y] = BOMBA_VALOR;
    }

    public boolean continuarJuego() {
        return (casillasJugadas < tamanio - bombas);
    }

    public void cargarBombas11() {
        cargarBombaEnCoordenadas(0, 0);
    }
}
