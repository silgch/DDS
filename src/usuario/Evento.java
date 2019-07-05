package usuario;

import java.time.LocalDate;
import guardarropas.Guardarropa;

public class Evento {

	private LocalDate fechaEvento;
	private String descripcion;
	private Usuario usuario;
	private int ubicacion; // Guardar el CP del lugar del evento
	private Guardarropa unGuardarropa;
	
	
	public Evento(LocalDate fechaEvento, String descripcion, Usuario usuario, int ubicacion) {
		
		this.fechaEvento = fechaEvento;
		this.descripcion = descripcion;
		this.usuario = usuario;
		this.ubicacion = ubicacion;
		
	}
	//Setter
	public void setFechaEvento(LocalDate fechaEvento) {
		this.fechaEvento = fechaEvento;
	}
	public void setUbicacion(int ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	public void setGuardaropa(Guardarropa unGuardaropa) {
		this.unGuardarropa = unGuardarropa;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	//Getter
	public LocalDate getFechaEvento() {
		return fechaEvento;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public int getUbicacion() {
		return ubicacion;
	}
	
	public Guardarropa getGuardaropa() {
		return unGuardarropa;
	}
	

	
	
}
