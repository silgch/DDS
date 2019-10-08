package eventos;

import java.util.ArrayList;
import java.util.List;

//import com.google.common.base.Strings;

import componentes.Prenda;

public class Sugerencia {
// Una sugerencia es un atuendo (lista de prendas) válido que puede tener distintos estados.
// Se puede aceptar, rechazar,sugerir(lo hace con el command qmp) etc
// Ver deshacer ultima operacion	
	
	private List<Prenda> sugerencia;
	
	public Sugerencia(List<Prenda> list) {
		this.sugerencia = list;
	}
	
	//esto está porque 
		
	private String descripcion;
	
    private EnumEstadoSugerencia estado; //SUGERIDA, ACEPTADA O RECHAZADA
	
	int calificacion=0; // El usuario podra calificar cada sugerencia ACEPTADA.
	
			
// POR EL MOMENTO CAMBIO 'TIPO' DE SUGERENCIA

	public List<String> devolverSugerenciaEnFormaDeString(){
		List<String> listaAuxiliar = new ArrayList<String>();
		for(Prenda prenda : sugerencia ){
    		String nombre = prenda.getNombre();
    		listaAuxiliar.add(nombre);
		}
		return listaAuxiliar;
	}
    
    //setters
	public void setDescripcion(String sugerencia) {
		this.descripcion = sugerencia;
	}
	public void setEstado(EnumEstadoSugerencia estado) {
		this.estado = estado;
	}
	
	public void setCalificacion(int unaCalificacion) {
		this.calificacion= unaCalificacion;
	}
	
	//getters
	public int getCalificacion() {
		return calificacion;
	}
	public String getDescripcion() {
    	return descripcion;
    }
	public EnumEstadoSugerencia getEstado() {
		return estado;
	}
	public List<Prenda> getSugerencia() {
		return sugerencia;
	}
	

}


