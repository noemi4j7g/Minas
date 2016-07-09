package GUI;


import Tablero.Celda;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.JButton;

/**
 *
 * @author arquitectura de software I 2016
 */

public class CasillaGUI extends JButton  {

    String valorCasilla;
    int CasillaX;
    int CasillaY;
    CasillaTablero TableroObs;
    
    public CasillaGUI(int fil, int col) {
        CasillaX = fil;
        CasillaY = col;      
        setBackground(new Color(0, 0, 255));
        setVisible(Boolean.TRUE);         
    }

   
   

    public void mostrarJugador(Celda celda,boolean victoria) {        
       if (celda.estaMarcado()) {
            this.setMargin(new Insets(1, 1, 1, 1));
            if (celda.getTipo() >= 1) {
                this.setBackground(Color.LIGHT_GRAY);
            } else {
            if (celda.getTipo() == -1) {
                if (victoria) {
                    this.setBackground(Color.GREEN);
                } else {
                    this.setBackground(Color.RED);
                }
                } else {
                    this.setBackground(Color.white);
                }
            }
            this.setLabel(celda.getContenido());
        }    
    }

    public void registrarTablero(CasillaTablero TableroObservado) {
       TableroObs=TableroObservado;        
    }

    public void notificarNivel(int x,int y )
    {   
        // Enviarles la notificación a cada observador a través de su propio método
        TableroObs.notificarTablero(x,y);       
    }
 
}

