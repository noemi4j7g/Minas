/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author Noemi Guzman
 */
public class LabelEstado extends JLabel{
    public LabelEstado(){
        this.setBounds(200, 15, 90, 15);
    }
    public void actualizarLabel(boolean esVictoria,boolean esDerrota){
        this.setOpaque(true);
        this.setForeground(Color.white);
        if (esVictoria) {           
            this.setBackground(Color.GREEN);            
            this.setText("YOU WIN!!!");            
        }
        if (esDerrota) {           
            this.setBackground(Color.RED);       
            this.setText("YOU LOSE!!!");            
        }
    }
}
