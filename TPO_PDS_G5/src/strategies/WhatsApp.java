package strategies;

public class WhatsApp implements NotificacionStrategy{


	@Override
	public void enviarNotificacion(Notificacion notificacion) {
		String mensaje = notificacion.getMensaje();
	    System.out.println("Enviando notificación por WhatsApp: " + mensaje);
	}

}
