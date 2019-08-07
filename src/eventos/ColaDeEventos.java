package eventos;

import java.util.LinkedList;
import java.util.Queue;

public class ColaDeEventos {


	private Queue<Evento> colaEventosActivos;
	
	public ColaDeEventos() {
			
		this.colaEventosActivos= new LinkedList<Evento>();
	}
	
	
	public Queue<Evento> getColaEventosActivos() {
		return colaEventosActivos;
	}
	
	
	public void encolarEvento(Evento evento) {
		colaEventosActivos.add(evento);
	
		System.out.println("El usuario " + evento.getUsuario().getNombre() + " agregó el evento  "+evento.getDescripcion()+" a realizarse el " + evento.getFechaEvento());
	}
	
	
}
