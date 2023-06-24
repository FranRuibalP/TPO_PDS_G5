package adapters;
import models.Ejemplar.Ejemplar;

import java.util.ArrayList;

public interface IAdapterExterno  {
		static ArrayList<Integer> buscarEjemplar(Ejemplar ejemplar) {
			return AdapterExterno.buscarEjemplar(ejemplar);
		}
}
