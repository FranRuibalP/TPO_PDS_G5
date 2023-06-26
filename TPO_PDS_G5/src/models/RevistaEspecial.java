package models;

import java.sql.Date;

import adapters.Ubicacion;
import models.Ejemplar.Ejemplar;
import models.Ejemplar.State.Devuelto;

public class RevistaEspecial extends Ejemplar {
	
	public RevistaEspecial(String id, String titulo, String autor, Date fechaPublicacion, Ubicacion ubicacion) {
		super(id, titulo, autor, fechaPublicacion, ubicacion);
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
