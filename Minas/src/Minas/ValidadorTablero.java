package Minas;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

/**
 *
 * @author arquitectura de software I 2016
 */
public class ValidadorTablero {

    int altura;
    int ancho;

    public ValidadorTablero() {
        altura = 9;
        ancho = 9;
    }

    public void copiarTamanioTablero(int alturaTablero, int anchoTablero) {
        altura = alturaTablero;
        ancho = anchoTablero;
    }

    public int validarTamanio(String nuevoTamanio) {
        int tamanio;
        tamanio = 9;
        try {
            tamanio = Integer.parseInt(nuevoTamanio);
            if (tamanio > 24) {
                System.out.println("El valor introducido es muy grande ");
                tamanio = 24;
            }
            if (9 > tamanio) {
                System.out.println("El valor introducido es muy pequeño");
                tamanio = 9;
            }
        } catch (NumberFormatException e) {
            System.out.println("Tamaño no valido,el tamaño debe ser entero positivo ");
        }
        System.out.println("Tamaño es " + tamanio);
        return tamanio;

    }

    public int validarNumeroBombas(String nuevoBombas, int tamanio) {
        int nBombas;
        nBombas = 10;
        try {
            nBombas = Integer.parseInt(nuevoBombas);
            if (10 > nBombas) {
                System.out.println("El valor introducido es muy pequeño,debe ser mayor a 10");
                nBombas = 10;
            }
            if (nBombas > tamanio * 0.8) {
                System.out.println("El tablero es pequeño para el numero de Bombas");
                nBombas = (int) (tamanio * 0.8);
            }
        } catch (NumberFormatException e) {
            System.out.println("Numero de Bombas no valido,el tamaño debe ser entero positivo ");
        }
        System.out.println("Numero de Bombas es " + nBombas);
        return nBombas;
    }

    public boolean coordenadaValida(int coordUsuario, String XY) {
        boolean cordValida;
        cordValida = Boolean.FALSE;
        if ("X".equals(XY)) {
            cordValida = (coordUsuario > 0 && coordUsuario < altura);
        }
        if ("Y".equals(XY)) {
            cordValida = (coordUsuario > 0 && coordUsuario < ancho);
        }
        return cordValida;
    }

    public int[] optenerMaxMinX(int coord) {
        return new int[]{min(coord + 1, altura - 1), max(coord - 1, 0)};
    }

    public int[] optenerMaxMinY(int coord) {
        return new int[]{min(coord + 1, ancho - 1), max(coord - 1, 0)};
    }

}
