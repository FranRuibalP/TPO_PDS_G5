package models.Ejemplar;

import java.sql.Date;
import adapters.Ubicacion;
import models.Ejemplar.State.EstadoEjemplar;
import models.Ejemplar.State.Prestado;
import models.Ejemplar.State.Devuelto;

public class Ejemplar {
    private String id;
    private String titulo;
    private String autor;
    private Date fechaPublicacion;
    //private EstadoEjemplar estado;
    private Ubicacion ubicacion;
    private int diasPrestamo;

    private EstadoEjemplar state;
	

    
    public Ejemplar(String id, String titulo, String autor, Date fechaPublicacion, Ubicacion ubicacion) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.fechaPublicacion = fechaPublicacion;
		this.ubicacion = ubicacion;
		this.diasPrestamo = diasPrestamo;
		this.state=new Devuelto();
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

    public boolean solicitarEjemplar() {
        return state.solicitarEjemplar(this);

    }
    public int getDiasPrestamo() {
    	return diasPrestamo;
    }


    public Ejemplar(){

    }

	public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }
}
