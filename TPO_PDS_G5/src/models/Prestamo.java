package models;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import enumerations.MedioComunicacion;
import models.Ejemplar.Ejemplar;
import models.Socio.Socio;
import strategies.Notificador;

public class Prestamo {

	private Ejemplar ejemplar;
	private Socio socio;
	private LocalDate fechaSolicitud;
	private LocalDate fechaDevolucion;
	private int diasPrestamo;
	private int diasTranscurridos;
	private Notificador notificador;
	
	
	
	public void setNotificador(Notificador notificador) {
		this.notificador = notificador;
	}

	public int calcularDiasPrestamo(Ejemplar ejemplar, Socio socio, int diasTranscurridos){
		return ejemplar.getDiasPrestamo() - socio.getModificador().getDias() + diasTranscurridos;
	}

	public Prestamo(Ejemplar ejemplar, Socio socio) {
		super();

		this.ejemplar = ejemplar;
		this.socio = socio;
		LocalDate date = LocalDate.now();
		this.fechaSolicitud =  date;
		this.fechaDevolucion = date.plusDays(calcularDiasPrestamo(ejemplar, socio,diasTranscurridos));
		this.diasPrestamo = calcularDiasPrestamo(ejemplar, socio,diasTranscurridos);
		this.diasTranscurridos = 0;
	}
	
	public void notificar(Socio socio){
		this.notificador.enviarNotificacion(notificador.getNotificacion(),socio);
	}

	public  Prestamo(){

	}
	public int calcularPenalizacion(){
		
		int difDias = diasTranscurridos - diasPrestamo;
		
		return difDias;

		//long diferenciaEnDias = ChronoUnit.DAYS.between(fechaDevolucion, fechaSolicitud);
		//return (int) diferenciaEnDias;
	}
	public void devolver(){
		//ubicacion

		Modificador modificador = socio.getModificador();
		//fechaDevolucion = LocalDate.now();
		fechaDevolucion=fechaSolicitud.plusDays(diasTranscurridos);
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


	public int getDiasTranscurridos() {
		return diasTranscurridos;
	}

	public LocalDate getFechaSolicitud() {
		return fechaSolicitud;
	}

	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

	public int getDiasPrestamo() {
		return diasPrestamo;
	}

	public Ejemplar getEjemplar() {
		return ejemplar;
	}

	public Socio getSocio() {
		return socio;
	}
	
	public String toString() {
		return " Socio : " + this.getSocio().getNombre()  + " Titulo : " + this.getEjemplar().getTitulo() + " Fecha Solicitud: " + this.getFechaSolicitud() + 
				" Fecha de devolucion: " + this.getFechaDevolucion() + " Dias en prestamo: " + this.getDiasPrestamo()  + " Dias transcurridos: " + this.getDiasTranscurridos();
	}

	public void setDiasTranscurridos(int diasTranscurridos) {
		this.diasTranscurridos = diasTranscurridos;
	}

	
}
