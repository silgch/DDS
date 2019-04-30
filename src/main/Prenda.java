package main;


public class Prenda {
	TipoDePrenda tipoDePrenda;
	Material material; 
	Color colorPrimario;
	Color colorSecundario;
	
	//Constructor
	public Prenda(TipoDePrenda tipoDePrenda, Material material, Color colorUno, Color colorDos) {
		     this.tipoDePrenda = tipoDePrenda;
		     this.material = material;
		     this.colorPrimario = colorUno;
		     this.colorSecundario = colorDos;
		  }
	
	//Metodos
	public Categoria categoria(){
		return tipoDePrenda.categoria();
		
	}
	public boolean esDeInvierno() {
		return true;
	}
	
	public boolean esDeVerano() {
		return true;
	}
	
	//Getters & Setters
	public TipoDePrenda getTipoDePrenda() {
		return tipoDePrenda;
	}
	public void setTipoDePrenda(TipoDePrenda tipoDePrenda) {
		this.tipoDePrenda = tipoDePrenda;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public Color getColorPrimario() {
		return colorPrimario;
	}
	public void setColorPrimario(Color colorPrimario) {
		this.colorPrimario = colorPrimario;
	}
	public Color getColorSecundario() {
		return colorSecundario;
	}
	public void setColorSecundario(Color colorSecundario) {
		this.colorSecundario = colorSecundario;
	}

}
