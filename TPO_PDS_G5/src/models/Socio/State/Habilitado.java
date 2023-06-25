package models.Socio.State;

import models.Ejemplar.Ejemplar;
import models.Prestamo;
import models.Socio.Socio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class Habilitado implements EstadoSocio{
    Date fecha = new Date(System.currentTimeMillis());

    public Prestamo solicitarPrestamo(Socio socio, Ejemplar ejemplar){
    	
        if(ejemplar.solicitarEjemplar()){
        	Prestamo prestamito=new Prestamo(ejemplar, socio);
        	socio.getPrestamosActivos().add(prestamito);
            ejemplar.prestado();
            return prestamito;
        }
        return null;
    }
}

/*
String dateString = "15/02/1999";
DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
 */
