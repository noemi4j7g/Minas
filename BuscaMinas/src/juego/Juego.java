package juego;

import InterfazConsola.PrintConsola;
import MainJuego.JuegoObservado;
import Tablero.Tablero;

/**
 *
 * @author 
 */
public class Juego extends JuegoObservado{

    Tablero tablero;
    private boolean activo;
    private boolean victoria;
    private int nroCeldasMarcadas;
    private MarcarCelda marcar;
    PrintConsola print;
    

    public Juego(Tablero tablero) {
        marcar = new MarcarCelda();
        this.tablero = tablero;
        activo = true;
        victoria = false;
        nroCeldasMarcadas = 0;
        print = new PrintConsola();
    }

    public boolean getJugando() {
        return activo;
    }

    public boolean esDerrota() {
        return (!activo && !victoria);
    }

    public boolean esVictoria() {
        return victoria;
    }

    public int getNroCeldasMarcadas() {
        return nroCeldasMarcadas;
    }

    public int marcarCelda(int fila, int col) {
        int celdasMarcadas = 0;
        if (activo) {
            celdasMarcadas = marcar.marcarCelda(fila, col, tablero);
            if (celdasMarcadas == -1) {
                activo = false;
                tablero.mostrarMinas();
            } else {
                nroCeldasMarcadas += celdasMarcadas;
            }
            verificarJuego();
        }
     
        this.notificarObservadores( );
        return celdasMarcadas;
    }

    private void verificarJuego() {
        int nroMinas = tablero.getListaMinas().size();
        int nroTotalCeldas = tablero.getTableroInicial().length * tablero.getTableroInicial()[0].length;
        int nroCeldasLibres = nroTotalCeldas - nroMinas;
        if (nroCeldasMarcadas == nroCeldasLibres) {
            victoria = true;
            activo = false;
            tablero.mostrarMinas();
        }
    }
    public Tablero getTablero(){
        return tablero;
    }
}
