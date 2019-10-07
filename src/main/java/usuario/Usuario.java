package usuario;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import eventos.CommandParaEventos;
import eventos.EnumEstadoSugerencia;
import eventos.Evento;
import eventos.Sugerencia;
import guardarropas.Guardarropa;

public class Usuario {
	
	private String nombreDeUsuario;
	private String mail;
	private List<Guardarropa> guardarropas = new ArrayList<>();
	private List<Evento> eventos = new ArrayList<Evento>();
	private GestorDeCuentas gestorCuenta;
	private Cuenta tipoDeCuenta;
	private PercepcionDeTemperatura percepcion = new PercepcionDeTemperatura(); 
	
	public Usuario(String nombre){
		this.nombreDeUsuario = nombre;
		gestorCuenta = new GestorDeCuentas();
		tipoDeCuenta = gestorCuenta.creameUnaCuenta();
	}
	
	// Getters
	public List<Guardarropa> getGuardarropas() {
		return guardarropas;
	}
	public Cuenta getTipoDeCuenta() {
		return tipoDeCuenta;
	}
	public String getNombre() {
		return nombreDeUsuario;
	}
	public PercepcionDeTemperatura getPercepcion() {
		return percepcion;
	}
	public String getMail() {return mail;}
	
	// Setters
	public void setNombre(String nombre) {
		this.nombreDeUsuario =nombre;
	}
	
	public void setTipoDeCuenta(Cuenta tipoDeCuenta) {
		this.tipoDeCuenta = tipoDeCuenta;
	}
	public void setMail(String m) {this.mail = m;}
	
	//Métodos con tipo de Cuenta
	public void upgradearTipoDeCuenta(){
		gestorCuenta.upgradear(tipoDeCuenta);
	}
	
	// Métodos con guardarropas
	
	/*
	 * La idea es que cada usuario tenga guardarropas propio, con limite dado por su tipo
	 * de cuenta, sin embargoun usario puede compartir su guardarropa con otra persona 
	 * (algo así como el drive de google). Y lo que hace 
	 * compartirGuardarropasCon(guardarropa,otroUsuario) es agregar un guardarropa propio 
	 * a la lista de guardarropas de otrousario 
	 */
	
	public void agregarGuardarropa(Guardarropa guardarropa) {
		guardarropas.add(requireNonNull(guardarropa));
		guardarropa.duenio(this);
	}
	
	public void compartirGuardarropasCon(Guardarropa guardarropa, Usuario otroUsuario) {
		otroUsuario.agregarGuardarropaCompartido(guardarropa);
	}
	
	public void agregarGuardarropaCompartido(Guardarropa guardarropa) {
		guardarropas.add(requireNonNull(guardarropa));
	}
	
	public boolean tieneGuardarropaLleno(int cantidadDePrendas) {
		return tipoDeCuenta.tieneGuardarropaLleno(cantidadDePrendas);
	}
	

	
	//Métodos con Eventos
	public void cargarEvento(LocalDate fecha, String descripcion, int ubicacion) throws Exception{
		Evento evento = new Evento(fecha, descripcion, this, ubicacion);
		this.eventos.add(evento);
		evento.procesarEvento();
	}
	/*
	public void procesarEvento(Evento evento) throws IOException {
		CommandParaEventos sugerenciaParaEvento = new CommandParaEventos();
		sugerenciaParaEvento.execute(evento);

	}/
	
	
	//Métodos con Sugerencias
	
	/*
	 	 
	 La idea es que el usuario una vez aceptada una sugerencia, la evalue en su conjunto con valores 
	 del 1 al 3, en caso de que el usuario elija 1, no se volverá a sugerir dicha sugerencia, 
	 3, la sugerencia se guardara como favoritas, y 2 la sugerencia no se guardará
	 luego el usuario deberá calificar parte por parte para saber que tan friolento o caluroso es en esa 
	 parte del cuerpo este valor es del -2 al 2, siendo (-2) algo asi como que el usuario se está 
	 cagando de frio con eso y (+2) que se está cagando de calor 
	 
	 */
	
	public void aceptarSugerencia(Sugerencia unaSugerencia) {
		unaSugerencia.setEstado(EnumEstadoSugerencia.ACEPTADA);
	}
	
	public void rechazarSugerencia(Sugerencia unaSugerencia) {
		unaSugerencia.setEstado(EnumEstadoSugerencia.RECHAZADA);
	}
	

	public void calificarSugerencia(Sugerencia unaSugerencia, int unaCalificacion) throws Exception {
		System.out.println("El usuario " + this.getNombre() + " ha calificado con \"" +
				unaCalificacion+"\" la sugerencia ("+unaSugerencia.getEstado()+"): "+unaSugerencia.getDescripcion());
		if( unaSugerencia.getEstado() == EnumEstadoSugerencia.ACEPTADA) {
			unaSugerencia.setCalificacion(unaCalificacion);
		}else {
			throw new Exception("Solo se pueden calificar sugerencias ACEPTADAS");
		}
	}
	
	public void calificarMiPercepcion(int percepcionCabeza,	int percepcionTorso,int percepcionPiernas) {
		percepcion.modificarPercepcionCabeza(percepcionCabeza); 
		percepcion.modificarPercepcionTorso(percepcionTorso); 
		percepcion.modificarPercepcionPiernas(percepcionPiernas); 
	}
	
}