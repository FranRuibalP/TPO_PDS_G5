package adapters;
import models.Ejemplar.Ejemplar;

public class Ubicacion {
	private int filas;
	private int columnas;
	
	public boolean buscarEjemplar() {
		Ejemplar Ejemplar = null;
		boolean encontrado=IAdapterExterno.buscarEjemplar(Ejemplar);
		return encontrado;
	}

}
