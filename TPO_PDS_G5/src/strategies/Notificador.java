package strategies;
import strategies.NotificacionStrategy;
import enumerations.MedioComunicacion;
import models.Socio.Socio;
import strategies.Notificacion;

public class Notificador {
	
	private NotificacionStrategy estrategia;
	private Notificacion notificacion;
	
	public void setEstrategia(MedioComunicacion medio) {
		
		

		if (medio.equals(MedioComunicacion.SMS)) {
			NotificacionStrategy estrategia=new SMS();
			estrategia.enviarNotificacion(notificacion);
		}
		if (medio.equals(MedioComunicacion.WHATSAPP)) {
			NotificacionStrategy estrategia=new WhatsApp();
			estrategia.enviarNotificacion(notificacion);
		}
		if (medio.equals(MedioComunicacion.EMAIL)) {
			NotificacionStrategy estrategia=new Mail();
			estrategia.enviarNotificacion(notificacion);
		}
		
		NotificacionStrategy estrategia=new Mail();
		estrategia.enviarNotificacion(notificacion);
		
	}
	
	public void enviarNotificacion(Notificacion notificacion, Socio socio) {
		
			
		estrategia.enviarNotificacion(notificacion);
	}
	

	public Notificacion getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(Notificacion notificacion) {
		this.notificacion = notificacion;
	}
	
	


}
