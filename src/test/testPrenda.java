package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Componentes.Categoria;
import Componentes.Color;
import Componentes.Material;
import Componentes.Prenda;
import Componentes.TipoDePrenda;
import Componentes.Trama;


public class testPrenda {
	Prenda pantalon;
	
	@BeforeEach
	public void init() {
		
		pantalon = new Prenda(TipoDePrenda.PANTALON, Material.ALGODON, new Color(0,0,200), new Color(110,10,0),Trama.CUADROS);
			
	}
	
	@Test
	public void testCategoria() {
		
		assertEquals( pantalon.getCategoria(),Categoria.PARTE_INFERIOR);
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
