package main;


import Entrega0.Categoria;
import Entrega0.Color;
import Entrega0.Material;
import Entrega0.Prenda;
import Entrega0.PrendaDeVestir;
import Entrega0.TipoDePrenda;

public class main {

	public static void main(String[] args) {

		Prenda camisaARayas = new Prenda(new TipoDePrenda(Categoria.PARTE_SUPERIOR,PrendaDeVestir.CAMISA),Material.Jean,new Color(0,0,0),null);
		//Como podemos restringir valores de enum?(en este caso para Material)
		
	}

}
