/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainJuego;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Noemi Guzman
 */
public class JuegoObservado {
    private List<JuegoAbierto> juegosAbiertos;
    
    
    public JuegoObservado() {
        juegosAbiertos = new ArrayList<>();        
    }
    
    public void registrar(JuegoAbierto juegoA) {
        juegosAbiertos.add(juegoA);        
    }

    public void notificarObservadores( )
    {
        // Enviarles la notificación a cada observador a través de su propio método
       
        for (JuegoAbierto  obj : juegosAbiertos) {      
            obj.observadoActualizado(this);
        }
    }
}
