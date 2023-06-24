package strategies;

public class Mail implements NotificacionStrategy{


	@Override
	public void enviarNotificacion(Notificacion notificacion) {
		String mensaje = notificacion.getMensaje();
	    System.out.println("Enviando notificación por Mail: " + mensaje);
	}
	
}
