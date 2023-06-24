package models.Ejemplar.State;

import models.Ejemplar.Ejemplar;
public class Prestado implements EstadoEjemplar {
    public boolean solicitarEjemplar(Ejemplar ejemplar){
        System.out.println("El ejemplar no esta disponible");
        return false;
    }
}
