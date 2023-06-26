package models;

import java.sql.Date;

import adapters.Ubicacion;
import models.Ejemplar.Ejemplar;
import models.Ejemplar.State.Devuelto;

public class Diario extends Ejemplar {

	public Diario(String id, String titulo, String autor, Date fechaPublicacion, Ubicacion ubicacion) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.fechaPublicacion = fechaPublicacion;
		this.ubicacion = ubicacion;
		this.diasPrestamo = 5;
		this.state=new Devuelto();
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
