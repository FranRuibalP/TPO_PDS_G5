package models;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import models.Ejemplar.Ejemplar;
import models.Socio.Socio;
import strategies.Notificador;

public class Prestamo {
	private int id;
	private Ejemplar ejemplar;
	private Socio socio;
	private LocalDate fechaSolicitud;
	private LocalDate fechaDevolucion;
	private int diasPrestamo;
	private int diasTranscurridos;
	private Notificador notificador;
	
	public int calcularDiasPrestamo(Ejemplar ejemplar, Socio socio){
		return ejemplar.getDiasPrestamo() - socio.getModificador().getDias();
	}

	public Prestamo(Ejemplar ejemplar, Socio socio) {
		super();
		this.id = id;
		this.ejemplar = ejemplar;
		this.socio = socio;
		LocalDate date = LocalDate.now();
		this.fechaSolicitud =  date;
		this.fechaDevolucion = date.plusDays(calcularDiasPrestamo(ejemplar, socio));
		this.diasPrestamo = calcularDiasPrestamo(ejemplar, socio);
		this.diasTranscurridos = 0;
	}
	
	public void notificar(Socio socio){
		notificador.enviarNotificacion(notificador.getNotificacion());
	}

	public  Prestamo(){

	}
	public int calcularPenalizacion(){

		long diferenciaEnDias = ChronoUnit.DAYS.between(fechaDevolucion, fechaSolicitud);
		return (int) diferenciaEnDias;
	}
	public void devolver(){
		//ubicacion

		Modificador modificador = socio.getModificador();
		fechaDevolucion = LocalDate.now();
		if (fechaDevolucion.isAfter(fechaSolicitud.plusDays(diasPrestamo))){
			modificador.setDias(calcularPenalizacion());
		}
		else{
			modificador.actualizarPrestamosEnTiempo();
		}
		socio.getModificador().setDias(calcularPenalizacion());
		socio.getHistoriaPrestamos().add(this);
		socio.getPrestamosActivos().remove(this);
		ejemplar.devuelto();


	}
	public int getId(){
		return id;
	}

	public Ejemplar getEjemplar() {
		return ejemplar;
	}

	public Socio getSocio() {
		return socio;
	}
}
