package main;


public class TipoDePrenda {

	//Son tipos de prenda: remera, blusa, pantalon, bermuda, enterito, zapato, gorro, anteojo, camisa_manga_larga, camisa_manga_corta, vestido, pollera	 
	// Los tipos de prenda deben de ser instancias de clases y conocer su categoria
    
	Categoria categoria;
	PrendaDeVestir prendaDeVestir;

	//Constructor: 
	public TipoDePrenda(Categoria unaCategoria,PrendaDeVestir unaPrendaDeVestir) {
		this.categoria=unaCategoria;
		this.prendaDeVestir=unaPrendaDeVestir;
	}
	
	
	//Getters & Setters
	
	//categorias(CALZADO, PARTE_SUPERIOR, PARTE_INFERIOR, ACCESORIOS)
	
	public Categoria getCategoria() {
		return this.categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public PrendaDeVestir getPrendaDeVestir() {
		return prendaDeVestir;
	}

	public void setPrendaDeVestir(PrendaDeVestir prendaDeVestir) {
		this.prendaDeVestir = prendaDeVestir;
	}
	
	
	
}
