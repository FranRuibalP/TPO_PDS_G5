package models.Ejemplar.State;
import models.Ejemplar.Ejemplar;
public class Devuelto implements EstadoEjemplar {
    public boolean solicitarEjemplar(Ejemplar ejemplar){
        return true;
    }
}
