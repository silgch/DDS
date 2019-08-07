package eventos;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import guardarropas.Guardarropa;
import usuario.Usuario;
//Agregar anularSugerenciaElegida, que vuelva para atras la sugerencia aceptada.
public class Evento {

	private LocalDate fechaEvento;
	private String descripcion;
	private Usuario usuario;
	private int ubicacion; // Guardar el CP del lugar del evento
	private Guardarropa unGuardarropa;
	private Double temperatura;
	private List<Sugerencia> sugerencias = new ArrayList<Sugerencia>();
	private ColaDeEventos servidorDeEventos = new ColaDeEventos();
	
	public ColaDeEventos getColaDeEventos() {
		return servidorDeEventos;
	}

	
	public Evento(LocalDate fechaEvento, String descripcion, Usuario usuario, int ubicacion) {
		
		this.fechaEvento = fechaEvento;
		this.descripcion = descripcion;
		this.usuario = usuario;
		this.ubicacion = ubicacion;
		
	}
	
	//Agrego el evento a la cola
	public void procesarEvento() throws IOException {
		
		 this.servidorDeEventos.encolarEvento(this);
	
	}
	
	
	
	//Setter
	public void setFechaEvento(LocalDate fechaEvento) {
		this.fechaEvento = fechaEvento;
	}
	public void setUbicacion(int ubicacion) {
		this.ubicacion = ubicacion;
	}
	public void setTemperatura (Double temperatura) { // Guarda la temperatura promedio para el evento.
		this.temperatura = temperatura;
	}
	public void setGuardaropa(Guardarropa unGuardaropa) {
		this.unGuardarropa = unGuardarropa;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setSugerencias(List<String> unaLista) {
		for(String elemento : unaLista) {
			Sugerencia auxiliar = new Sugerencia();
			
			auxiliar.setDescripcion(elemento);
			auxiliar.setEstado(EnumEstadoSugerencia.SUGERIDA);
			
			sugerencias.add(auxiliar);
		}
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
	
	public Double getTemperatura(){
		return temperatura;
	}
	
	public Guardarropa getGuardaropa() {
		return unGuardarropa;
	}
	
	public List<Sugerencia> getSugerencias() {
		return sugerencias;
	}

	
	
}
