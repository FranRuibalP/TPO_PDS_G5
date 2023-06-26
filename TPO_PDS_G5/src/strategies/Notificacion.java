package strategies;

import java.sql.Date;

public class Notificacion {
	
	private String mensaje;
	private Date fecha;
	private String motivo;
	private String telefono;
	private String email;
	
	
	
	public Notificacion(Date fecha, String mensaje, String motivo, String telefono, String email) {
		super();
		this.mensaje=mensaje;
		this.fecha = fecha;
		this.motivo = motivo;
		this.telefono = telefono;
		this.email = email;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return this.mensaje + this.motivo  ;
	}

}
