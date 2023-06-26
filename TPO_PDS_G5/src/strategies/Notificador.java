package strategies;
import strategies.NotificacionStrategy;
import enumerations.MedioComunicacion;
import models.Socio.Socio;
import strategies.Notificacion;

public class Notificador {
	
	private NotificacionStrategy estrategia;
	private Notificacion notificacion;
	
	public void Cambio(MedioComunicacion medio) {
		this.estrategia=aEstrategia(medio);
	}
	
	public NotificacionStrategy aEstrategia(MedioComunicacion medio) {
		
		if (medio.equals(MedioComunicacion.SMS)) {
			estrategia=new SMS();
		}
		if (medio.equals(MedioComunicacion.WHATSAPP)) {
			estrategia=new WhatsApp();
		}
		if (medio.equals(MedioComunicacion.EMAIL)) {
			estrategia=new Mail();
		}
		
		return estrategia;
	}
	
	public void setEstrategia(NotificacionStrategy estrategia) {
		
		this.estrategia=estrategia;
		
		
	}
	
	
	public NotificacionStrategy getEstrategia() {
		return estrategia;
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
