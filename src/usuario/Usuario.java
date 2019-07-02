package usuario;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import guardarropas.Guardarropa;

public abstract class Usuario {
	
	
	private List<Guardarropa> guardarropas = new ArrayList<>();
	
	public List<Guardarropa> getGuardarropas() {
		return guardarropas;
	}
	
	public void agregarGuardarropa(Guardarropa guardarropa) {
		guardarropas.add(requireNonNull(guardarropa));
		guardarropa.duenio(this);
	}
	
	public boolean tineGuardarropaLleno(Guardarropa guardarropa) {
		return true;
	}
	public void cargarEvento(LocalDate fecha, String descripcion, int ubicacion) throws Exception{
		
		Evento evento = new Evento(fecha, descripcion, this, ubicacion);
		
	
	}
	
	
}