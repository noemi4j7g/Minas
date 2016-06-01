package Minas;

import java.util.Scanner;

/**
 *
 * @author arquitectura de software I 2016
 */
public class JuegoBuscaminaConsola {

    private static CoordenadasPorConsola coordConsola;
   

    private static int preguntaTamanio() {
        return preguntarPorEntero("Ingrese el taño de tablero que desee jugar");
    }

    private static int preguntaNumeroBombas() {
        return preguntarPorEntero("Ingrese el numero de bombas");
    }

    private static int preguntarPorEntero(String Pregunta) {
        int tamanio;
        boolean entradaValida;
        tamanio = 1;
        entradaValida = false;
        System.out.println(Pregunta);
        while (!entradaValida) {
            Scanner entrada = new Scanner(System.in);
            if (esInteger(entrada)) {
                entradaValida = true;
                tamanio = entrada.nextInt();
            } else {
                System.out.println("No has ingresado un intero");
            }
        }
        return tamanio;
    }

    private static boolean esInteger(Scanner entrada) {
        return (entrada.hasNextInt());
    }
    public void jugarMinas() {
        boolean encontroBomba;
        int jugada[];
        int jugadaX;
        int jugadaY;
        encontroBomba = false;
        System.out.println("------------ Juego busca minas ----------- \n Para salir del jugo pressione 0 ");
        while (encontroBomba == false) {
            jugada = coordConsola.preguntarJugada();
            jugadaX = jugada[0];
            jugadaY = jugada[1];
            abrirJugada(jugadaX, jugadaY);
            encontroBomba = miMina.esBomba(jugadaX, jugadaY);
        }
       // imprimitTablero("Admin");
    }

    public int abrirJugada(int x, int y) {
        int casilla;
        casilla = abrirCasilla(x, y);
        String[][] tableroJugador;
        tableroJugador[x][y] = Integer.toString(casilla);
        return casilla;
    }
    public static void main(String[] args) {
        int tamanio;
        int bombas;
        int alto;
        int ancho;
        alto = preguntaTamanio();
      
        ancho = preguntaTamanio();
        bombas = preguntaNumeroBombas();
        coordConsola= new CoordenadasPorConsola(alto, ancho);
        Minas miMina = new Minas(alto, ancho);
        miMina.cargarUnNumeroDeBombas(bombas);
        jugarMinas();
    }

}
