package controllers;


import models.Prestamo;

import java.util.ArrayList;
import java.util.List;

public class ControllerPrestamo {
    private static ControllerPrestamo instancia;
    private ArrayList<Prestamo> prestamos;

    
    
    public ArrayList<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(ArrayList<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	private ControllerPrestamo() { }

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
        return prestamo.calcularDiasPrestamo(prestamo.getEjemplar(),prestamo.getSocio(),prestamo.getDiasPrestamo());
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

    public Prestamo buscarPrestamo(int  dni , String id) {
        for (Prestamo prestamo :  prestamos) {
            if (prestamo.getSocio().getDni() == dni && prestamo.getEjemplar().getId()== id) {
                return prestamo;
            }
        }
        return null;
    }

    public void eliminarPrestamo(int  dni , String id) {
        for (Prestamo prestamo :  prestamos) {
            if (prestamo.getSocio().getDni() == dni && prestamo.getEjemplar().getId()== id) {
                prestamos.remove(prestamo);
                return;
            }
        }

    }
}

