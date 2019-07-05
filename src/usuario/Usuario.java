package usuario;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import guardarropas.Guardarropa;

public class Usuario {
	
	
	private List<Guardarropa> guardarropas = new ArrayList<>();
	
	private Cuenta tipoDeCuenta = new CuentaGratuita();
	
	public List<Guardarropa> getGuardarropas() {
		return guardarropas;
	}
	
	public void agregarGuardarropa(Guardarropa guardarropa) {
		guardarropas.add(requireNonNull(guardarropa));
		guardarropa.duenio(this);
	}
	
	public boolean tieneGuardarropaLleno(Guardarropa guardarropa) {
		return tipoDeCuenta.tieneGuardarropaLleno(guardarropa);
	}

	public Cuenta getTipoDeCuenta() {
		return tipoDeCuenta;
	}

	public void setTipoDeCuenta(Cuenta tipoDeCuenta) {
		this.tipoDeCuenta = tipoDeCuenta;
	}
	
	public void cargarEvento(LocalDate fecha, String descripcion, int ubicacion) throws Exception{
		Evento evento = new Evento(fecha, descripcion, this, ubicacion);
	}
}