package main;

public enum TipoDePrenda {

	
	// Los tipos de prenda deben de ser instancias de clases y conocer su categoria
	
	 Categoria categoria;
	
	//Constructor: 
	private TipoDePrenda(Categoria unaCategoria) {
		this.categoria=unaCategoria;
	}
	
	//categorias(CALZADO, PARTE_SUPERIOR, PARTE_INFERIOR, ACCESORIOS)
	
	public Categoria categoria() {
		return this.categoria;
	}
	
	zapato = new TipoDePrenda(CALZADO);
    remera = new TipoDePrenda(PARTE_SUPERIOR);
    blusa = new TipoDePrenda(PARTE_SUPERIOR);
    pantalon = new TipoDePrenda(PARTE_INFERIOR);
    bermuda = new TipoDePrenda(PARTE_INFERIOR);
	
	
	//Son tipos de prenda: remera, blusa, pantalon, bermuda, enterito, zapato, gorro, anteojo, camisa_manga_larga, camisa_manga_corta, vestido, pollera


}
