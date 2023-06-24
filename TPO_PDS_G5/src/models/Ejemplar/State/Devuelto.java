package models.Ejemplar.State;
import models.Ejemplar.Ejemplar;
public class Devuelto implements EstadoEjemplar {
    public boolean solicitarEjemplar(Ejemplar ejemplar){
        System.out.println("El ejemplar esta disponible");
        return true;
    }
}
