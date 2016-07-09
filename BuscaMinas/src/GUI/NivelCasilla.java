/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Tablero.Celda;
import Tablero.Tablero;
import java.awt.Panel;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Noemi Guzman
 */
public class NivelCasilla {
    public NivelCasilla(){
    }
    public void limpiar(JPanel panel, CasillaGUI[][] Botones) {
        for (int i = 0; i < Botones.length; i++) {
            for (int j = 0; j < Botones[0].length; j++) {
                panel.remove(Botones[i][j]);
            }
        }
    }

    void estaBotones(CasillaGUI[][] Botones,Tablero tablero,boolean victoria) {
        for (int fila = 0; fila < Botones.length; fila++) {
            for (int col = 0; col < Botones[0].length; col++) {
                Celda celda = tablero.getCelda(fila, col);                
                Botones[fila][col].mostrarJugador(celda,victoria);
            }
        }
        
    }

    void printTablero(CasillaGUI[][] Botones, HashMap<JButton, int[]> botones,JPanel panel,Nivel nivel) {
         int tamanio = 30;
        int iniX = 50;
        int iniY = 50;
            
        for (int fil = 0; fil < Botones.length; fil++) {
            for (int col = 0; col < Botones[0].length; col++) {               
                Botones[fil][col]= new CasillaGUI(fil,col);
                Botones[fil][col].setBounds(iniX, iniY, tamanio, tamanio);     
                Botones[fil][col].registrarTablero(nivel);
                panel.add(Botones[fil][col]);
                botones.put(Botones[fil][col], new int[]{fil, col});
                iniX += tamanio;
            }
            iniY += tamanio;
            iniX = 50;
        }  
       
    }
   
}
