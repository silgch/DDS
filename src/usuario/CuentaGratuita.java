package usuario;

import guardarropas.Guardarropa;

public class CuentaGratuita implements Cuenta{
	int maximoDePrendas=10;
	
	@Override
	public boolean tieneGuardarropaLleno(Guardarropa guardarropa) {
		return !(guardarropa.cantidadDePrendas()<maximoDePrendas);
	}
}
