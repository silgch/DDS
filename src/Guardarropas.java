package guardarropas;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;

import uniformes.Atuendo;
import prendas.Prenda;


public class Guardarropa {
	private final List<Prenda> prendas = new ArrayList<>(); //Un guardarropas es una lista de prendas

	public List<Prenda> getPrendas() {
		return prendas;
	}
	
	public void agregarPrenda(Prenda prenda) {
		prendas.add(requireNonNull(prenda));
	}
	

}