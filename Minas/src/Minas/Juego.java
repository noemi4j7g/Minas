package Minas;

/**
 *
 * @author arquitectura de software I 2016
 */
public class Juego {

    private static boolean terminoJuego;
    int[][] tablero;
    String[][] tableroJugador;
    private final Minas miJuego;
    public static int casillasJugadas;
    private static int alturaTablero;
    private static int anchoTablero;
    private static int nBombas;

    public Juego(int alturaT, int anchoT, int nBombasT) {
        alturaTablero = alturaT;
        anchoTablero = anchoT;
        nBombas = nBombasT;
        miJuego = new Minas(alturaTablero, anchoTablero);
        miJuego.cargarUnNumeroDeBombas(nBombas);
        tablero = miJuego.copiarTablero();
        iniciarJuego();
    }

    public int[][] optenerTablero() {
        return tablero;
    }

    private void iniciarJuego() {
        casillasJugadas = 0;
        terminoJuego = false;
    }

    public static void regitrarJugada() {
        casillasJugadas += 1;
    }

    public static void terminarJuego() {
        terminoJuego = true;
        System.out.println("Perdio el juego");
    }

    public static void calcularCasillasPorAbrir() {
        if ((int) casillasJugadas >= (int) (anchoTablero * alturaTablero - nBombas)) {
            terminoJuego = true;
            System.out.println("jugado completado .....");
        }
        System.out.println("jugada ....." + String.valueOf(casillasJugadas));
    }

    public static boolean terminoJuego() {
        return terminoJuego;
    }
}
