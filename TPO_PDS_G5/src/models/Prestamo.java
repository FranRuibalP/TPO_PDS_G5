package models;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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
	
	public int calcularDiasPrestamo(Ejemplar ejemplar, Socio socio){
		return ejemplar.getDiasPrestamo() - socio.getModificador().getDias();
	}

	public Prestamo(Ejemplar ejemplar, Socio socio) {
		super();
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


	public void devolver(){
		ejemplar.cambiarEstado(ejemplar.getState());
		//ubicacion

		//metodo para calcular los dias de penalizacion
		Modificador modificador = socio.getModificador();
		fechaDevolucion = LocalDate.now();
		long diferenciaEnDias = ChronoUnit.DAYS.between(fechaDevolucion, fechaSolicitud);
		modificador.actualizarDias((int) diferenciaEnDias);
		socio.getHistoriaPrestamos().add(this);


	}
	
	
}
