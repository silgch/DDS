/*
 	"Test" Main de persistencia hecho por nosotros...
	Se crean 7 prendas (con sus tipos, colores, materiales, etc)
	Se crea un usuario gratuito con 2 guardarropas
	Se le agregan distintas prendas a los guardarropas
	Se muestran por pantalla las distintas prendas del guardarropas
	se aceptan y rechazan sugerencias pero no intervienen ni prendas ni usuarios
*/

package main;

import java.util.HashSet;
import java.util.Set;

import componentes.Categoria;
import componentes.Color;
import componentes.Material;
import componentes.Prenda;
import componentes.PrendaNivel;
import componentes.TipoDePrenda;
import componentes.Trama;
//import eventos.Sugerencia;
import guardarropas.Guardarropa;
import repositorio.Repositorio;
import usuario.Usuario;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class mainCreacionUsuariosGuardarropasPrendas {
	
	private static final String PERSISTENCE_UNIT_NAME = "ati1txh3yqvapdna";
	private static EntityManagerFactory emFactory;
	private static Repositorio repositorio;	
	
	public static void main(final String[] args) throws Exception {

		/* Primero creamos los atributos basicos de las prendas */

		// Materiales
		final Material algodon = new Material("Algodon");
		final Material jean = new Material("Jean");
		final Material lino = new Material("Lino");
		final Material gabardina = new Material("Gabardina");
		final Material seda = new Material("Seda");
		final Material cuero = new Material("Cuero");
		final Material plastico = new Material("Plastico");
		final Material cristal = new Material("Cristal");
		final Material oro = new Material("Oro");
		final Material cuerina = new Material("Cuerina");
		final Material plata = new Material("Plata");
		final Material lona = new Material("Lona");
		final Material lana = new Material("Lana");
		final Material poliester = new Material("Poliester");
		final Material acrilico = new Material("Acrilico");
		final Material corderoy = new Material("Corderoy");
		final Material bengalina = new Material("Bengalina");
		//final Material caucho = new Material("Caucho");

		// Tipos de Materiales
		Set<Material> tiposDeMaterialRemera;
		Set<Material> tiposDeMaterialZapato;
		Set<Material> tiposDeMaterialZapatilla;
		Set<Material> tiposDeMaterialPantalon;
		Set<Material> tiposDeMaterialLentes;
		tiposDeMaterialRemera = new HashSet<Material>();
		tiposDeMaterialPantalon = new HashSet<Material>();
		tiposDeMaterialZapato = new HashSet<Material>();
		tiposDeMaterialZapatilla = new HashSet<Material>();
		tiposDeMaterialLentes = new HashSet<Material>();
		tiposDeMaterialRemera.add(algodon);
		tiposDeMaterialRemera.add(seda);
		tiposDeMaterialPantalon.add(bengalina);
		tiposDeMaterialPantalon.add(corderoy);
		tiposDeMaterialPantalon.add(jean);
		tiposDeMaterialZapato.add(cuerina);
		tiposDeMaterialZapato.add(cuero);
		tiposDeMaterialZapatilla.add(cuerina);
		tiposDeMaterialZapatilla.add(cuero);
		tiposDeMaterialZapatilla.add(lona);
		tiposDeMaterialLentes.add(plastico);

		// Colores
		final Color colorBlanco = new Color( 255, 255, 0);
		final Color colorRojo = new Color(255, 0, 0);
		final Color colorNegro = new Color( 10, 10, 10);
		final Color colorVerde = new Color( 0, 255, 0);
		final Color colorAzulTrafico = new Color( 006, 47, 113);

		// Tramas
		final Trama lisa = new Trama();
		final Trama estampada = new Trama();
		final Trama rayada = new Trama();
		final Trama cuadros = new Trama();
		final Trama lunares = new Trama();

		/* Luego creamos tipos de prendas particulares */
		final TipoDePrenda remera = new TipoDePrenda("Remera", Categoria.PARTE_SUPERIOR, tiposDeMaterialRemera,
				PrendaNivel.Nivel1);
		final TipoDePrenda buzo = new TipoDePrenda("Buzo", Categoria.PARTE_SUPERIOR, null, PrendaNivel.Nivel2);
		final TipoDePrenda campera = new TipoDePrenda("Campera", Categoria.PARTE_SUPERIOR, null, PrendaNivel.Nivel3);
		final TipoDePrenda zapato = new TipoDePrenda("Zapato", Categoria.CALZADO, tiposDeMaterialZapato,
				PrendaNivel.Nivel2);
		final TipoDePrenda zapatilla = new TipoDePrenda("Zapatilla", Categoria.CALZADO, tiposDeMaterialZapatilla,
				PrendaNivel.Nivel2);
		final TipoDePrenda ojotas = new TipoDePrenda("Ojotas", Categoria.CALZADO, null, PrendaNivel.Nivel1);
		final TipoDePrenda pantalonCorto = new TipoDePrenda("Pantalon Corto", Categoria.PARTE_INFERIOR,
				tiposDeMaterialPantalon, PrendaNivel.Nivel2);
		final TipoDePrenda pantalon = new TipoDePrenda("Pantalon", Categoria.PARTE_INFERIOR, tiposDeMaterialPantalon,
				PrendaNivel.Nivel1);
		final TipoDePrenda lentes = new TipoDePrenda("Lentes de sol", Categoria.ACCESORIO, tiposDeMaterialLentes,
				PrendaNivel.Nivel1);

		/* Luego creamos las Prendas que estarán en los guardarropas */
		final Prenda unaRemeraBlancaLisa = new Prenda("Remera Blanca lisa", remera, algodon, colorBlanco, lisa);
		final Prenda unaRemeraRoja = new Prenda("Remera Roja a lunares", remera, seda, colorRojo, lunares);
		// final Prenda unaRemeraNegra = new Prenda("Remera Negra Basica", remera, algodon, colorNegro, lisa);
		// final Prenda unBuzoNegro = new Prenda("Buzo Negro", buzo, cuero, colorNegro, rayada);
		// final Prenda unaCamperaNegra = new Prenda("Campera Negra", campera, cuero, colorNegro, estampada);
		// final Prenda unasHavaianas = new Prenda("Ojotas Havaianas", ojotas, caucho, colorNegro, lisa);
		final Prenda unPantalonNegro = new Prenda("Pantalon Negro", pantalon, corderoy, colorNegro, lisa);
		final Prenda unZapatoNegro = new Prenda("Zapatos Negros", zapato, cuero, colorNegro, lisa);
		final Prenda unaZapatillaLonaBlanca = new Prenda("Zapatillas de lona blancas", zapatilla, lona, colorBlanco, colorNegro, cuadros);
		final Prenda unLenteNegro = new Prenda("Lentes de sol  negros", lentes, plastico, colorNegro, lisa);

		/* Luego creamos los guardarropas y las personas */
		final Usuario ines = new Usuario("Ines");
		ines.setPassword("ines123");
		final Guardarropa guardarropaInesUno = new Guardarropa();
		final Guardarropa guardarropaInesDos = new Guardarropa();
		guardarropaInesUno.setNombre("Guardarropas Uno");
		guardarropaInesDos.setNombre("Guardarropas Dos");		
		
		System.out.println("Se creo el mundo inicial");
		
		
		/*Persistiendo*/
		
		emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		repositorio = new Repositorio(emFactory.createEntityManager());
		
		System.out.println("Arrancando");

		ines.agregarGuardarropa(guardarropaInesUno); 
		ines.agregarGuardarropa(guardarropaInesDos); 		
		
		guardarropaInesUno.agregarAGuardarropas(unaRemeraBlancaLisa);
		guardarropaInesUno.agregarAGuardarropas(unaRemeraRoja);
		guardarropaInesUno.agregarAGuardarropas(unPantalonNegro);
		guardarropaInesUno.agregarAGuardarropas(unZapatoNegro);
		guardarropaInesUno.agregarAGuardarropas(unaZapatillaLonaBlanca);
		guardarropaInesDos.agregarAGuardarropas(unLenteNegro);	
	    
	    //Persisto Colores
	    repositorio.color().persistir(colorBlanco);
	    repositorio.color().persistir(colorRojo);
	    repositorio.color().persistir(colorNegro);
	    repositorio.color().persistir(colorVerde);
	    repositorio.color().persistir(colorAzulTrafico);
		
		//Persisto Tramas
	    repositorio.trama().persistir(lunares);
	    repositorio.trama().persistir(estampada);
	    repositorio.trama().persistir(rayada);
	    repositorio.trama().persistir(cuadros);
	    repositorio.trama().persistir(lisa);
	    
	    //Persisto Materiales
	    repositorio.material().persistir(algodon);
	    repositorio.material().persistir(jean);
	    repositorio.material().persistir(lino);
	    repositorio.material().persistir(gabardina);
	    repositorio.material().persistir(seda);
	    repositorio.material().persistir(cuero);
	    repositorio.material().persistir(plastico);
	    repositorio.material().persistir(cristal);
	    repositorio.material().persistir(oro);
	    repositorio.material().persistir(cuerina);
	    repositorio.material().persistir(plata);	    
	    repositorio.material().persistir(lona);	
	    repositorio.material().persistir(lana);		    
	    repositorio.material().persistir(poliester);	
	    repositorio.material().persistir(acrilico);	
	    repositorio.material().persistir(corderoy);	
	    repositorio.material().persistir(bengalina);	
	    repositorio.material().persistir(cuero);	
	    
	    //Persisto tipos de prendas
	    repositorio.tipo().persistir(remera);
		repositorio.tipo().persistir(buzo);
		repositorio.tipo().persistir(campera);
		repositorio.tipo().persistir(zapato);
		repositorio.tipo().persistir(zapatilla);
		repositorio.tipo().persistir(ojotas);
		repositorio.tipo().persistir(pantalonCorto);
		repositorio.tipo().persistir(pantalon);
		repositorio.tipo().persistir(lentes);		 
	    
	    //Persisto Usuarios
	    repositorio.usuario().persistir(ines);   
	    
	    //Persisto Prendas		
		repositorio.prenda().persistir(unaRemeraBlancaLisa);
		repositorio.prenda().persistir(unaRemeraRoja);
		repositorio.prenda().persistir(unPantalonNegro);
		repositorio.prenda().persistir(unZapatoNegro);
		repositorio.prenda().persistir(unaZapatillaLonaBlanca);
		repositorio.prenda().persistir(unLenteNegro);		
		
	    //Persisto Guardarropas
		repositorio.guardarropa().persistir(guardarropaInesUno);		
		
		//PROBANDO CALIFICAR SUGERENCIAS
		
	   //ines.crearEvento(LocalDate.now(), "Las Toninas", "3431608");
	    ines.pedirSugerencia();	    
	    //Sugerencia sugerencia2 = new Sugerencia(ines.getManagerDeEventos().getListaDePrendasTemporal());
    
	    //ines.crearEvento(LocalDate.now(), "Miamiii", "4174383");
	    ines.pedirSugerencia();
	    //Sugerencia sugerencia1 = new Sugerencia(ines.getManagerDeEventos().getListaDePrendasTemporal());
	    
	    System.out.println("Ines es friolenta, así que modifica su percepcionDeTemperatura");
	    ines.getPercepcion().modificarPercepcionCabeza(-2);
	    ines.getPercepcion().modificarPercepcionCalzado(-1);
	    ines.getPercepcion().modificarPercepcionTorso(-4);
	    
	    repositorio.usuario().persistir(ines);
	    repositorio.evento().persistir(ines.getManagerDeEventos().getEventoTemporal());
   	    
	    repositorio.cerrar();
		emFactory.close();   
 
	}
	
}
