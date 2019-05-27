package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Componentes.Categoria;
import Componentes.Color;
import Componentes.Material;
import Componentes.Prenda;
import Componentes.TipoDePrenda;
import Componentes.Trama;

/*
	1. Creación de prendas, las cuales deben ser válidas, según al menos las siguientes
	reglas:
	a. debe saberse qué tipo de prenda es (remera de mangas cortas, short, zapatos
	de tacón, etc.)
	b. debe saberse a qué categoría pertenece, la cual debe ser consistente con el
	tipo de prenda y la parte del cuerpo donde se utiliza o su función (parte
	superior, parte inferior, calzado y accesorios).
	c. debe ser de un tipo tipo de tela, que debe ser consistente con el tipo de prenda:
	por ejemplo, no tiene sentido tener una campera de seda o una remera de
	cuero.
	d. debe ser de un color primario asociado, y opcionalmente uno secundario y
	diferente del anterior
*/

class testsEntrega1 {
	private Prenda prendaZapatillaCuero;
	private Prenda prendaRemeraDePlastico;
	private Prenda remeraNegraYMasNegra;

	
	@BeforeEach
	public void init() {
		prendaZapatillaCuero = new Prenda(TipoDePrenda.ZAPATILLAS, Material.CUERO, new Color(0,0,0),Trama.LISA);
	}
		
	@Test
	void testA_ConocerTipoDePrenda() {
		assertEquals( prendaZapatillaCuero.getTipo(),TipoDePrenda.ZAPATILLAS);
	}
	@Test
	void testB_ConocerCategoriaPrenda() {
		assertEquals( prendaZapatillaCuero.getCategoria(),Categoria.CALZADO);
	}
	@Test
	void testC_tipoDeTelaInvalida() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			prendaRemeraDePlastico = new Prenda(TipoDePrenda.REMERA, Material.PLASTICO, new Color(0,202,0),Trama.LISA);
	    });
	}	
	@Test
	void testD_dobleColorEsInvalido() {
		assertThrows(IllegalArgumentException.class, () -> {
	    	remeraNegraYMasNegra = new Prenda(TipoDePrenda.REMERA, Material.ALGODON, new Color(0,0,100),new Color(0,0,100),Trama.CUADROS);
	    });
	}
	/* Tests probando las sugerencias de guardarropas en el main
	@Test
	void SugurenciasGuardarropas1DeInes() {
		// El primer guardarropas deberia tener 6 posibles combinaciones
		assertEquals();
	}
	@Test
	void SugurenciasGuardarropas1DeJoeyRamone() {
		// El primer guardarropas deberia tener 1 posible combinacion
		assertEquals();
	}
	@Test
	void SegurenciasTodosLosGuardarropasDeInes() {
		// Entre todos los guardarropas de Ines debería tener 144 posibles combinaciones
		assertEquals();
	}
	 */
}
