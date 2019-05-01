package Entrega0_TEST;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Entrega0.Categoria;
import Entrega0.Color;
import Entrega0.Material;
import Entrega0.Prenda;
import Entrega0.PrendaDeVestir;
import Entrega0.TipoDePrenda;


public class testPrenda {
	Prenda pantalon;
	
	@BeforeEach
	public void init() {
		pantalon = new Prenda(new TipoDePrenda(Categoria.PARTE_INFERIOR,PrendaDeVestir.PANTALON), Material.Algodon, new Color(0,0,200), new Color(110,10,0));
			
	}
	
	@Test
	public void testCategoria() {
		
		assertEquals( pantalon.categoria(),Categoria.PARTE_INFERIOR);
	}
	@Test
	public void esDeInvierno(){
		assertTrue(pantalon.esDeInvierno());
	}
	@Test
	public void esDeVerano(){
		assertTrue(pantalon.esDeVerano());
	}
}
