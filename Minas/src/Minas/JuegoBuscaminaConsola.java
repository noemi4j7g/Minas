package Minas;

import java.util.Scanner;
/**
 *
 * @author arquitectura de software I 2016
 */
public class JuegoBuscaminaConsola {

    private static CoordenadasPorConsola coordConsola;
    private static Juego miMina;
    private static int alto;
    private static int ancho;
    static int[][] tableroMain;
    static String[][] tableroJugador;
    private static final int BOMBA_VALOR = -1;
    
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
    private static void jugarMinas() {
        boolean encontroBomba;
        int jugada[];
        int jX;
        int jY;
        tableroMain=miMina.optenerTablero();
        tableroJugador = new String[alto][ancho];
        encontroBomba = false;
        System.out.println("------------ Juego busca minas ----------- \n Para salir del jugo pressione 0 ");
        while (encontroBomba == false) {
            jugada = coordConsola.preguntarJugada();
            jX = jugada[0];
            jY = jugada[1];       
            tableroJugador[jX][jY]= Integer.toString(tableroMain[jX][jY]);
            encontroBomba = tableroMain[jX][jY] ==BOMBA_VALOR;
            miMina.regitrarJugada();
            miMina.calcularCasillasPorAbrir();
            if (miMina.terminoJuego()) {
                
            }
        }        
        miMina.terminarJuego();
    }

    private static void iniciarJuegoConsola(){
       
    }
    
    public static void main(String[] args) {
        int bombas;       
        alto = preguntaTamanio();      
        ancho = preguntaTamanio();
        bombas = preguntaNumeroBombas();
        coordConsola= new CoordenadasPorConsola(alto, ancho);
        miMina = new Juego(alto, ancho,bombas);        
        iniciarJuegoConsola();
        jugarMinas();
    }

}
