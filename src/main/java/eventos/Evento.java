/*
 * DESCRIPCION DE COMO FUNCIONAN LOS EVENTOS:
 * 
 *   	ines.crearEvento(LocalDate.now(), "Miamiii", "4174383"); 											-USA EL CommandParaEventos-USA el Evento-
	    ines.pedirSugerencia(guardarropaInesUno); 															-USA EL CommandParaEventos-
	    Sugerencia sugerencia1 = new Sugerencia(ines.getManagerDeEventos().getListaDePrendasTemporal());	-USA EL CommandParaEventos-
	    -PEDIR OPINIÓN DE INES SOBRE LA SUGERENCIA-
	    ines.aceptarSugerencia(sugerencia1);	    
	    ines.getPercepcion().modificarPercepcion...;	    
	    repositorio.percepcion_temperatura().actualizar(ines.preferencias); //o algo asi
	    repositorio.evento().persistir(ines.getManagerDeEventos().getEventoTemporal());
 */

package eventos;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import componentes.Prenda;

import java.time.Period;

import guardarropas.Guardarropa;
import usuario.Usuario;

@Entity
@Table(name = "evento")
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	public Evento() {}	
	
	private LocalDate fechaEvento;
	private String descripcion;
	
	@ManyToOne( cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "usuario_id", referencedColumnName="id")
	private Usuario usuario;
	
	@ManyToOne( cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "guardarropa_id", referencedColumnName="id")
	private Guardarropa guardarropa;
	
	@OneToOne( cascade=CascadeType.ALL)
	@JoinColumn(name = "sugerencia_id", referencedColumnName="id")
	private Sugerencia sugerencia;
	
	private String repeticion;
	
	//private String tempEsperada;
	
	@Transient
	private List<Evento> eventosConRepeticion;
	private String ubicacionParaAPI;
	
	//private int ubicacion;
	//private Double temperatura;
	//private List<Sugerencia> sugerencias = new ArrayList<Sugerencia>();
	/*private ColaDeEventos servidorDeEventos = new ColaDeEventos();*/
	/*public ColaDeEventos getColaDeEventos() {
		return servidorDeEventos;
	}*/

	
	public Evento(LocalDate fechaEvento, String descripcion, Usuario usuario, String ubicacion, Guardarropa guardarropa) {
		this.fechaEvento = fechaEvento;
		this.descripcion = descripcion;
		this.usuario = usuario;
		this.ubicacionParaAPI = ubicacion;
		this.repeticion = "UNICO";  //Averiguar como implementar calendario de google.
		this.guardarropa = guardarropa;
	}
	
	public Evento CrearSiguienteEvento() throws Exception {
        return new Evento(this.calcularSiguienteFecha(), this.descripcion, this.usuario, this.ubicacionParaAPI, this.guardarropa);
    }
    
    private LocalDate calcularSiguienteFecha() throws Exception {
    	//Calcula el proximo evento segun su repeticion. 
    	Period periodo;
        switch (this.repeticion){
        	case "UNICO": periodo = Period.ofDays(0);
        		return fechaEvento.plus(periodo);
        	
            case "DIARIA": periodo = Period.ofDays(1);
        		return fechaEvento.plus(periodo);
          
            case "SEMANAL":periodo = Period.ofDays(7);
            	return fechaEvento.plus(periodo);
        
            case "MENSUAL":periodo = Period.ofMonths(1);
            	return fechaEvento.plus(periodo);
           
            case "ANUAL":periodo = Period.ofYears(1);            	
            	 return fechaEvento.plus(periodo);    
            
            default:
                throw new Exception("Imposible calcular fecha del proximo evento");
        }
        
        
	}/*
	//Agrego el evento a la cola
	public void procesarEvento() throws IOException {
		this.servidorDeEventos.encolarEvento(this);
	}*/
		
	private Boolean esUnaRepeticionValida(String repeticion) {
        switch (repeticion)
        {
            case "UNICO":
            case "DIARIA":
            case "SEMANAL":
            case "MENSUAL":
            case "ANUAL":
                return true;
            default:
                return false;
        }
    }
	
	
		/*switch(estado) {
		case ACEPTADA : this.reservameTodasLasPrendas();
		case RECHAZADA : this.liberameTodasLasPrendas();
	default:
		break;
	}
	}*/	
	
	public void reservameTodasLasPrendas() {
		for(Prenda prenda : sugerencia.getSugerencia() ){
    		prenda.estaReservada(fechaEvento);
		}
	}
	
	public void liberameTodasLasPrendas() {
		for(Prenda prenda : sugerencia.getSugerencia() ){
    		prenda.liberarPrenda(fechaEvento);
		}	
	}
	
		
	//Setters
	public void setFechaEvento(LocalDate fechaEvento) {
		this.fechaEvento = fechaEvento;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacionParaAPI = ubicacion;
	}/*
	public void setTemperatura (Double temperatura) { // Guarda la temperatura promedio para el evento.
		this.temperatura = temperatura;
	}*/
	public void setGuardaropa(Guardarropa unGuardarropa) {
		this.guardarropa = unGuardarropa;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	/*public void setTempEsperada(String temp) {
		this.tempEsperada = temp;
	}*/
	/*public void setSugerencias(List<String> unaLista) {
		for(String elemento : unaLista) {
			Sugerencia auxiliar = new Sugerencia(null);
			auxiliar.setDescripcion(elemento);
			auxiliar.setEstado(EnumEstadoSugerencia.SUGERIDA);
			sugerencias.add(auxiliar);
		}
	}*/
	public void setSugerencia(Sugerencia unaSugerencia) {
		//Si ya habia una sugerencia aceptada antes => se liberan las prendas de esa sugerencia
		if (this.sugerencia != null)
			this.liberameTodasLasPrendas();
		this.sugerencia = unaSugerencia;
	}
	
	public void setRepeticion(String repeticion) throws Exception {
		if(esUnaRepeticionValida(repeticion)){
			this.repeticion = repeticion;
			Evento nuevoEvento = this.CrearSiguienteEvento();
			eventosConRepeticion.add(nuevoEvento);
		}
	}
	
	//Getters
	public LocalDate getFecha() {
		return fechaEvento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public String getUbicacion() {
		return ubicacionParaAPI;
	}
	public Guardarropa getGuardaropa() {
		return guardarropa;
	}
	
	public Sugerencia getSugerencia() {
		return sugerencia;
	}
	
	public String getRepeticion() {
		return repeticion;
	}
	
	public String getID() {
		return Long.toString(this.id);
	}
	/*public String getTempEsperada() {
		return this.tempEsperada;
	}*/

}
