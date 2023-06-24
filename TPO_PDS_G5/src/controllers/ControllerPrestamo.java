package controllers;


import models.Prestamo;


import java.util.List;

public class ControllerPrestamo {
    private static ControllerPrestamo instancia;
    private List<Prestamo> prestamos;

    public void ControllerPrestamo() {
        Prestamo prestamo = new Prestamo();
    }

    public static ControllerPrestamo obtenerInstancia() {
        if (instancia == null) {
            instancia = new ControllerPrestamo();
        }
        return instancia;
    }
    public int calcularPenalizacion(Prestamo prestamo) {
        return prestamo.calcularPenalizacion();
    }
    public int calcularDiasPrestamo(Prestamo prestamo) {
        return prestamo.calcularDiasPrestamo(prestamo.getEjemplar(),prestamo.getSocio());
    }
    public void notificar(Prestamo prestamo) {
        prestamo.notificar(prestamo.getSocio());
    }
    public void devolver(Prestamo prestamo) {
        prestamo.devolver();
    }
    public void nuevoPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    public Prestamo buscarPrestamo(int id) {
        for (Prestamo prestamo :  prestamos) {
            if (prestamo.getId() == id) {
                return prestamo;
            }
        }
        return null;
    }

    public void eliminarPrestamo(int id) {
        for (Prestamo prestamo :  prestamos) {
            if (prestamo.getId() == id) {
                prestamos.remove(prestamo);
                return;
            }
        }

    }
}

