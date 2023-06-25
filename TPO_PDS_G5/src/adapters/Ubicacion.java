package adapters;
import models.Ejemplar.Ejemplar;

import java.util.ArrayList;
import java.util.List;

public class Ubicacion {
	private Integer filas;
	private Integer columnas;
	
	public Ubicacion (int filas, int columnas) {
		
	}
	
	public ArrayList<Integer> buscarEjemplar(Ejemplar ejemplar) {

		ArrayList<Integer> encontrado=IAdapterExterno.buscarEjemplar(ejemplar);
		return encontrado;

	}

	public Integer getFilas() {
		return filas;
	}

	public Integer getColumnas() {
		return columnas;
	}
}

