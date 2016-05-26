
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author arquitectura de software I 2016
 */
public class Minas {  
    int[][] tablero;
    String[][] tableroJugador;
    int casillasJugadas;
    int tamanio;
    int bombas;
    int altura;
    int ancho;
    ValidadorTablero validador;
    private static int BOMBA_VALOR=-1;
    
    public Minas(int alturaT,int anchoT) {
        altura=alturaT;
        ancho=anchoT;
        tamanio=altura*ancho;
        casillasJugadas=0;
        if (tamanio>0){
            tablero = new int[altura][ancho];
            tableroJugador= new String[altura][ancho];
        }
        else {
            System.out.println("Tamaño no valido,el tamaño debe ser entero positivo ");
        } 
        validador= new ValidadorTablero();
        validador.copiarTamanioTablero(altura, ancho);
    }    
    
    private int abrirCasilla(int x, int y) {
        System.out.println("X"+x);
        System.out.println("Y" +y );
        return tablero[x][y];
    }

    public boolean esBomba(int x, int y) {
        return abrirCasilla(x, y) == BOMBA_VALOR;
    }

    private void cargarBombaEnCoordenadas(int x, int y) {
        tablero[x][y] = BOMBA_VALOR;
    }
    public void jugada(){
        casillasJugadas+=1;
    }
    public boolean continuarJuego(){
        
        return (casillasJugadas<tamanio-bombas);
    }
            
    public void cargarBombas11() {        
        cargarBombaEnCoordenadas(0,0);
    }
    
    public void cargarUnNumeroDeBombas(int numeroBombas) {
        if (numeroBombas > tamanio* 0.8) {
            System.out.println("El tablero es pequeño para el numero de Bombas");
        } 
        else {
            cargarBombasAleatorias(numeroBombas);      
            calcularNumeroDeBombasJuntas();
            imprimitTablero("Admin");
           
        }        
    }

    private void cargarBombasAleatorias(int numeroBombas) {
        int bombasCargadas;
        bombasCargadas = 0;

        while (bombasCargadas < numeroBombas) {
       
            int casillaXY[] = optenerCasillaEnBlanco();           
            cargarBombaEnCoordenadas(casillaXY[0], casillaXY[1]);
            bombasCargadas += 1;
        }
        bombas=bombasCargadas;

    }

    private void calcularNumeroDeBombasJuntas() {
        for (int coordX = 0; coordX <= altura- 1; coordX++) {
            for (int coordY = 0; coordY <= ancho - 1; coordY++) {
                if (!esBomba(coordX, coordY)) {
                    calcularBombasJuntasPorCasilla(coordX, coordY);
                }               
            }
        }
    }

    private void calcularBombasJuntasPorCasilla(int x, int y) {
        int bombasSerca;
        bombasSerca = 0;
        int maxMinX[] = validador.optenerMaxMinX(x);
        int maxMinY[] = validador.optenerMaxMinY(y);
       
        for (int coordX = maxMinX[1]; coordX <= maxMinX[0]; coordX++) {
            for (int coordY = maxMinY[1]; coordY <= maxMinY[0]; coordY++) {
                if (esBomba(coordX, coordY)) {
                    bombasSerca += 1;
                }
            }
        }
         
        tablero[x][y] = bombasSerca;
    }

    
    
    private int[] optenerCasillaEnBlanco() {

        int coordX;
        int coordY;
        Random randomGenerator = new Random();
        do {          
            coordX = randomGenerator.nextInt(altura - 1);
            coordY = randomGenerator.nextInt(ancho - 1);            
        } while (esBomba(coordX, coordY) != false);
        return new int[]{coordX, coordY};

    }
    private void imprimitTablero(String nombreTablero) {
        if ("Jugador".equals(nombreTablero)){
            System.out.println(Arrays.deepToString(tableroJugador).replaceAll("],", "]," + System.getProperty("line.separator")));
        }
        else{
            System.out.println(Arrays.deepToString(tablero).replaceAll("],", "]," + System.getProperty("line.separator")));
        }
    }
 
    public void jugarMinas() {
        boolean encontroBomba;      
        int jugada[];
        int jugadaX;
        int jugadaY;
        encontroBomba=false;
        System.out.println("------------ Juego busca minas ----------- \n Para salir del jugo pressione 0 "  );      
        while (encontroBomba==false){
            jugada=preguntarJugada();
            jugadaX=jugada[0];
            jugadaY=jugada[1];
            abrirJugada(jugadaX,jugadaY);
            encontroBomba=esBomba(jugadaX,jugadaY);        
        }
        imprimitTablero("Admin"); 
    }
    
    public int abrirJugada(int x, int y){
        int casilla;
        casilla = abrirCasilla(x,y);
        tableroJugador[x][y]=Integer.toString(casilla);
        return casilla;       
    }
    
    private int[] preguntarJugada() {
        int coordUsuarioX;
        int coordUsuarioY;   
        imprimitTablero("Jugador"); 
        coordUsuarioX=preguntarCoordena("X");
        coordUsuarioY=preguntarCoordena("Y");        
        return new int[]{ coordUsuarioY-1, coordUsuarioX -1};
    }
    
    private int preguntarCoordena(String XY){
        int coordUsuario ;
        boolean coordCorecta;
        coordUsuario=0;
        coordCorecta=false;
        System.out.println("Ingrese las coordenadas "+ XY +" de la casilla que desea abrir [1 -" + tablero.length +"]");      
                   
        while ( !coordCorecta){                
            Scanner entrada = new Scanner (System.in);           
            if (!entrada.hasNextInt()) {                
                System.out.println ("NO has ingresado un intero");
            }
            else{coordUsuario = entrada.nextInt(); 
                if (coordUsuario==0) {
                    System.exit(0);
                }
                if (!validador.coordenadaValida(coordUsuario,XY)){
                    System.out.println("Ingrese una coordenada valida del rango [1-" + tablero.length +"]");                           
                }
                else{
                    coordCorecta=true;
                }     
            }            
        }      
        return coordUsuario;
    }

    public void cargarBombasJuntas(int bombasACargar, int x, int y) {
        int maxMinX[] = validador.optenerMaxMinX(x);
        int maxMinY[] = validador.optenerMaxMinY(y);

        for (int coordX = maxMinX[1]; coordX <= maxMinX[0]; coordX++) {
            for (int coordY = maxMinY[1]; coordY <= maxMinY[0]; coordY++) {
                if (bombasACargar > 0 && (coordX == x && coordY == y) == false) {
                    cargarBombaEnCoordenadas(coordX, coordY);
                    bombasACargar -= 1;
                }
                if (bombasACargar == 0) {
                    break;

                }
            }
        }
        calcularBombasJuntasPorCasilla(x, y);
    }
    

}
