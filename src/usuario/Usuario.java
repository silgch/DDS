package usuario;

import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import eventos.CommandObtenerSugerenciaParaEvento;
import eventos.Evento;
import guardarropas.Guardarropa;

public class Usuario {
	
	
	private List<Guardarropa> guardarropas = new ArrayList<>();
	private List<Evento> eventos = new ArrayList<Evento>();
	
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
		this.eventos.add(evento);
		evento.ProcesarEvento();
	}
	
	public void ProcesarEvento(Evento evento) throws IOException {
		
		CommandObtenerSugerenciaParaEvento sugerenciaParaEvento = new CommandObtenerSugerenciaParaEvento();
		sugerenciaParaEvento.Execute(evento);

	}
}