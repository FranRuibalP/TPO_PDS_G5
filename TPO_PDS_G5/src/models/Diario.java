package models;

import java.sql.Date;

import adapters.Ubicacion;
import models.Ejemplar.Ejemplar;

public class Diario extends Ejemplar {

	public Diario(String id, String titulo, String autor, Date fechaPublicacion, Ubicacion ubicacion) {
		super(id, titulo, autor, fechaPublicacion, ubicacion);
		// TODO Auto-generated constructor stub
	}

	public Diario() {
		// TODO Auto-generated constructor stub
	}

	private int diasPrestamo=5;
	
	
	
	public int getDiasPrestamo() {
		return diasPrestamo;
	}



	public void setDiasPrestamo(int diasPrestamo) {
		this.diasPrestamo = diasPrestamo;
	}



	public void actualizarParam(int diasPrestamo) {
    	this.diasPrestamo=diasPrestamo;
    }
	
}
