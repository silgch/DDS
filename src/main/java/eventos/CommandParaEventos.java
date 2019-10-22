package eventos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import componentes.Prenda;
import guardarropas.Guardarropa;
import usuario.Usuario;


//Asistente de eventos
@Entity
public class CommandParaEventos /*implements ICommand*/ {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	public CommandParaEventos() {}
	
	//private GestorDeClimaAPIs gestorDeAPIs;
	//private ClimaAdapter api1 = gestorDeAPIs.entregarAPI();
	
	@OneToOne
	@JoinColumn(name = "usuarioAsociado", referencedColumnName = "id")
	private Usuario usuario;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "perteneceALaColaDeEventos", referencedColumnName = "id")
	private Set<Evento> colaEventosActivos = new HashSet<Evento>();

	
	@Transient
	private List<Prenda> listaDePrendasTemporal;
	@Transient
	private Guardarropa guardarropaTemporal;
	@Transient
	private Evento eventoTemporal;
	@Transient
	private GeneradorDeSugerencias sugiridor = new GeneradorDeSugerencias();

	
	public CommandParaEventos(Usuario miUsuario) {
		usuario = miUsuario;
	}
	
	public void crearEvento(LocalDate fecha, String descripcion, String ubicacion) throws Exception{
		Evento evento = new Evento(fecha, descripcion, usuario, ubicacion);
		this.getColaEventosActivos().add(evento);
		System.out.println("El usuario " + usuario.getNombre() +
				" agregó el evento " + evento.getDescripcion()+
				" a realizarse el " + evento.getFechaEvento());
		eventoTemporal = evento;
	}
	public void generarSugerenciaPara(Guardarropa unGuardarropa,Evento evento) throws Exception {
		//String codigoCiudad = "3433955" es para CABA;
		listaDePrendasTemporal = sugiridor.sugerirEnBaseAPersepcion(unGuardarropa, usuario, evento);	
		guardarropaTemporal = unGuardarropa;
		eventoTemporal = evento;
	}
	public void generarSugerenciaParaUltimoEventoCreado(Guardarropa unGuardarropa) throws Exception {
		this.generarSugerenciaPara(unGuardarropa, eventoTemporal);
	}
	
	public void aceptarSugerencia(Sugerencia sugerencia) {
		sugerencia.setEstado(EnumEstadoSugerencia.ACEPTADA);
		eventoTemporal.setSugerencia(sugerencia);
		eventoTemporal.setGuardaropa(guardarropaTemporal);
		System.out.println("La sugerencia: "+
		sugerencia.devolverSugerenciaEnFormaDeString()+
		" ha sido aceptada");
	}
	
	public void rechazarSugerencia(Sugerencia sugerencia) {
		sugerencia.setEstado(EnumEstadoSugerencia.RECHAZADA);
		System.out.println("La sugerencia: "+
				sugerencia.devolverSugerenciaEnFormaDeString()+
				" ha sido rechazada");
	}
	
	public void eliminarEvento(Evento evento) {
		evento.liberameTodasLasPrendas();
		colaEventosActivos.remove(evento);
		this.liberarRecursos();
	}
	
	public void liberarRecursos() {
		listaDePrendasTemporal = null;
		guardarropaTemporal = null;
		eventoTemporal = null;		
	}
	

	public Set<Evento> getColaEventosActivos() {
		return colaEventosActivos;
	}
	
	public List<Prenda> getListaDePrendasTemporal() {
		return listaDePrendasTemporal;
	}
	
	
	
	
	

}