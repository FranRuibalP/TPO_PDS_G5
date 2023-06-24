package models;

import java.sql.Date;

import adapters.Ubicacion;

public class Revista extends Ejemplar{
	
	public Revista(int id, String titulo, String autor, Date fechaPublicacion, Ubicacion ubicacion) {
		super(id, titulo, autor, fechaPublicacion, ubicacion);
		// TODO Auto-generated constructor stub
	}

	private int diasPrestamo=5;

}
