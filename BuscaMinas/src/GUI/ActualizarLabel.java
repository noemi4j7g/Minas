/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Tablero.Tablero;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Noemi Guzman
 */
public class ActualizarLabel {
    public ActualizarLabel() {
    
    }
    public void ActualizarLabels(JLabel labelAbierta,JLabel labelMinas,JLabel labelEstado){
        
        labelAbierta.setText(" / ");
        labelMinas.setText("Minas : ");
        labelEstado.setText("");
        
    }
    
    public void setLabels(JLabel labelAbierta,JLabel labelMinas,int minas) { 
        
        labelAbierta.setOpaque(true);        
        labelMinas.setOpaque(true);        
        labelMinas.setText("Minas : " + minas);
    }
    public void setLabelAbiertas(JLabel labelEstado,Tablero tablero,int marcadas) {
        int nroCeldas = tablero.getTableroInicial().length * tablero.getTableroInicial()[0].length;
        int minas = tablero.getListaMinas().size();
        int celdasAmarcar = nroCeldas - minas;       
        labelEstado.setText(marcadas + " / " + celdasAmarcar);        
    }

    public void inicarLabel(JPanel panel,JLabel labelAbierta,JLabel labelMinas) {
       
        labelAbierta.setBounds(40, 15, 80, 15);
        labelMinas.setBounds(200, 15, 200, 15);
        panel.add(labelAbierta);
        panel.add(labelMinas);
        
    }    
}
