package models;

import java.sql.Date;
import java.util.List;

import adapters.Ubicacion;
import enumerations.MedioComunicacion;
import models.Ejemplar;
import models.Prestamo;


public class Socio {
    private String nombre;
    private String apellido;
    private int dni;
    private String mail;
    private String telefono;
    private MedioComunicacion medio;
    private List<Prestamo> historiaPrestamos;
    private List<Prestamo> prestamosActivos;
    private Modificador modificadores;
    
	public Socio(String nombre, String apellido, int dni, String mail, String telefono, MedioComunicacion medio,
			List<Prestamo> historiaPrestamos, List<Prestamo> prestamosActivos, Modificador modificadores) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.mail = mail;
		this.telefono = telefono;
		this.medio = medio;
		this.historiaPrestamos = historiaPrestamos;
		this.prestamosActivos = prestamosActivos;
		this.modificadores = modificadores;
	}

	/*
	public void SolicitarPrestamo(Prestamo prestamo) {
		new Prestamo(Ejemplar ejemplar, Socio socio, Date fechaSolicitud, Date fechaDevolucion, int diasPrestamo,
			int diasTranscurridos);
	}
	*/

	public List<Prestamo> getPrestamosActivos() {
		return prestamosActivos;
	}

	public List<Prestamo> getHistoriaPrestamos() {
		return historiaPrestamos;
		//actualizar parametro en diagrama
	}
	
	public void actualizarEstadoSocio() {
			
	}

    
    
    
}
