package models;

import java.sql.Date;

import adapters.Ubicacion;
import models.Ejemplar.Ejemplar;

public class RevistaEspecial extends Ejemplar {
	
	public RevistaEspecial(String id, String titulo, String autor, Date fechaPublicacion, Ubicacion ubicacion) {
		super(id, titulo, autor, fechaPublicacion, ubicacion);
		// TODO Auto-generated constructor stub
	}

	private int diasPrestamo=5;
	
	public void actualizarParam(int diasPrestamo) {
    	this.diasPrestamo=diasPrestamo;
    }
    

}
