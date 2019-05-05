package uniformes;

import prendas.Prenda;
import uniformes.Uniforme;


public class Atuendo extends Uniforme {
	//Un Atuendo es una combinación de prendas que tiene sentido usar juntas.
	//Un Atuendo es una clase de uniforme que ademas de las tres prendas 
	//(parte superior, parte inferior, calzado) lleva un accesorio
	private final Prenda accesorio;
	
	//Constructor
	public Atuendo(Prenda parteSuperior, Prenda parteInferior, Prenda calzado, Prenda accesorio) {
		super(parteSuperior, parteInferior, calzado);
		this.accesorio = accesorio;
	}
	//Devuelve el accesorio del atuendo.
	public Prenda getAccesorio() {
		return accesorio;
	}
}