/*
	Se crean 7 prendas (con sus tipos, colores, materiales, etc)
	Se crea un usuario gratuito con 2 guardarropas
	Se le agregan distintas prendas a los guardarropas
	Se crea un evento ahora mismo y el programa muestra una sugerencia
	Actualmente la sugerencia no devuelve ninguna combinacion de prendas
*/

package main;

import java.time.LocalDate;
//import java.time.format.*;  // Este paquete contiene DateTimeFormatter
import java.util.HashSet;
import java.util.Set;

import componentes.Categoria;
import componentes.Color;
import componentes.Material;
import componentes.Prenda;
import componentes.PrendaNivel;
import componentes.TipoDePrenda;
import componentes.Trama;
import eventos.Evento;
import guardarropas.Guardarropa;
import usuario.CuentaGratuita;
import usuario.Usuario;

public class mainEventos {

	public static void main(String[] args) throws Exception {
		
		//Cargamos usuarios, prendas, colores, etc
		Set <Material> tiposDeMaterialRemera;
		Set <Material> tiposDeMaterialZapato;
		Set <Material> tiposDeMaterialZapatilla;
		Set <Material> tiposDeMaterialPantalon;
		Set <Material> tiposDeMaterialLentes;
	
		Usuario ines = new Usuario("ines");
	
		TipoDePrenda zapato;
		TipoDePrenda remera;
		TipoDePrenda pantalon;
		TipoDePrenda zapatilla;
		TipoDePrenda lentes;
		Color colorBlanco;
		Color colorRojo;
		Color colorNegro;
		Prenda unaRemeraBlancaLisa;
		Prenda unaRemeraRoja;
		Prenda unaRemeraNegra;
		Prenda unPantalonNegro;
		Prenda unZapatoNegro;
		Prenda unaZapatillaLonaBlanca;
		Prenda unLenteNegro;
		Guardarropa guardarropaInesUno;
		Guardarropa guardarropaInesDos;
		//
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
		colorNegro=new Color(10,10,10);
		colorRojo=new Color (255,0,0);
		
		remera = new  TipoDePrenda("Remera",Categoria.PARTE_SUPERIOR, tiposDeMaterialRemera,PrendaNivel.Nivel1);
		zapato= new TipoDePrenda("Zapato", Categoria.CALZADO, tiposDeMaterialZapato,PrendaNivel.Nivel2);
		zapatilla = new TipoDePrenda("Zapatilla", Categoria.CALZADO, tiposDeMaterialZapatilla,PrendaNivel.Nivel2);
		pantalon = new TipoDePrenda("Pantalon",Categoria.PARTE_INFERIOR, tiposDeMaterialPantalon,PrendaNivel.Nivel2);
		lentes = new TipoDePrenda("Lentes de sol", Categoria.ACCESORIO, tiposDeMaterialLentes,PrendaNivel.Nivel1);
		
		unaRemeraBlancaLisa = new Prenda("Remera Blanca lisa", remera, Material.ALGODON, colorBlanco, Trama.LISA );
		unaRemeraRoja= new Prenda("Remera Roja a lunares", remera, Material.SEDA, colorRojo, Trama.LUNARES);
		unaRemeraNegra= new Prenda("Remera Negra Basica", remera, Material.ALGODON, colorNegro, Trama.LISA);
		unPantalonNegro = new Prenda("Pantalon Negro", pantalon, Material.CORDEROY, colorNegro, Trama.LISA);
		unZapatoNegro= new Prenda("Zapatos Negros", zapato, Material.CUERO, colorNegro, Trama.LISA);
		unaZapatillaLonaBlanca= new Prenda("Zapatillas de lona blancas", zapatilla, Material.LONA, colorBlanco, Trama.LISA);
		unLenteNegro = new Prenda("Lentes de sol  negros", lentes, Material.PLASTICO, colorNegro, Trama.LISA);
		
		ines.setTipoDeCuenta(new CuentaGratuita());
		ines.setNombre("Ines Gonzalez");
	    guardarropaInesUno = new Guardarropa();
	    guardarropaInesDos = new Guardarropa();
	    
	    guardarropaInesUno.duenio(ines);
	    guardarropaInesDos.duenio(ines);
		
	    guardarropaInesUno.agregarAGuardarropas(unaRemeraBlancaLisa);
	    guardarropaInesUno.agregarAGuardarropas(unaRemeraRoja);
	    guardarropaInesUno.agregarAGuardarropas(unPantalonNegro);
	    guardarropaInesUno.agregarAGuardarropas(unZapatoNegro);
	    guardarropaInesUno.agregarAGuardarropas(unaZapatillaLonaBlanca);
	    guardarropaInesUno.agregarAGuardarropas(unLenteNegro); 	
	    
	    guardarropaInesDos.agregarAGuardarropas(unaRemeraNegra);
	    
	    /*
	    //Cargamos algunos eventos
	    ines.cargarEvento( LocalDate.now(), "Ir al cine", 3433955);
	    Evento unEvento= new Evento ( LocalDate.now(), "Ir al cine", ines, 3433955);
	    //ines.procesarEvento(unEvento);
	    System.out.println("La sugerencia para el evento es "+unEvento.getSugerencias());
	 	*/
	
	   // ines.cargarEvento( LocalDate.of(2019, 8, 10), "Ir al teatro", 3433955);
	   // ines.cargarEvento( LocalDate.of(2019, 8, 14), "Cumpleaños de Pepita", 3433955);
	    
	    
	    
	}

}
