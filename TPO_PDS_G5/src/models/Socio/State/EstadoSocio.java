package models.Socio.State;
import models.Ejemplar.Ejemplar;
import models.Socio.Socio;
import models.Prestamo;

public interface EstadoSocio {
     Prestamo solicitarPrestamo(Socio socio,Ejemplar ejemplar);
}
