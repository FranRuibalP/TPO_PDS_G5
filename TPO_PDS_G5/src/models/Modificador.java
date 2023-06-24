package models;
import models.Socio.Socio;
import models.Socio.State.Suspendido;

public class Modificador {

	private int diasPenalizacion = 0;
	private int prestamosEnTiempo = 0;
	private Socio socio;


	public int getDias() {
		return diasPenalizacion;
	}

	public void setDias(int diferenciaEnDias) {

		this.diasPenalizacion += diferenciaEnDias;
		if (this.diasPenalizacion >= 10) {
			this.diasPenalizacion = 0;
			this.socio.suspender();
		}
	}

	public void setPrestamosEnTiempo() {

		this.prestamosEnTiempo += 1;
		if (this.prestamosEnTiempo == 5) {
			this.prestamosEnTiempo = 0;
			this.diasPenalizacion -= 1;
		}
	}
}
