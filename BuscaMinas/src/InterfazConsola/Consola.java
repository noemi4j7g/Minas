package InterfazConsola;

import MainJuego.JuegoAbierto;
import MainJuego.JuegoObservado;
import Tablero.Tablero;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import juego.Juego;

/**
 *
 * @author 
 */
public class Consola implements JuegoAbierto {
    Juego juego;
    Tablero tablero;
    PrintConsola print = new PrintConsola();  
   
    public void comemzarJuego(Juego myJuego) throws IOException {
        int fila;
        int col;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;          
                
        juego =  myJuego;
        tablero= juego.getTablero();
        while (juego.getJugando()) {
            System.out.println("------------------------------------------------------\n");                  
            System.out.println("Ingrese las coordenas x y: ");
            String coordenadas = in.readLine();
            if (print.datosValidos(coordenadas)) {
            st = new StringTokenizer(coordenadas);
            fila = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            juego.marcarCelda(fila, col);
            } else {
            System.out.println("Error al ingresar los datos!!!!");
            }
        }
        if (juego.esVictoria()) {
            System.out.println("\n\n\n\nYOU WIN!!!!");
            } else {
        System.out.println("\n\n\n\nGAME OVER!!!");
        }                       
        
    }

    @Override
    public void observadoActualizado(JuegoObservado objObservado) {
        System.out.println("Actualizar en consola" );
        print.printMazeGame(tablero);
    }
}
