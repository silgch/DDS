package usuario;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import componentes.Prenda;
import eventos.CommandParaEventos;
import eventos.Evento;
import eventos.GeneradorDeSugerencias;
import guardarropas.Guardarropa;


@Entity
@Table(name = "usuario")
public class Usuario{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;	

	private String userName;
	@SuppressWarnings("unused")
	private String nombre;
	@SuppressWarnings("unused")
	private String apellido;
	private String mail;
	private String password;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy= "usuario")
	private List<Evento> eventos = new ArrayList<>();
	
	@OneToMany(mappedBy= "miDuenio")
	private List<Guardarropa> guardarropas = new ArrayList<>();
	
	@OneToMany(mappedBy= "usuarioParasito")
	private List<Guardarropa> guardarropasCompartidos = new ArrayList<>();

	/*El gestorDeCuentas es el asistente que entrega/upgredea la cuenta del usuario
	 * no hace falta persistirlo*/
	
	@Transient 
	public List<Prenda> sugerenciaTemporal;	

	private boolean usuario_premium = false;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "percepcion_id", referencedColumnName = "id")
	private PercepcionDeTemperatura percepcion ;
	
	@Transient
	private CommandParaEventos managerDeEventos;
	
	public Usuario() {}
	
	public Usuario(String name){
		this.userName = name;
		percepcion = new PercepcionDeTemperatura();
		managerDeEventos = new CommandParaEventos(this);
		}
	
	// Getters
	public List<Guardarropa> getGuardarropas() {
		return guardarropas;
	}
	public String getUserName() {
		return userName;
	}
	public PercepcionDeTemperatura getPercepcion() {
		return percepcion;
	}
	public String getMail() {return mail;}
	
	public String getPass() {return password;}
	
	public CommandParaEventos getManagerDeEventos() {
		return managerDeEventos;
	}
	public boolean esPobre() {
		return !(this.usuario_premium);
	}

	
	// Setters
	/*public void setTipoDeCuenta(Cuenta tipoDeCuenta) {
		this.tipoDeCuenta = tipoDeCuenta;
	}*/
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
	 * de cuenta, sin embargo un usario puede compartir su guardarropa con otra persona 
	 * (algo así como el drive de google). Y lo que hace 
	 * compartirGuardarropasCon(guardarropa,otroUsuario)
	 */
	
	public void agregarGuardarropa(Guardarropa guardarropa) {
		guardarropas.add(requireNonNull(guardarropa));
		guardarropa.duenio(this);
	}
	
	//un guardarropa solo se puede compartir con un usuario
	
	public void compartirGuardarropasCon(Guardarropa guardarropa, Usuario otroUsuario) {
		otroUsuario.agregarGuardarropaCompartido(guardarropa);
	}
	
	private void agregarGuardarropaCompartido(Guardarropa guardarropa) {
		guardarropasCompartidos.add(requireNonNull(guardarropa));
	}
	
	/*public boolean tieneGuardarropaLleno(int cantidadDePrendas) {
		return tipoDeCuenta.tieneGuardarropaLleno(cantidadDePrendas);
	}*/	

	

	//Métodos con Sugerencias
	
	/*
	 	 
	 La idea es que el usuario una vez aceptada una sugerencia, la evalue en su conjunto con valores 
	 del 1 al 3, en caso de que el usuario elija 1, no se volverá a sugerir dicha sugerencia, 
	 3, la sugerencia se guardara como favoritas, y 2 la sugerencia no se guardará
	 luego el usuario deberá calificar parte por parte para saber que tan friolento o caluroso es en esa 
	 parte del cuerpo este valor es del -2 al 2, siendo (-2) algo asi como que el usuario se está 
	 cagando de frio con eso y (+2) que se está cagando de calor 
	 
	 */
	public void pedirSugerencia() throws Exception {
		managerDeEventos.generarSugerenciaParaUltimoEventoCreado();
	}
	
	public List<Prenda> pedirSugerencia2(Evento evento) throws Exception {
		
		List<Prenda> sugerencia = new GeneradorDeSugerencias().sugerirEnBaseAPersepcion(evento.getGuardaropa(), this, evento);
		sugerenciaTemporal = sugerencia;
		return sugerencia;
	}
	
	/*public List<Prenda> pedirSugerenciaUltimoEvento() throws Exception {
		return managerDeEventos.generarSugerenciaParaUltimoEvento();
	}*/
	

}