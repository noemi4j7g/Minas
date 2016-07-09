package InterfazConsola;

import Tablero.Celda;
import Tablero.Tablero;
import java.util.StringTokenizer;

/**
 *
 * @author 
 */
public class PrintConsola {

    public boolean datosValidos(String cad) {
        boolean res = false;
        StringTokenizer st = new StringTokenizer(cad);
        if (st.countTokens() == 2) {
            String num1 = (st.nextToken());
            String num2 = (st.nextToken());
            if (isNumber(num1) && isNumber(num2)) {
                res = true;
            }
        }
        return res;
    }

    public boolean isNumber(String cad) {
        boolean res = true;
        try {
            int n = Integer.parseInt(cad);
        } catch (Exception e) {
            res = false;
        }
        return res;
    }

    public void printMaze(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == -1) {
                    System.out.print("-1" + "; ");
                } else {
                    System.out.print(" " + m[i][j] + "; ");
                }
            }
            System.out.println("");
        }
    }

    public void printMazeGame(Tablero m) {
        for (int i = 0; i < m.getTableroInicial().length; i++) {
            for (int j = 0; j < m.getTableroInicial()[0].length; j++) {
                Celda celda = m.getCelda(i, j);
                System.out.print(" " + celda.getContenido() + " " + "| ");
            }
            System.out.println("");
        }
    }
}
