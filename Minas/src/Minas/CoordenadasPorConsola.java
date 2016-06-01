/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Minas;

import java.util.Arrays;
import java.util.Scanner;

/**
 * clase para preguntar coordenadas por consola
 * @author Noemi Guzman
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
    private int[] preguntarJugada() {
        int coordUsuarioX;
        int coordUsuarioY;
        imprimitTablero("Jugador");
        coordUsuarioX = preguntarCoordena("X");
        coordUsuarioY = preguntarCoordena("Y");
        return new int[]{coordUsuarioY - 1, coordUsuarioX - 1};
    }

    private int preguntarCoordena(String XY) {
        int coordUsuario;
        boolean coordCorecta;
        int tamanio;
        coordUsuario = 0;
        coordCorecta = false;
        if(XY=="X"){
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
