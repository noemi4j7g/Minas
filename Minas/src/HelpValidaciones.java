/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Noemi Guzman
 */
public class HelpValidaciones {
    public int validarTamanio(String nuevoTamanio){
        int tamanio;
        tamanio=9;
        try {
            tamanio = Integer.parseInt(nuevoTamanio);
        }
        catch (NumberFormatException e) {
             
        }
        return tamanio;
                
    }
    public int validarNumeroBombas(String nuevoBombas){
        int nBombas;
        nBombas=10;
        try {
            nBombas = Integer.parseInt(nuevoBombas);
        }
        catch (NumberFormatException e) {
             
        }
        return nBombas;
                
    }
}
