package GUI;


import Minas.Juego;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author arquitectura de software I 2016
 */

public class Casilla extends JButton implements ActionListener {

    int valorCasilla;
    int posicionCasillaX;
    int posicionCasillaY;
    private static int BOMBA_VALOR = -1;

    public Casilla(int x,int y) {
        posicionCasillaX=x;
        posicionCasillaY=y;
        setText("[]");
        setBackground(Color.blue);
        setVisible(Boolean.TRUE);
        
        addActionListener(this);
        
    }
    @Override
    public void actionPerformed(ActionEvent e){
        System.out.println("Clicking");
        mostrarJugador();
         
        
        if (esBomba()) {
            System.out.println("Encontro una bomba"  );  
            Juego.terminarJuego();                       
        }  
        else{
            Juego.regitrarJugada();
            Juego.calcularCasillasPorAbrir();
        }
        if (Juego.terminoJuego()){           
           System.out.println("termino "  );
           Tablero.terminaJuego();
        }         
        else{
            mostrarVacios();
        }
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
    private void mostrarVacios(){
        if (valorCasilla == 0) {
            Tablero.abrirCasillaVacias(posicionCasillaX,posicionCasillaY);            
        }
        
    }
}
