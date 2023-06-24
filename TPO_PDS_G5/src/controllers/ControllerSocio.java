package controllers;

import models.Ejemplar.Ejemplar;
import models.Prestamo;
import models.Socio.Socio;

import java.util.List;


public class ControllerSocio{
    private static ControllerSocio instancia;
    private List<Socio> socios;

    public void SocioController() {
        Socio socio = new Socio();
    }
    public List<Prestamo> getHistoriaPrestamos(Socio socio) {
        return socio.getHistoriaPrestamos();

    }

    public static ControllerSocio obtenerInstancia() {
        if (instancia == null) {
            instancia = new ControllerSocio();
        }
        return instancia;
    }
    public void SolicitarPrestamo(Ejemplar ejemplar,Socio socio) {

        socio.getState().solicitarPrestamo(socio, ejemplar);
    }
    public void nuevoSocio(Socio socio) {
        socios.add(socio);
    }

    public Socio buscarSocio(int id) {
        for (Socio socio : socios) {
            if (socio.getDni() == id) {
                return socio;
            }
        }
        return null;
    }

    public void eliminarSocio(int id) {
        for (Socio socio : socios) {
            if (socio.getDni() == id) {
                socios.remove(socio);
                return;
            }
        }

    }
}
