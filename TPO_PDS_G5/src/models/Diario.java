package models;

import java.sql.Date;

import adapters.Ubicacion;

public class Diario extends Ejemplar{

	public Diario(int id, String titulo, String autor, Date fechaPublicacion, Ubicacion ubicacion) {
		super(id, titulo, autor, fechaPublicacion, ubicacion);
		// TODO Auto-generated constructor stub
	}

	private int DiasPrestamo=5;
	
}
