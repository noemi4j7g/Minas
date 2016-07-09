package GUI;


import Tablero.Tablero;
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
    JLabel labelCeldasAbiertas = new JLabel();
    JLabel labelNroMinas = new JLabel();
    NivelCasilla nivelCasilla=new NivelCasilla();
    private JPanel panel;
    ActualizarLabel actualizarLabel;

    public Nivel(Juego myJuego) {
        panel = new JPanel();
        this.filas = 9;
        this.columnas = 9;       
        panel.setLayout(null);
        panel.setSize(700, 700);    
        juego = myJuego;
        tablero=juego.getTablero();       
        actualizarLabel= new ActualizarLabel();
        actualizarLabel.inicarLabel(panel,labelCeldasAbiertas,labelNroMinas);
        printTablero();
    }

    private void printTablero(){ 
        setLabels();      
        Botones = new CasillaGUI[this.filas][this.columnas];
        botones = new HashMap<>();
        labelEstado = new LabelEstado();      
        nivelCasilla.printTablero(Botones,botones,panel,this);
        panel.add(labelEstado);    
        
    }
   
    public void actualizar(){
        boolean victoria = juego.esVictoria();
        nivelCasilla.estaBotones(Botones,tablero,victoria);
        labelEstado.actualizarLabel(juego.esVictoria(),juego.esDerrota());       
        setLabels();
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
        actualizarLabel.setLabels(labelCeldasAbiertas, labelNroMinas, tablero.getListaMinas().size());
        actualizarLabel.setLabelAbiertas(labelCeldasAbiertas,tablero,juego.getNroCeldasMarcadas() );
    }

    public void limpiar() {
        nivelCasilla.limpiar(panel,Botones);       
        botones.clear();
        actualizarLabel.ActualizarLabels(labelCeldasAbiertas,labelNroMinas,labelEstado); 
    }

    void notificarTablero(int x, int y) {
        juego.marcarCelda(x, y);
        actualizar();     
    }
}
