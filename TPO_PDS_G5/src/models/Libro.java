package models;

import java.sql.Date;

import adapters.Ubicacion;
import models.Ejemplar.Ejemplar;

public class Libro extends Ejemplar {

	public Libro(String id, String titulo, String autor, Date fechaPublicacion, Ubicacion ubicacion) {
		super(id, titulo, autor, fechaPublicacion, ubicacion);
		// TODO Auto-generated constructor stub
	}

	private int diasPrestamo=10;
	
	public void actualizarParam(int diasPrestamo) {
    	this.diasPrestamo=diasPrestamo;
    }
    
	
	
}
