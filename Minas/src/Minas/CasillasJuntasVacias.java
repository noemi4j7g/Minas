package Minas;

/**
 *
 * @author Noemi Guzman
 */
public class CasillasJuntasVacias {

    static boolean[][] tableroVisible;
    static int[][] tableroJ;
    static int altura;
    static int ancho;

    public static boolean[][] casillaV(int X, int Y, int alturaT, int anchoT, int[][] tablero) {
        tableroJ = tablero.clone();
        altura = alturaT;
        ancho = anchoT;
        tableroVisible = new boolean[altura][ancho];
        buscar4Direcciones(X, Y, true);
        return tableroVisible;
    }

    private static void buscar4Direcciones(int X, int Y, boolean original) {
        buscarCasillaVaciasYDerecha(X, Y, original);
        buscarCasillaVaciasXIzquierda(X, Y, original);
        buscarCasillaVaciasXAbajo(X, Y, original);
        buscarCasillaVaciasYArriba(X, Y, original);
    }

    private static void buscarCasillaVaciasXAbajo(int x, int y, boolean vueltaOrinal) {
        for (int i = x; i < altura; i++) {
            if (tableroJ[i][y] >= 0) {
                tableroVisible[i][y] = true;
                if (vueltaOrinal) {
                    buscar4Direcciones(i, y, false);
                }
            }
            if (tableroJ[i][y] > 0 || tableroJ[i][y] == -1) {
                break;
            }
        }
    }

    private static void buscarCasillaVaciasXIzquierda(int x, int y, boolean vueltaOriginal) {
        for (int i = x; i >= 0; i--) {
            if (tableroJ[i][y] >= 0) {
                tableroVisible[i][y] = true;
                if (vueltaOriginal) {
                    buscar4Direcciones(i, y, false);
                }
            }
            if (tableroJ[i][y] > 0 || tableroJ[i][y] == -1) {
                break;
            }
        }
    }

    private static void buscarCasillaVaciasYDerecha(int x, int y, boolean vueltaOriginal) {
        for (int i = y; i < ancho; i++) {
            if (tableroJ[x][i] >= 0) {
                tableroVisible[x][i] = true;
                if (vueltaOriginal) {
                    buscar4Direcciones(y, i, false);
                }
            }
            if (tableroJ[x][i] > 0 || tableroJ[x][i] == -1) {
                break;
            }
        }
    }

    private static void buscarCasillaVaciasYArriba(int x, int y, boolean vueltaOriginal) {
        for (int i = y; i >= 0; i--) {
            if (tableroJ[x][y] >= 0) {
                tableroVisible[x][i] = true;
                if (vueltaOriginal) {
                    buscar4Direcciones(y, i, false);
                }
            }
            if (tableroJ[x][i] > 0 || tableroJ[y][i] == -1) {
                break;
            }
        }
    }

}
