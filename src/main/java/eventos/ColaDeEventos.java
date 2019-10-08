/*package eventos;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ColaDeEventos {
	
	public Set<Evento> colaEventosActivos = new HashSet<Evento>();
		
	public ColaDeEventos() {
		this.colaEventosActivos= new LinkedList<Evento>();
	}
	
	
	public Queue<Evento> getColaEventosActivos() {
		return colaEventosActivos;
	}
	
	
	public void encolarEvento(Evento evento) {
		colaEventosActivos.add(evento);
		System.out.println("El usuario " + evento.getUsuario().getNombre() +
				" agregó el evento " + evento.getDescripcion()+
				" a realizarse el " + evento.getFechaEvento());
	}
	
	
}*/
