package componentes;

public class PrendaBuilder implements IPrendaBuilder {
	
	private Prenda unaPrenda;
	
	public PrendaBuilder() {
		this.unaPrenda = new Prenda();
	}
	
	public void setNombre(String nombre) {
		this.unaPrenda.setNombre(nombre);
	}
	
	public void setColorPrincipal(Color colorPrincipal) {
		this.unaPrenda.setColorPrincipal(colorPrincipal);
	}
	
	public void setColorSecundario(Color colorSecundario) {
		this.unaPrenda.setColorSecundario(colorSecundario);
	}
	
	public void setTipoPrenda(TipoDePrenda tipoDePrenda) {
		this.unaPrenda.setTipo(tipoDePrenda);
	}
	
	public void setMaterial(Material material) {
		this.unaPrenda.setMaterial(material);
	}
	
	public void setTrama(Trama trama) {
		this.unaPrenda.setTrama(trama);
	}
	
	 public void setNivel(PrendaNivel nivel) {
		this.unaPrenda.setNivel(nivel);
	}
	
	
	public Prenda getResult() {
		return this.unaPrenda;
	}

}
