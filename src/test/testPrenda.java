package test;


import java.util.HashSet;
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


public class testPrenda {
	
	
	private Set<Material> tiposDeMaterialRemera;
	private Set <Material> tiposDeMaterialZapato;
	private Set <Material> tiposDeMaterialZapatilla;
	TipoDePrenda zapato;
	TipoDePrenda remera;
	TipoDePrenda zapatilla;
	Color colorBlanco;
	Color colorRojo;
	Color colorVerde;
	Color colorNegro;
	Color colorAzulTrafico;
	Prenda unaRemeraBlancaLisa;
	Prenda unPantalonNegro;
	Prenda unZapatoNegro;
	Prenda unaZapatillaLonaBlanca;
	
	@Before
	public void init() {
		tiposDeMaterialRemera = new HashSet<Material>();
		tiposDeMaterialZapato= new HashSet<Material>();
		tiposDeMaterialZapatilla= new HashSet<Material>();
		
		tiposDeMaterialRemera.add(Material.ALGODON);
		tiposDeMaterialRemera.add(Material.SEDA);
		tiposDeMaterialZapato.add(Material.CUERINA);
		tiposDeMaterialZapato.add(Material.CUERO);
		tiposDeMaterialZapatilla.add(Material.CUERINA);
		tiposDeMaterialZapatilla.add(Material.CUERO);
		tiposDeMaterialZapatilla.add(Material.LONA);
		
		
		colorBlanco=new Color(255,255,0);
		colorVerde=new Color(0,255,0);
		colorNegro=new Color(10,10,10);
		colorRojo=new Color (255,0,0);
		colorAzulTrafico=new Color(006,057,113);
		
		
		remera = new  TipoDePrenda("Remera",Categoria.PARTE_SUPERIOR, tiposDeMaterialRemera);
		zapato= new TipoDePrenda("Zapato", Categoria.CALZADO, tiposDeMaterialZapato);
		zapatilla = new TipoDePrenda("Zapatilla", Categoria.CALZADO, tiposDeMaterialZapatilla);
		
		unaRemeraBlancaLisa = new Prenda(remera, Material.ALGODON, colorBlanco, Trama.LISA );
		unZapatoNegro= new Prenda(zapato, Material.CUERO, colorNegro, Trama.LISA);
		unaZapatillaLonaBlanca= new Prenda(zapatilla, Material.LONA, colorBlanco, Trama.LISA);
		
		
			
	}
	
	@Test
	public void testCategoria() {
		
		assertEquals( unaRemeraBlancaLisa.getCategoria(),Categoria.PARTE_SUPERIOR);
		assertEquals( unZapatoNegro.getCategoria(),Categoria.CALZADO);
		assertEquals( unaZapatillaLonaBlanca.getCategoria(),Categoria.CALZADO);
		
		
	}
	
	@Test
	public void testMaterial() {
		
		assertEquals( unaRemeraBlancaLisa.getMaterial(),Material.ALGODON);
		assertEquals( unZapatoNegro.getMaterial(),Material.CUERO);
		assertEquals( unaZapatillaLonaBlanca.getMaterial(),Material.LONA);
		
	}
	
	@Test
	public void testColor() {
		
		assertEquals( unaRemeraBlancaLisa.getColor(), colorBlanco);
		assertEquals( unZapatoNegro.getColor(), colorNegro);
		assertEquals( unaZapatillaLonaBlanca.getColor(), colorBlanco);
		
	}	
	
	
	
}