package usuario;

import guardarropas.Guardarropa;

public class CuentaPremium implements Cuenta{
	
	@Override
	public boolean tieneGuardarropaLleno(Guardarropa guardarropa) {
		return false;
	}
}
