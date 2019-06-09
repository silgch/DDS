package test;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import Componentes.Categoria;
import Componentes.Color;
import Componentes.Material;
import Componentes.Prenda;
import Componentes.TipoDePrenda;
import Componentes.Trama;
import guardarropas.Guardarropa;
import usuario.Usuario;


public class testPrenda {

	private Set<Material> tiposDeMaterialRemera;
	private Set <Material> tiposDeMaterialZapato;
	private Set <Material> tiposDeMaterialZapatilla;
	private Set <Material> tiposDeMaterialPantalon;
	private Set <Material> tiposDeMaterialLentes;
	

	Usuario ines = new Usuario();
	TipoDePrenda zapato;
	TipoDePrenda remera;
	TipoDePrenda pantalon;
	TipoDePrenda zapatilla;
	TipoDePrenda lentes;
	Color colorBlanco;
	Color colorRojo;
	Color colorVerde;
	Color colorNegro;
	Color colorAzulTrafico;
	Prenda unaRemeraBlancaLisa;
	Prenda unaRemeraRoja;
	Prenda unPantalonNegro;
	Prenda unZapatoNegro;
	Prenda unaZapatillaLonaBlanca;
	Prenda unLenteNegro;
	Guardarropa guardarropaInesUno;
	
	@Before
	public void init() throws Exception {
		tiposDeMaterialRemera = new HashSet<Material>();
		tiposDeMaterialPantalon = new HashSet<Material>();
		tiposDeMaterialZapato= new HashSet<Material>();
		tiposDeMaterialZapatilla= new HashSet<Material>();
		tiposDeMaterialLentes = new HashSet<Material>();
		
		tiposDeMaterialRemera.add(Material.ALGODON);
		tiposDeMaterialRemera.add(Material.SEDA);
		tiposDeMaterialPantalon.add(Material.BENGALINA);
		tiposDeMaterialPantalon.add(Material.CORDEROY);
		tiposDeMaterialPantalon.add(Material.JEAN);
		tiposDeMaterialZapato.add(Material.CUERINA);
		tiposDeMaterialZapato.add(Material.CUERO);
		tiposDeMaterialZapatilla.add(Material.CUERINA);
		tiposDeMaterialZapatilla.add(Material.CUERO);
		tiposDeMaterialZapatilla.add(Material.LONA);
		tiposDeMaterialLentes.add(Material.PLASTICO);
		
		
		colorBlanco=new Color(255,255,0);
		colorVerde=new Color(0,255,0);
		colorNegro=new Color(10,10,10);
		colorRojo=new Color (255,0,0);
		colorAzulTrafico=new Color(006,057,113);
		
		
		remera = new  TipoDePrenda("Remera",Categoria.PARTE_SUPERIOR, tiposDeMaterialRemera);
		zapato= new TipoDePrenda("Zapato", Categoria.CALZADO, tiposDeMaterialZapato);
		zapatilla = new TipoDePrenda("Zapatilla", Categoria.CALZADO, tiposDeMaterialZapatilla);
		pantalon = new TipoDePrenda("Pantalon",Categoria.PARTE_INFERIOR, tiposDeMaterialPantalon);
		lentes = new TipoDePrenda("Lentes de sol", Categoria.ACCESORIOS, tiposDeMaterialLentes);
		
		unaRemeraBlancaLisa = new Prenda("Remera Blanca lisa", remera, Material.ALGODON, colorBlanco, Trama.LISA );
		unaRemeraRoja= new Prenda("Remera Roja a lunares", remera, Material.SEDA, colorRojo, Trama.LUNARES);
		unPantalonNegro = new Prenda("Pantalon Negro", pantalon, Material.CORDEROY, colorNegro, Trama.LISA);
		unZapatoNegro= new Prenda("Zapatos Negros", zapato, Material.CUERO, colorNegro, Trama.LISA);
		unaZapatillaLonaBlanca= new Prenda("Zapatillas de lona blancas", zapatilla, Material.LONA, colorBlanco, Trama.LISA);
		unLenteNegro = new Prenda("Lentes de sol  negros", lentes, Material.PLASTICO, colorNegro, Trama.LISA);
		
		
	    Guardarropa guardarropaInesUno = new Guardarropa();
		
	    guardarropaInesUno.agregarAGuardarropas(unaRemeraBlancaLisa);
	    guardarropaInesUno.agregarAGuardarropas(unaRemeraRoja);
	    guardarropaInesUno.agregarAGuardarropas(unPantalonNegro);
	    guardarropaInesUno.agregarAGuardarropas(unZapatoNegro);
	    guardarropaInesUno.agregarAGuardarropas(unaZapatillaLonaBlanca);
	    guardarropaInesUno.agregarAGuardarropas(unLenteNegro); 	
	}
	
	@Test
	public void testCategoria() {
		assertEquals( unaRemeraBlancaLisa.getCategoria(),Categoria.PARTE_SUPERIOR);
		assertEquals( unaRemeraRoja.getCategoria(),Categoria.PARTE_SUPERIOR);
		assertEquals( unPantalonNegro.getCategoria(),Categoria.PARTE_INFERIOR);
		assertEquals( unZapatoNegro.getCategoria(),Categoria.CALZADO);
		assertEquals( unaZapatillaLonaBlanca.getCategoria(),Categoria.CALZADO);
		assertEquals( unLenteNegro.getCategoria(),Categoria.ACCESORIOS);
		
	}
	
	@Test
	public void testMaterial() {
		
		assertEquals( unaRemeraBlancaLisa.getMaterial(),Material.ALGODON);
		assertEquals( unaRemeraRoja.getMaterial(),Material.SEDA);
		assertEquals( unPantalonNegro.getMaterial(),Material.CORDEROY);
		assertEquals( unZapatoNegro.getMaterial(),Material.CUERO);
		assertEquals( unaZapatillaLonaBlanca.getMaterial(),Material.LONA);
		assertEquals( unLenteNegro.getMaterial(),Material.PLASTICO);	
		
	}
	
	@Test
	public void testColor() {
		
		assertEquals( unaRemeraBlancaLisa.getColor(), colorBlanco);
		assertEquals( unaRemeraRoja.getColor(), colorRojo);
		assertEquals( unPantalonNegro.getColor(), colorNegro);
		assertEquals( unZapatoNegro.getColor(), colorNegro);
		assertEquals( unaZapatillaLonaBlanca.getColor(), colorBlanco);
		assertEquals( unLenteNegro.getColor(), colorNegro);
	}	
	
	@Test 
	public void obtenerSugerenciasInesTest() {
	
		Set<List<Prenda>> sugerencias = guardarropaInesUno.sugerir();
		sugerencias.forEach(sugerencia -> System.out.println(sugerencia));
		assertEquals(4, sugerencias.size());
	}
	
	
	@Test 
	public void listaDePrendasPorCategoriaCorrectas() {
		

		assertEquals(2,guardarropaInesUno.getPrendasSuperiores().size());
		assertEquals(1,guardarropaInesUno.getPrendasInferiores().size());
		assertEquals(2,guardarropaInesUno.getCalzados().size());
		assertEquals(1,guardarropaInesUno.getAccesorios().size());
		
		
		
		
	}
	
	
	
	
}