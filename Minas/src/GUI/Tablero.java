package GUI;

import Minas.CasillasJuntasVacias;
import Minas.Juego;
import Minas.ValidadorTablero;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Noemi Guzman
 */
public class Tablero extends javax.swing.JPanel {

   
    ValidadorTablero validador;
    private static int anchoTablero;
    private static int altoTablero;
    private int nBombas;
    Juego juegoMinas;
    static int[][] tableroEnJuego;
    static Casilla tJuego[][];
    CasillasJuntasVacias casillasVacias;

    public Tablero(int alturaT, int anchoT, int nbombasT) {
        removeAll();
        anchoTablero = anchoT;
        altoTablero = alturaT;
        nBombas = nbombasT;
        System.out.println("Crear Tablero: Alto " + String.valueOf(alturaT) + " anchos " + String.valueOf(anchoT) + " Bombas " + String.valueOf(nbombasT));
        juegoMinas = new Juego(altoTablero, anchoTablero, nBombas);
        tableroEnJuego = juegoMinas.optenerTablero();
        setPanelTablero();
        mapearTablero();
        System.out.println("cargando el tablero");
    }

    private void mapearTablero() {
        tJuego = new Casilla[altoTablero][anchoTablero];
        for (int fila = 0; fila < altoTablero; fila++) {
            for (int col = 0; col < anchoTablero; col++) {
                tJuego[fila][col] = new Casilla(fila, col);
                tJuego[fila][col].setValor(tableroEnJuego[fila][col]);
                this.add(tJuego[fila][col]);
            }
        }
        this.setVisible(true);
    }

    private void setPanelTablero() {
        this.removeAll();
        this.setLayout(new java.awt.GridLayout(altoTablero, anchoTablero));
    }

    public static void terminaJuego() {
        for (int fila = 0; fila < altoTablero; fila++) {
            for (int col = 0; col < anchoTablero; col++) {
                tJuego[fila][col].mostrarJugador();
            }
        }
    }
    public static void abrirCasillaVacias(int x, int y) {
        boolean[][] tableroV = CasillasJuntasVacias.casillaV(x, y, altoTablero, anchoTablero, tableroEnJuego);
        for (int fila = 0; fila < altoTablero; fila++) {
            for (int col = 0; col < anchoTablero; col++) {
                if (tableroV[fila][col]) {
                    tJuego[fila][col].mostrarJugador();
                    Juego.regitrarJugada();
                }
            }
        }
    }
}
