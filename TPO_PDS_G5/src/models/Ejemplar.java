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
}
