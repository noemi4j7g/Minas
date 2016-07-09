package Tablero;

/**
 *
 * @author 
 */
public class Celda {

    private boolean activo;
    private int tipo;
    
    public Celda(int tipo) {
        activo = false;
        this.tipo = tipo;
    }

    public boolean estaMarcado() {
        return activo;
    }

    public void marcarCelda() {
        activo = true;
    }

    public int getTipo() {
        return tipo;
    }

    public String getContenido() {
        return generarContenido();
    }

    public Celda clone() {
        Celda c = new Celda(tipo);
        return c;
    }

    private String generarContenido() {
        String contenido = "";
        if (activo) {
            switch (tipo) {
                case -1:
                    contenido = "*";
                    break;
                case 0:
                    contenido = " ";
                    break;
                default:
                    contenido = tipo + "";
                    break;
            }
        } else {
            contenido = "_";
        }
        return contenido;
    }

}
