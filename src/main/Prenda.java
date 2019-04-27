package main;

public class Prenda {
	TipoDePrenda tipoDePrenda;
	Material material;
	Color color;
	
	
	//Constructor
	public Prenda(TipoDePrenda tipoDePrenda, Material material, Color color) {
		     this.tipoDePrenda = tipoDePrenda;
		     this.material = material;
		     this.color = color;
		  }
	public Categoria categoria(){
		return tipoDePrenda.categoria();
		
	}
	public boolean esDeInvierno() {
		return true;
	}
	
	public boolean esDeVerano() {
		return true;
	}

}
