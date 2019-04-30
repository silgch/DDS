package main;


public class TipoDePrenda {

	//Son tipos de prenda: remera, blusa, pantalon, bermuda, enterito, zapato, gorro, anteojo, camisa_manga_larga, camisa_manga_corta, vestido, pollera	 
	// Los tipos de prenda deben de ser instancias de clases y conocer su categoria
    
	Categoria categoria;

	//Constructor: 
	public TipoDePrenda(Categoria unaCategoria) {
		this.categoria=unaCategoria;
	}
	
	//categorias(CALZADO, PARTE_SUPERIOR, PARTE_INFERIOR, ACCESORIOS)
	
	public Categoria categoria() {
		return this.categoria;
	}
	
}
