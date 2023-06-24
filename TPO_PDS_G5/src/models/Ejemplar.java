package models;

import java.sql.Date;
import adapters.Ubicacion;

public abstract class Ejemplar {
    private int id;
    private String titulo;
    private String autor;
    private Date fechaPublicacion;
    //private EstadoEjemplar estado;
    private Ubicacion ubicacion;
	
    public Ejemplar(int id, String titulo, String autor, Date fechaPublicacion, Ubicacion ubicacion) {
		
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.fechaPublicacion = fechaPublicacion;
		this.ubicacion = ubicacion;
	}
    
    
	
    
}
