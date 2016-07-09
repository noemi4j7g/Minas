package GUI;

import MainJuego.JuegoAbierto;
import MainJuego.JuegoObservado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import juego.Juego;

/**
 *
 * @author 
 */
public class GUI implements JuegoAbierto, ActionListener {

    private JMenuBar barra;
    private JMenu juego;
    private JMenu help; 
    private JMenuItem restart;
    private JMenuItem info;
    private Nivel nivel;
    private JFrame frame;
    private JPanel panelNivel;
    private int width;
    private int height;
    Juego myJuego;
   
    public void main(Juego myJuego) {
        this.myJuego=myJuego;
        frame = new JFrame("MINAS");
        frame.setLayout(null);
        frame.setTitle("MINAS");
        barra = new JMenuBar();
        juego = new JMenu("Game");
        help = new JMenu("Help");      
        restart = new JMenuItem("Restart");
        info = new JMenuItem("Information");    
                
        juego.add(restart);
        help.add(info);
        barra.add(juego);
        barra.add(help);
      
        restart.addActionListener(this);
        info.addActionListener(this);
        frame.setJMenuBar(barra);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        width = 400;
        height = 450;
        frame.setSize(width, height);
        nivel = new Nivel(this.myJuego);
        panelNivel = nivel.getPanel();
        frame.add(panelNivel);
        frame.paint(frame.getGraphics());
    }

    @Override
    public void actionPerformed(ActionEvent e) {   
        if (e.getSource() == restart) {
            nivel.limpiar();
            nivel.reiniciarNivel();
            frame.setSize(width, height);
            frame.paint(frame.getGraphics());
        }
        if (e.getSource() == info) {
            JOptionPane.showMessageDialog(null, "    It's So Easy!!!");
            frame.paint(frame.getGraphics());
        }
    }

    public void observadoActualizado(JuegoObservado objObservado) {
        System.out.println("Actualizar GUI" );
        nivel.actualizar();
    }
}
