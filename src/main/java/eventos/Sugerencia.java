package eventos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//import com.google.common.base.Strings;

import componentes.Prenda;


/* 
 Una sugerencia es un atuendo (lista de prendas) válido que puede tener distintos estados.
 Se puede aceptar, rechazar,sugerir(lo hace con la clase command)
 Ver deshacer ultima operacion 
*/

@Entity(name = "sugerencia")
@Table(name = "sugerencia")
public class Sugerencia {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	public Sugerencia() {
	}
	
	@ManyToMany
	@JoinTable(name="sugerencias_prendas",
			   joinColumns={@JoinColumn(name="sugerencia_id")}, 
			   inverseJoinColumns={@JoinColumn(name= "prenda_id")})
	private List<Prenda> prendas_de_sugerencia;
	
	@OneToOne(mappedBy = "sugerencia")
	private Evento evento;
	
	int calificacion=0; // El usuario podra calificar cada sugerencia ACEPTADA.

	
	public Sugerencia(List<Prenda> list) {
		this.prendas_de_sugerencia = list;
	}
		
	//private String descripcion;
	
    //private EnumEstadoSugerencia estado; //SUGERIDA, ACEPTADA O RECHAZADA	
			
// POR EL MOMENTO CAMBIO 'TIPO' DE SUGERENCIA

	public List<String> devolverSugerenciaEnFormaDeString(){
		List<String> listaAuxiliar = new ArrayList<String>();
		for(Prenda prenda : prendas_de_sugerencia ){
    		String nombre = prenda.getNombre();
    		listaAuxiliar.add(nombre);
		}
		return listaAuxiliar;
	}
    
    //setters
	/*public void setDescripcion(String sugerencia) {
		this.descripcion = sugerencia;
	}*/
	/*public void setEstado(EnumEstadoSugerencia estado) {
		this.estado = estado;
	}*/
	
	public void setCalificacion(int unaCalificacion) {
		this.calificacion= unaCalificacion;
	}
	
	//getters
	
	public int getCalificacion() {
		return calificacion;
	}
	
	public String getId() {
		return Long.toString(this.id);
	}
	
	/*public String getDescripcion() {
    	return descripcion;
    }*/
	/*public EnumEstadoSugerencia getEstado() {
		return estado;
	}*/
	public List<Prenda> getSugerencia() {
		return prendas_de_sugerencia;
	}
	

}


