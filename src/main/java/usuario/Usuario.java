package usuario;

import static java.util.Objects.requireNonNull;
import static usuario.Cuenta.nombre;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

//import eventos.ColaDeEventos;
import eventos.CommandParaEventos;
import eventos.Evento;
//import eventos.Evento;
import eventos.Sugerencia;
import guardarropas.Guardarropa;


@Entity
@Table(name = "usuario")
public class Usuario{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	

	private String userName;
	private String nombre;
	private String apellido;
	private String mail;
	private String password;

	
	@OneToMany(cascade=CascadeType.ALL, mappedBy= "usuario")
	private List<Evento> eventos = new ArrayList<>();
	
	@OneToMany(mappedBy= "miDuenio")
	private List<Guardarropa> guardarropas = new ArrayList<>();

	/*El gestorDeCuentas es el asistente que entrega/upgredea la cuenta del usuario
	 * no hace falta persistirlo*/
	
	@Transient 
	private GestorDeCuentas gestorCuenta;
	@Transient // Ver si es necesario persistirlo.
	private Cuenta tipoDeCuenta;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "preferencias", referencedColumnName = "id")
	private PercepcionDeTemperatura percepcion ;
	
	@Transient
	private CommandParaEventos managerDeEventos;
	//private String tipoDeUsuario;
	
	public Usuario() {}
	
	public Usuario(String name){
		this.userName = name;
		gestorCuenta = new GestorDeCuentas();
		percepcion = new PercepcionDeTemperatura();
		managerDeEventos = new CommandParaEventos(this);
		tipoDeCuenta = gestorCuenta.creameUnaCuenta();
		//tipoDeUsuario = this.tipoDeCuenta.nombre;
		}
	
	// Getters
	public List<Guardarropa> getGuardarropas() {
		return guardarropas;
	}
	public Cuenta getTipoDeCuenta() {
		return tipoDeCuenta;
	}
	public String getUserName() {
		return userName;
	}
	public PercepcionDeTemperatura getPercepcion() {
		return percepcion;
	}
	public String getMail() {return mail;}
	
	
	public CommandParaEventos getManagerDeEventos() {
		return managerDeEventos;
	}
	public String getApellido() {
		return apellido;
	}
	public String getNombre() {
		return nombre;
	}

	
	// Setters
	public void setTipoDeCuenta(Cuenta tipoDeCuenta) {
		this.tipoDeCuenta = tipoDeCuenta;
	}
	public void setMail(String m) {this.mail = m;}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public void crearEvento(LocalDate fecha, String descripcion, String ubicacion) throws Exception{
		managerDeEventos.crearEvento( fecha, descripcion, ubicacion);
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
	public void pedirSugerencia(Guardarropa unGuardarropa) throws Exception {
		managerDeEventos.generarSugerenciaParaUltimoEventoCreado(unGuardarropa);
	}
	
	public void aceptarSugerencia(Sugerencia sugerencia) {
		managerDeEventos.aceptarSugerencia(sugerencia);
	}
	
	public void rechazarSugerencia(Sugerencia sugerencia) {
		managerDeEventos.rechazarSugerencia(sugerencia);
	}
	

	/*public void calificarSugerencia(Sugerencia unaSugerencia, int unaCalificacion) throws Exception {
		System.out.println("El usuario " + this.getNombre() + " ha calificado con \"" +
				unaCalificacion+"\" la sugerencia" +
				unaSugerencia.devolverSugerenciaEnFormaDeString());
		if( unaSugerencia.getEstado() == EnumEstadoSugerencia.ACEPTADA) {
			unaSugerencia.setCalificacion(unaCalificacion);
		}else {
			System.out.println("Solo se pueden calificar sugerencias ACEPTADAS");
		}
	}*/
	
}