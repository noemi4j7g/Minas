
import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author arquitectura de software I 2016
 */

public class Casilla extends JButton {

    int valorCasilla;
    int posicionCasilla;
    private static int BOMBA_VALOR = -1;

    public Casilla(int posicion) {
        setText("[]");
        setBackground(Color.blue);
        setVisible(Boolean.TRUE);
        posicionCasilla = posicion;
    }

    public boolean esBomba() {
        return valorCasilla == BOMBA_VALOR;
    }

    public void setValor(int valor) {
        valorCasilla = valor;
    }

    public int getValor() {
        return valorCasilla;
    }

    private void setColor() {
        this.setBackground(Color.lightGray);
        if (esBomba()) {
            this.setBackground(Color.black);
        }
    }

    private void mostrarValor() {
        this.setText("");
        if (valorCasilla > 0) {
            this.setText(Integer.toString(valorCasilla));
        }
    }

    public void mostrarJugador() {
        setColor();
        mostrarValor();
    }
}
