package models;
import java.sql.Date;

import models.Ejemplar;
import models.Socio;

public class Prestamo {
	private Ejemplar ejemplar;
	private Socio socio;
	private Date fechaSolicitud;
	private Date fechaDevolucion;
	private int diasPrestamo;
	private int diasTranscurridos;
	
	public int calcularDiasPrestamo(){
		return diasPrestamo;
	}

	public Prestamo(Ejemplar ejemplar, Socio socio, Date fechaSolicitud, Date fechaDevolucion, int diasPrestamo,
			int diasTranscurridos) {
		super();
		this.ejemplar = ejemplar;
		this.socio = socio;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaDevolucion = fechaDevolucion;
		this.diasPrestamo = diasPrestamo;
		this.diasTranscurridos = diasTranscurridos;
	}
	
	
	
	
}
