package controllers;

import models.Prestamo;
import models.Ejemplar.Ejemplar;

import java.util.ArrayList;
import java.util.List;


public class ControllerEjemplar{
    private static ControllerEjemplar instancia;
    private ArrayList<Ejemplar> ejemplares;

    public  ControllerEjemplar() {
    	List<Ejemplar> ejemplares=new ArrayList<>();
    }

    public void devuelto(Ejemplar ejemplar) {
        ejemplar.devuelto();

    }
    public void prestado(Ejemplar ejemplar) {

        ejemplar.prestado();
    }
    public void actualizarParam(Ejemplar ejemplar,int diasPrestamo) {

        ejemplar.actualizarParam(diasPrestamo);
    }
    public void solicitarEjemplar(Ejemplar ejemplar) {
         ejemplar.solicitarEjemplar();
    }

    public static ControllerEjemplar obtenerInstancia() {
        if (instancia == null) {
            instancia = new ControllerEjemplar();
        }
        return instancia;
    }

    public void nuevoEjemplar(Ejemplar ejemplar) {
        ejemplares.add(ejemplar);
    }

    public Ejemplar buscarEjemplarId(int id) {
        for (Ejemplar ejemplar :  ejemplares) {
            if (ejemplar.getId() == id) {
                return ejemplar;
            }
        }
        return null;
    }
    public Ejemplar buscarEjemplarTitulo(String titulo) {
        for (Ejemplar ejemplar :  ejemplares) {
            if (ejemplar.getTitulo() == titulo) {
                return ejemplar;
            }
        }
        return null;
    }
    public Ejemplar buscarEjemplarAutor(String autor) {
        for (Ejemplar ejemplar :  ejemplares) {
            if (ejemplar.getAutor() == autor) {
                return ejemplar;
            }
        }
        return null;
    }


    public void eliminarEjemplar(int id) {
        for (Ejemplar ejemplar :  ejemplares) {
            if (ejemplar.getId() == id) {
                ejemplares.remove(ejemplar);
                return;
            }
        }

    }
}
