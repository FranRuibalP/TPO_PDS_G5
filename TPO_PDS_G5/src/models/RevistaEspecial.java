package models;

import java.sql.Date;

import adapters.Ubicacion;

public class RevistaEspecial extends Ejemplar{
	
	public RevistaEspecial(int id, String titulo, String autor, Date fechaPublicacion, Ubicacion ubicacion) {
		super(id, titulo, autor, fechaPublicacion, ubicacion);
		// TODO Auto-generated constructor stub
	}

	private int diasPrestamo=5;

}
