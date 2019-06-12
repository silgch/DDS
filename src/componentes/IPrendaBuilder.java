package componentes;

public interface IPrendaBuilder {
	
	
	public void setNombre(String nombre);
	public void setColorPrincipal(Color colorPrincipal);
	public void setColorSecundario(Color colorSecundario);
	public void setTipoPrenda(TipoDePrenda tipoDePrenda);
	public void setMaterial(Material material);
	public void setTrama(Trama trama);
	public Prenda getResult();
	
	
}
