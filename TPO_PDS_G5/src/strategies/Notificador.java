package strategies;
import strategies.NotificacionStrategy;
import strategies.Notificacion;

public class Notificador {
	
	private NotificacionStrategy estrategia;
	private Notificacion notificacion;
	
	public void setEstrategia(NotificacionStrategy estrategia) {
		this.estrategia=estrategia;
	}
	
	public void enviarNotificacion(Notificacion notificacion) {
		estrategia.enviarNotificacion(notificacion);
	}
	

	public Notificacion getNotificacion() {
		return notificacion;
	}
	
	
	
	

}
