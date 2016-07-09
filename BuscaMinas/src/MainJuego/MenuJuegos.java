/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainJuego;


import InterfazConsola.Consola;
import GUI.GUI;
import Tablero.Tablero;
import java.io.IOException;
import java.util.Scanner;
import juego.Juego;

/**
 *
 * @author Noemi Guzman
 */
public class MenuJuegos {
      
    int tamanio;   
    GUI juegoG;
    Consola juegoC;
    Tablero tablero;
    Juego myJuego;
    public MenuJuegos() throws IOException{
 
        preguntarInterface();
    }    
    
    public static void main(String[] args) throws IOException {
       MenuJuegos myJuego= new MenuJuegos();
    } 
  
    private  void preguntarInterface() throws IOException {
        
        boolean coordCorecta;
        coordCorecta = false;      
        tablero = new Tablero(9, 9,20);
        myJuego = new Juego(tablero);
        System.out.println("Ingrese las que interface que desee jugar: para GUI 'G', para Consola 'C', and ambos 'A'");

        while (!coordCorecta) {
            Scanner entrada = new Scanner(System.in);
            String opUsuario = entrada.nextLine();
            coordCorecta = true;      
            switch (opUsuario){
                case "G":
                    System.out.println("Selecciono jugar por GUI");                   
                    juegoG = new GUI();
                    myJuego.registrar(juegoG);
                    juegoG.main(myJuego);                    
                    break;
                case "C":
                    System.out.println("Selecciono jugar por consola");
                    juegoC=new Consola();
                    myJuego.registrar(juegoC);
                    juegoC.comemzarJuego(myJuego);                    
                    break;
                case "A":
                    System.out.println("Selecciono jugar ambos GUI and consola");
                    juegoG = new GUI();
                    juegoC=new Consola();
                    myJuego.registrar(juegoG);
                    myJuego.registrar(juegoC);
                    juegoG.main(myJuego);                    
                    juegoC.comemzarJuego(myJuego);                    
                    break;
                default:
                    System.out.println("Ingrese las que interface que desee jugar: para GUI 'G', para Consola 'C', and ambos 'A'");
                    coordCorecta = false;
            }
         
        }  
    }
            
}
