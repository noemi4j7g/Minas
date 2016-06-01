
package Minas;

import java.util.Scanner;

/**
 *
 * @author arquitectura de software I 2016
 */
public class CoordenadasPorConsola {
    ValidadorTablero validador;
    int altura;
    int ancho;
 
    public CoordenadasPorConsola (int alturaT,int anchoT){
        altura=alturaT;
        ancho=anchoT;
        validador = new ValidadorTablero();
        validador.copiarTamanioTablero(alturaT, anchoT);
    }
    public int[] preguntarJugada() {
        int coordUsuarioX;
        int coordUsuarioY;
 
        coordUsuarioX = preguntarCoordena("X");
        coordUsuarioY = preguntarCoordena("Y");
        return new int[]{ coordUsuarioX - 1,coordUsuarioY - 1};
    }

    private int preguntarCoordena(String XY) {
        int coordUsuario;
        boolean coordCorecta;
        int tamanio;
        coordUsuario = 0;
        coordCorecta = false;
        if("X".equals(XY)){
            tamanio=altura; 
        }
        else {
            tamanio=ancho;
        }
        
        System.out.println("Ingrese las coordenadas " + XY + " de la casilla que desea abrir [1 -" + tamanio + "]");

        while (!coordCorecta) {
            Scanner entrada = new Scanner(System.in);
            if (!entrada.hasNextInt()) {
                System.out.println("NO has ingresado un intero");
            } else {
                coordUsuario = entrada.nextInt();
                if (coordUsuario == 0) {
                    System.exit(0);
                }
                if (!validador.coordenadaValida(coordUsuario, XY)) {
                    System.out.println("Ingrese una coordenada valida del rango [1-" + tamanio + "]");
                } else {
                    coordCorecta = true;
                }
            }
        }
        return coordUsuario;
    }
}
