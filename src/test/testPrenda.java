package test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Prenda;


public class testPrenda {

	Prenda bufanda;
	
	@BeforeEach
	public void init() {
		bufanda = new Prenda();
	}
	@Test
	public void testEsDeInvierno() {
		assertTrue(bufanda.esDeInvierno());
	}
}
