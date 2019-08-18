package usuario;

import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import componentes.Prenda;
import eventos.CommandObtenerSugerenciaParaEvento;
import eventos.EnumEstadoSugerencia;
import eventos.Evento;
import eventos.Sugerencia;
import guardarropas.Guardarropa;

public class Usuario {
	
	private String nombreDeUsuario;
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
	public void setNombre(String nombre) {
		this.nombreDeUsuario =nombre;
	}
	
	public void setTipoDeCuenta(Cuenta tipoDeCuenta) {
		this.tipoDeCuenta = tipoDeCuenta;
	}
	
	public void cargarEvento(LocalDate fecha, String descripcion, int ubicacion) throws Exception{
		Evento evento = new Evento(fecha, descripcion, this, ubicacion);
		this.eventos.add(evento);
		evento.procesarEvento();
	}
	
	public void procesarEvento(Evento evento) throws IOException {
		
		CommandObtenerSugerenciaParaEvento sugerenciaParaEvento = new CommandObtenerSugerenciaParaEvento();
		sugerenciaParaEvento.execute(evento);

	}
	
	public String getNombre() {
		return nombreDeUsuario;
	}
	
	public void calificarSugerencia(Sugerencia unaSugerencia, int unaCalificacion) throws Exception {
		// los usuarios tendrán la posibilidad de, una vez aceptada una sugerencia, calificarla. 
		
		if( unaSugerencia.getEstado()== EnumEstadoSugerencia.ACEPTADA) {
		
			unaSugerencia.setCalificacion(unaCalificacion);
		}
		else {
			throw new Exception("Ingrese una sugerencia ACEPTADA");
		}
	}
	
	public void aceptarSugerencia(Sugerencia unaSugerencia) {
		unaSugerencia.setEstado(EnumEstadoSugerencia.ACEPTADA);
	
	}
	
	public void rechazarSugerencia(Sugerencia unaSugerencia) {
		unaSugerencia.setEstado(EnumEstadoSugerencia.RECHAZADA);
	
	}
	
	public void calificarPrenda(Prenda unaPrenda, int calificacion) {
		unaPrenda.setCalificacion(calificacion);
		
	}
	
}