package eventos;

import java.util.ArrayList;
import java.util.List;

import componentes.Prenda;

public class Sugerencia {
// Una sugerencia es un atuendo valido(lista de prendas) que puede tener distintos estados.
// Se puede aceptar, rechazar, etc
// Ver deshacer ultima operacion	

		
	//POR EL MOMENTO CAMBIO 'TIPO' DE SUGERENCIA
		//private List<Prenda> sugerencia = new ArrayList<Prenda>();
	
		private String descripcion;
		
	    private EnumEstadoSugerencia estado; //ACEPTADA O RECHAZADA
	    


//		public List<Prenda> getSugerencia() {
//			return sugerencia;
//		}
	    
	    public String getDescripcion() {
	    	return descripcion;
	    }

		public EnumEstadoSugerencia getEstado() {
		
			return estado;
		}

//		public void setSugerencia(List<Prenda> sugerencia) {
//			this.sugerencia = sugerencia;
//		}
		
		public void setDescripcion(String sugerencia) {
			this.descripcion = sugerencia;
		}

		public void setEstado(EnumEstadoSugerencia estado) {
			this.estado = estado;
		}
		
		public void AceptarSugerencia() {
			this.setEstado(EnumEstadoSugerencia.ACEPTADA);
		
		}
		
		public void RechazarSugerencia() {
			this.setEstado(EnumEstadoSugerencia.RECHAZADA);
		
		}
	}


