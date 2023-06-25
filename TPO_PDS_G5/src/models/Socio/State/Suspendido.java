package models.Socio.State;
import models.Socio.Socio;
import models.Prestamo;
import models.Ejemplar.Ejemplar;
public class Suspendido implements EstadoSocio{
    public Prestamo solicitarPrestamo(Socio socio, Ejemplar ejemplar){
        System.out.println("El socio esta suspendido");
		return null;
    }
}
