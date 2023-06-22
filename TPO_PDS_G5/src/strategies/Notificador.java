package strategies;
import strategies.NotificacionStrategy;

public class Notificador {
	
	private static NotificacionStrategy estrategia;
	
	public static void CambiarEstrategia (NotificacionStrategy estrategia) {
		Notificador.estrategia=estrategia;
	}
	
	public static void enviarNotificacion(Notificacion notificacion) {
		
	}

}
