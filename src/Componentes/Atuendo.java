package Componentes;

public class Atuendo {
	
	private Prenda parteSuperior=null;
	private Prenda parteInferior=null;
	private Prenda calzado=null;
	private Prenda accesorio=null;
	
	public Atuendo(Prenda parteSuperior,Prenda parteInferior,Prenda calzado,Prenda accesorio) {
		this.parteSuperior = parteSuperior;
		this.parteInferior = parteInferior;
		this.calzado=calzado;
		this.accesorio=accesorio;
	}
	
	public Atuendo() {}
	
	//Metodos
	
	public void asignarSegunCategoriaPrenda(Prenda prenda) {
		
		switch(prenda.getCategoria()) {
			case CALZADO:
				this.setCalzado(prenda);
				break;
			case PARTE_SUPERIOR:
				this.setParteSuperior(prenda);
				break;
			case PARTE_INFERIOR:
				this.setParteInferior(prenda);
				break;
			case ACCESORIOS:
				this.setAccesorio(prenda);
				break;
		}
		
	}
	
	public String atuendoContenido() {
		return this.parteSuperior.getNombre()+this.parteInferior.getNombre()+this.getCalzado().getNombre()+this.getAccesorio().getNombre();
	} 
	
	//Getters & Setters

	public Prenda getParteSuperior() {
		return parteSuperior;
	}

	public void setParteSuperior(Prenda parteSuperior) {
		this.parteSuperior = parteSuperior;
	}

	public Prenda getParteInferior() {
		return parteInferior;
	}

	public void setParteInferior(Prenda parteInferior) {
		this.parteInferior = parteInferior;
	}

	public Prenda getCalzado() {
		return calzado;
	}

	public void setCalzado(Prenda calzado) {
		this.calzado = calzado;
	}

	public Prenda getAccesorio() {
		return accesorio;
	}

	public void setAccesorio(Prenda accesorio) {
		this.accesorio = accesorio;
	}

}
