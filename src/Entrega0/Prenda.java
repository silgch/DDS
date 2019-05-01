package Entrega0;

import java.util.Objects;

public class Prenda {
	TipoDePrenda tipoDePrenda;
	Material material; 
	Color colorPrimario;
	Color colorSecundario;
	
	//Constructor
	public Prenda(TipoDePrenda tipoDePrenda, Material material, Color colorUno, Color colorDos) {
		
		if(colorDos!=null) {
			try {
				if(colorUno.esIgualA(colorDos)) {
					throw new IllegalArgumentException("Los colores deben ser distintos");
				}
				else {
					this.tipoDePrenda = Objects.requireNonNull(tipoDePrenda,"falta tipoDePrenda");
				    this.material = Objects.requireNonNull(material,"falta material");
				    this.colorPrimario =  Objects.requireNonNull(colorUno,"falta color primario");
				    this.colorSecundario = colorDos;
				}
			}
			catch(IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		else {
			this.tipoDePrenda = Objects.requireNonNull(tipoDePrenda,"falta tipoDePrenda");
		    this.material = Objects.requireNonNull(material,"falta material");
		    this.colorPrimario =  Objects.requireNonNull(colorUno,"falta color primario");
		    this.colorSecundario = colorDos;
		}
		
	}
	
	//Metodos
	public Categoria categoria(){
		return tipoDePrenda.getCategoria();
		
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
