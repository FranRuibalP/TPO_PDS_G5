package strategies;
import strategies.NotificacionStrategy;

public class Notificador {
	
	private NotificacionStrategy estrategia;
	
	public void setEstrategia(NotificacionStrategy estrategia) {
		this.estrategia=estrategia;
	}
	
	public void enviarNotificacion(Notificacion notificacion) {
		estrategia.enviarNotificacion(notificacion);
	}
	

}
