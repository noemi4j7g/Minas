package Minas;

import static Minas.JuegoBuscaminaConsola.tableroMain;

/**
 *
 * @author arquitectura de software I 2016
 */
public class Juego {

    private static boolean terminoJuego;
    int[][] tablero;
    String[][] tableroJugador;
    private final TableroMinas miJuego;
    public static int casillasJugadas;
    private static int alturaTablero;
    private static int anchoTablero;
    private static int nBombas;
    ImprimirTableroConsola ImprimirT;  
    private static CoordenadasPorConsola coordConsola;
    private static final int BOMBA_VALOR = -1;
    private TableroBombasJuntas tableroConCalculos;
    
    public Juego(int alturaT, int anchoT, int nBombasT) {
        alturaTablero = alturaT;
        anchoTablero = anchoT;
        nBombas = nBombasT;        
        tableroConCalculos= new TableroBombasJuntas();
        miJuego = new TableroMinas(alturaTablero, anchoTablero);
        miJuego.cargarUnNumeroDeBombas(nBombas);        
        tablero = miJuego.copiarTableroMinas();
        tablero=tableroConCalculos.calcularNumeroDeBombasJuntas(tablero);
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
    public  void jugarMinas() {
        boolean encontroBomba;
        int jugada[];
        int jX;
        int jY;
       
        tableroMain=optenerTablero();
        tableroJugador = new String[alturaTablero][anchoTablero];
        coordConsola= new CoordenadasPorConsola(alturaTablero, anchoTablero);
        encontroBomba = false;
        System.out.println("------------ Juego busca minas ----------- \n Para salir del jugo pressione 0 ");
        while (encontroBomba == false) {
            jugada = coordConsola.preguntarJugada();
            jX = jugada[0];
            jY = jugada[1];       
            tableroJugador[jX][jY]= Integer.toString(tableroMain[jX][jY]);
            encontroBomba = tableroMain[jX][jY] ==BOMBA_VALOR;
            regitrarJugada();
            calcularCasillasPorAbrir();
            if (terminoJuego()) {
                System.out.println("termino ");
              
            }
            ImprimirT.imprimitTableroJugador(tableroJugador.clone());
        }        
        terminarJuego();
        ImprimirT.imprimitTablero(tableroMain.clone());
    }
}
