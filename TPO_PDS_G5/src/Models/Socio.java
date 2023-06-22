package Models;

import java.util.List;


public class Socio {
    private String nombre;
    private String apellido;
    private int dni;
    private String mail;
    private String telefono;
    private MedioComunicacion medio;
    private List<Prestamos> historiaPrestamos;
    private List<Prestamos> prestamosActivos;
    private Modificador modificadores;

}
