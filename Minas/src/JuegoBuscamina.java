
import Minas.Minas;
import java.util.Scanner;

/**
 *
 * @author arquitectura de software I 2016
 */
public class JuegoBuscamina {

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

    public static void main(String[] args) {
        int tamanio;
        int bombas;
        tamanio = preguntaTamanio();
        bombas = preguntaNumeroBombas();
        Minas miMina = new Minas(tamanio, tamanio);
        miMina.cargarUnNumeroDeBombas(bombas);
        miMina.jugarMinas();
    }

}
