package main;


import Componentes.Categoria;
import Componentes.Color;
import Componentes.Material;
import Componentes.Prenda;
import Componentes.TipoDePrenda;
import Componentes.Trama;

public class mainDeclaracionPrenda {

	public static void main(String[] args) {

		//Prenda camisaARayas = new Prenda(new TipoDePrenda(Categoria.PARTE_SUPERIOR,PrendaDeVestir.CAMISA),Material.Jean,new Color(0,0,0),null);
		//Como podemos restringir valores de enum?(en este caso para Material)
		
		Prenda pantalon = new Prenda(TipoDePrenda.PANTALON, Material.ALGODON, new Color(0,0,200), new Color(110,10,0),Trama.CUADROS);
		
	}

}
