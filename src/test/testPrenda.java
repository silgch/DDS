package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Categoria;
import main.Color;
import main.Material;
import main.Prenda;
import main.TipoDePrenda;


public class testPrenda {
	Prenda pantalon;
	
	@BeforeEach
	public void init() {
		pantalon = new Prenda(new TipoDePrenda(Categoria.PARTE_INFERIOR), Material.Algodon, new Color(0,0,200), new Color(110,10,0));
			
	}
	
	@Test
	public void testCategoria() {
		
		assertEquals(pantalon.categoria(),Categoria.PARTE_INFERIOR);
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
