package adapters;

import models.Ejemplar.Ejemplar;

import java.util.ArrayList;


public class AdapterExterno implements IAdapterExterno {
	
	public static ArrayList<Integer> buscarEjemplar(Ejemplar ejemplar) {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		lista.add(1);
		lista.add(2);
		return lista;
	}

}
