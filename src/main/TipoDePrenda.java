package main;


public class TipoDePrenda {
	 
	// Los tipos de prenda deben de ser instancias de clases y conocer su categoria

    
	Categoria categoria;
	//Constructor: 
	public TipoDePrenda(Categoria unaCategoria) {
		this.categoria=unaCategoria;
	}
	
	public Categoria categoria() {
		return this.categoria;
	}

}
