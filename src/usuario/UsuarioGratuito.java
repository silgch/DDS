package usuario;

import guardarropas.Guardarropa;

public class UsuarioGratuito extends Usuario{
	int maximoDePrendas=10;
	
	public boolean tineGuardarropaLleno(Guardarropa guardarropa) {
		return !(guardarropa.cantidadDePrendas()<maximoDePrendas);
	}
}
