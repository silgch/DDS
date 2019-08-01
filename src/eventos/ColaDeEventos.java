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
	
	
	public void EncolarEvento(Evento evento) {
		colaEventosActivos.add(evento);
	}
	
	
}
