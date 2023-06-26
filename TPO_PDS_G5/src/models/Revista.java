package models;

import java.sql.Date;

import adapters.Ubicacion;
import models.Ejemplar.Ejemplar;
import models.Ejemplar.State.Devuelto;

public class Revista extends Ejemplar {
	

	
	public Revista(String id, String titulo, String autor, Date fechaPublicacion, Ubicacion ubicacion) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.fechaPublicacion = fechaPublicacion;
		this.ubicacion = ubicacion;
		this.diasPrestamo = 5;
		this.state=new Devuelto();
	}


	public void actualizarParam(int diasPrestamo) {
    	this.diasPrestamo=diasPrestamo;
    }
	

}
