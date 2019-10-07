package usuario;

public class CuentaGratuita implements Cuenta{
	int maximoDePrendas=10;
	
	@Override
	public boolean tieneGuardarropaLleno(int cantidadDePrendas) {
		return !(cantidadDePrendas < maximoDePrendas);
	}
}
