package models;
import models.Socio;

public class Modificador {

	private int diasPenalizacion;
	private int prestamosEnTiempo;
	private Socio socio;
	
	public void actualizarDias(int dias) {
		socio.getEjemplar().actualizarParam(dias);
	}
	
}
