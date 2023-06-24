package models.Ejemplar;

import java.sql.Date;
import adapters.Ubicacion;
import models.Ejemplar.State.EstadoEjemplar;
import models.Ejemplar.State.Prestado;
import models.Ejemplar.State.Devuelto;

public abstract class Ejemplar {
    private int id;
    private String titulo;
    private String autor;
    private Date fechaPublicacion;
    //private EstadoEjemplar estado;
    private Ubicacion ubicacion;
    private int diasPrestamo;

    private EstadoEjemplar state;
	
    public Ejemplar(int id, String titulo, String autor, Date fechaPublicacion, Ubicacion ubicacion) {
		
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.fechaPublicacion = fechaPublicacion;
		this.ubicacion = ubicacion;
        this.state = new Devuelto();

	}
    
    public void actualizarParam(int diasPrestamo) {

        this.diasPrestamo=diasPrestamo;
    }

    public void devuelto() {

        this.state = new Devuelto();
    }
    public void prestado() {

        this.state = new Prestado();
    }

    //solicitar ejemplar devuelve boolean
    public boolean solicitarEjemplar() {
        return state.solicitarEjemplar(this);

    }
    public int getDiasPrestamo() {
    	return diasPrestamo;
    }

    //buscar ejemplar devuelve Ejemplar
    public Ejemplar buscarEjemplarId(int id) {
        //list ejemplares
        //for ejemplares
        //if ejemplar.id == id
        //return ejemplar
        return null;
    }
    public Ejemplar buscarEjemplarPorTitulo(String titulo) {
        //list ejemplares
        //for ejemplares
        //if ejemplar.titulo == titulo
        //return ejemplar
        return null;
    }
    public Ejemplar buscarEjemplarPorAutor(String autor) {
        //list ejemplares
        //for ejemplares
        //if ejemplar.autor == autor
        //return ejemplar
        return null;
    }
    public Ejemplar buscarEjemplarPorFecha(Date fecha) {
        //list ejemplares
        //for ejemplares
        //if ejemplar.fecha == fecha
        //return ejemplar
        return null;
    }

	public Ubicacion getUbicacion() {
        return ubicacion;
    }
    
}
