/**
 *
 * @author arquitectura de software I 2016
 */
package GUI;

import Minas.Juego;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Minas.ValidadorTablero;
import java.awt.event.ComponentListener;

/**
 *
 * @author Noemi Guzman
 */
public class VentanaJuego extends javax.swing.JFrame {

    private JTextField txt_alto;
    private JTextField txt_ancho;
    private JTextField txt_nbombas;
    private JButton bt_jugar;
    private JLabel lb_alto;
    private JLabel lb_ancho;
    private JLabel lb_nbombas;
    private JPanel panel_setTablero;
    private JPanel panelMain;
    private Tablero panel_juego;

    private int anchoTablero;
    private int altoTablero;
    private int nBombas;
    Juego myJuego;
    ValidadorTablero validador;

    /**
     * Creates new form VentanaJuego
     */
    public VentanaJuego() {
        validador = new ValidadorTablero();
        initComponents();
        componentes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void componentes() {
        setBounds(200, 200, 500, 500);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Busca Minas");
        setLocationByPlatform(true);

        // creating main JPanel (white)
        panelMain = new JPanel();
        panelMain.setBackground(Color.WHITE);
        panelMain.setBounds(0, 0, 420, 700);
        panelMain.setPreferredSize(new Dimension(200, 700));
        add(panelMain);

        panel_setTablero = new JPanel();

        txt_alto = new JTextField();
        txt_ancho = new JTextField();
        txt_nbombas = new JTextField();
        lb_alto = new JLabel();
        lb_ancho = new JLabel();
        lb_nbombas = new JLabel();
        bt_jugar = new JButton();

        lb_alto.setText("Alto:");
        lb_nbombas.setText("Numero Bombas:");
        lb_ancho.setText("Ancho:");
        txt_nbombas.setText("10");
        txt_ancho.setText("9");
        txt_alto.setText("9");
        bt_jugar.setText("Jugar");

        lb_alto.setBounds(0, 25, 130, 25);
        panel_setTablero.add(lb_alto);
        txt_alto.setBounds(0, 250, 120, 25);
        panel_setTablero.add(txt_alto);
        lb_ancho.setBounds(150, 25, 130, 25);
        panel_setTablero.add(lb_ancho);
        txt_ancho.setBounds(150, 250, 120, 25);
        lb_nbombas.setBounds(0, 50, 130, 25);
        txt_nbombas.setBounds(150, 250, 120, 25);
        addComponentes();
    }

    private void addComponentes() {
        panel_setTablero.add(txt_ancho);
        panel_setTablero.add(lb_nbombas);
        panel_setTablero.add(txt_nbombas);
        panel_setTablero.add(bt_jugar);
        panel_setTablero.setBounds(0, 0, 500, 300);
        bt_jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_jugarActionPerformed(evt);
            }
        });

        panelMain.add(panel_setTablero);
        panel_setTablero.setVisible(true);
        setVisible(true);
    }

    public void leerTamanioTablero() {

        altoTablero = validador.validarTamanio(txt_alto.getText());
        txt_alto.setText(String.valueOf(String.valueOf(altoTablero)));
        anchoTablero = validador.validarTamanio(txt_ancho.getText());
        txt_ancho.setText(String.valueOf(String.valueOf(anchoTablero)));
        nBombas = validador.validarNumeroBombas(txt_nbombas.getText(), anchoTablero * altoTablero);
        txt_nbombas.setText(String.valueOf(nBombas));

    }

    private void bt_jugarActionPerformed(java.awt.event.ActionEvent evt) {

        leerTamanioTablero();
        panelMain.removeAll();
        addComponentes();
        System.out.println("Tablero: Alto " + String.valueOf(altoTablero) + " anchos " + String.valueOf(anchoTablero) + " Bombas " + String.valueOf(nBombas));
        panel_juego = new Tablero(altoTablero, anchoTablero, nBombas);
        panel_juego.setBackground(Color.blue);
        panelMain.add(panel_juego);

        this.paintAll(this.getGraphics());

        System.out.println("Tablero cargado ");

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
