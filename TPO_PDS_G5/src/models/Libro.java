package models;

import java.sql.Date;

import adapters.Ubicacion;

public class Libro extends Ejemplar{

	public Libro(int id, String titulo, String autor, Date fechaPublicacion, Ubicacion ubicacion) {
		super(id, titulo, autor, fechaPublicacion, ubicacion);
		// TODO Auto-generated constructor stub
	}

	private int diasPrestamo=10;
	
	public void actualizarParam(int diasPrestamo) {
    	this.diasPrestamo=diasPrestamo;
    }
    
	
	
}
