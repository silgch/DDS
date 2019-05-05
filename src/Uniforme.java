package uniformes;
import prendas.Prenda;

public class Uniforme {
	private final Prenda parteSuperior, parteInferior, calzado;
	
	//Constructor: Un uniforme consta de 3 partes: Parte Superior + Parte Inferior + Calzado
	public Uniforme(Prenda parteSuperior, Prenda parteInferior, Prenda calzado) {
		this.parteSuperior = parteSuperior;
		this.parteInferior = parteInferior;
		this.calzado = calzado;
	}

	public Prenda getParteSuperior() {
		return parteSuperior;
	}

	public Prenda getParteInferior() {
		return parteInferior;
	}

	public Prenda getCalzado() {
		return calzado;
	}
}
