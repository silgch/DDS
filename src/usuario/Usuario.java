package usuario;

import static java.util.Objects.requireNonNull;

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
}