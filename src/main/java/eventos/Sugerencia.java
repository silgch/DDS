package eventos;

public class Sugerencia {
// Una sugerencia es un atuendo (lista de prendas) válido que puede tener distintos estados.
// Se puede aceptar, rechazar,sugerir(lo hace con el command qmp) etc
// Ver deshacer ultima operacion	
	
	int calificacion=0; // El usuario podra calificar cada sugerencia ACEPTADA.
		
// POR EL MOMENTO CAMBIO 'TIPO' DE SUGERENCIA

// 	private List<Prenda> sugerencia = new ArrayList<Prenda>();

	private String descripcion;
	
    private EnumEstadoSugerencia estado; //SUGERIDA, ACEPTADA O RECHAZADA
    
//		public List<Prenda> getSugerencia() {
//			return sugerencia;
//		}
    
    public void sugerencia() {}
    
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
	

}


