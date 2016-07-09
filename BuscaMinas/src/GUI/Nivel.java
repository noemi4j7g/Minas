package GUI;

import Tablero.Celda;
import Tablero.Tablero;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import juego.Juego;

public class Nivel  {

    private final int filas;
    private final int columnas;

    private CasillaGUI Botones[][];
    private HashMap<JButton, int[]> botones;
    private Tablero tablero;
    private Juego juego;
    public LabelEstado labelEstado;
    private JLabel labelCeldasAbiertas;
    private JLabel labelNroMinas;
    private JPanel panel;

    public Nivel(Juego myJuego) {
        panel = new JPanel();
        this.filas = 9;
        this.columnas = 9;       
        panel.setLayout(null);
        panel.setSize(700, 700);    
        juego = myJuego;
        tablero=juego.getTablero();
        labelCeldasAbiertas = new JLabel();
        labelNroMinas = new JLabel();
        labelCeldasAbiertas.setBounds(40, 15, 80, 15);
        labelNroMinas.setBounds(200, 15, 200, 15);
        panel.add(labelCeldasAbiertas);
        panel.add(labelNroMinas);
     
        printTablero();
    }

    
    private void printTablero(){ 
        setLabels();
        int tamanio = 30;
        int iniX = 50;
        int iniY = 50;
        Botones = new CasillaGUI[this.filas][this.columnas];
        botones = new HashMap<>();
        labelEstado = new LabelEstado();
        
        panel.add(labelEstado);
     
        for (int fil = 0; fil < this.filas; fil++) {
            for (int col = 0; col < this.columnas; col++) {               
                Botones[fil][col]= new CasillaGUI(fil,col);
                Botones[fil][col].setBounds(iniX, iniY, tamanio, tamanio);
                Botones[fil][col].addActionListener(
                    new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                       pulsarBoton(e.getSource());
                    }
                });
                panel.add(Botones[fil][col]);
                botones.put(Botones[fil][col], new int[]{fil, col});
                iniX += tamanio;
            }
            iniY += tamanio;
            iniX = 50;
        }       
    }
   
    public void actualizar(){
        estadoBotones();
        labelEstado.actualizarLabel(juego.esVictoria(),juego.esDerrota());
       
        setLabels();
    }
    private void estadoBotones() {
        boolean victoria = juego.esVictoria();
        for (int fila = 0; fila < this.filas; fila++) {
            for (int col = 0; col < this.columnas; col++) {
                Celda celda = tablero.getCelda(fila, col);                
                Botones[fila][col].mostrarJugador(celda,victoria);
            }
        }
    }

    public JPanel getPanel() {
        return panel;
    }

    public void reiniciarNivel() {
        tablero = new Tablero(tablero.getTableroInicial());
        juego = new Juego(tablero);
        printTablero();
    }

    private void setLabels() {
        int nroCeldas = tablero.getTableroInicial().length * tablero.getTableroInicial()[0].length;
        int minas = tablero.getListaMinas().size();
        int celdasAmarcar = nroCeldas - minas;
        labelCeldasAbiertas.setOpaque(true);
        labelNroMinas.setOpaque(true);
        labelCeldasAbiertas.setText(juego.getNroCeldasMarcadas() + " / " + celdasAmarcar);
        labelNroMinas.setText("Minas : " + minas);
    }

    public void limpiar() {
        for (int i = 0; i < Botones.length; i++) {
            for (int j = 0; j < Botones[0].length; j++) {
                panel.remove(Botones[i][j]);
            }
        }
        botones.clear();
        labelCeldasAbiertas.setText(" / ");
        labelNroMinas.setText("Minas : ");
        labelEstado.setText("");
    }
     private void pulsarBoton(Object obj) {
        if (botones.containsKey(obj)) {
            int fila = botones.get(obj)[0];
            int col = botones.get(obj)[1];
            juego.marcarCelda(fila, col);
            estadoBotones();
        }
        actualizar();
     }      
}
