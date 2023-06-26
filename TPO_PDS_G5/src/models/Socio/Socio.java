package models.Socio;

import java.sql.Date;
import java.util.List;

import models.Modificador;
import models.Socio.State.EstadoSocio;
import models.Socio.State.Habilitado;
import models.Socio.State.Suspendido;

import adapters.Ubicacion;
import enumerations.MedioComunicacion;
import models.Ejemplar.Ejemplar;
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
    private Modificador modificador;
    private Prestamo prestamo;
    private Ejemplar ejemplar;
	private EstadoSocio state;
    
	public Socio(String nombre, String apellido, int dni, String mail, String telefono, MedioComunicacion medio,
			List<Prestamo> historiaPrestamos, List<Prestamo> prestamosActivos, Modificador modificador) {

		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.mail = mail;
		this.telefono = telefono;
		this.medio = medio;
		this.historiaPrestamos = historiaPrestamos;
		this.prestamosActivos = prestamosActivos;
		this.modificador = modificador;
		this.state = new Habilitado();
	}
	public Socio(){

	}
	
	
	
	
	

	public void setHistoriaPrestamos(List<Prestamo> historiaPrestamos) {
		this.historiaPrestamos = historiaPrestamos;
	}
	public String getMail() {
		return mail;
	}
	public String getTelefono() {
		return telefono;
	}
	public MedioComunicacion getMedio() {
		return medio;
	}
	public void setMedio(MedioComunicacion medio) {
		this.medio = medio;
	}
	public String getNombre() {
		return nombre;
	}
	public void SolicitarPrestamo(Ejemplar ejemplar) {

		this.state.solicitarPrestamo(this, ejemplar);
	}


	public List<Prestamo> getPrestamosActivos() {
		return prestamosActivos;
	}

	public List<Prestamo> getHistoriaPrestamos() {
		return historiaPrestamos;
		//actualizar parametro en diagrama
	}

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public Ejemplar getEjemplar() {
		return ejemplar;
	}

	public void suspender() {

		this.state = new Suspendido();
	}
	public EstadoSocio getState() {
		return state;
	}

	public Modificador getModificador() {
		return modificador;
	}

	public int getDni() {
		return dni;
	}

	public String toString() {
		return "Nombre: " + this.nombre + " Apellido; " + this.apellido ;
	}
    
    
    
}
