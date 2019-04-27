package main;

public enum TipoDePrenda {

	
	// Los tipos de prenda deben de ser instancias de clases y conocer su categoria
	
	
	
	ZAPATO = new TipoDePrenda(CALZADO),
    REMERA = new TipoDePrenda(PARTE_SUPERIOR),
    PANTALON = new TipoDePrenda(PARTE_INFERIOR);
	
	
	// Los tipos de prenda deben de ser instancias de clases y conocer su categoria
	//Son tipos de prenda: remera, blusa, pantalon, bermuda, enterito, zapato, gorro, anteojo, camisa_manga_larga, camisa_manga_corta, vestido, pollera
	//ZAPATO(CALZADO), REMERA(PARTE_SUPERIOR), PANTALON(PARTE_INFERIOR);
	  
    
	 Categoria categoria;
	
	//Constructor: 
	private TipoDePrenda(Categoria unaCategoria) {
		this.categoria=unaCategoria;
	}
	
	public Categoria categoria() {
		return this.categoria;
	}

}
