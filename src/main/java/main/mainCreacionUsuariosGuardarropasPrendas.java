/*
	Se crean 7 prendas (con sus tipos, colores, materiales, etc)
	Se crea un usuario gratuito con 2 guardarropas
	Se le agregan distintas prendas a los guardarropas
	Se muestran por pantalla las distintas prendas del guardarropas
	se aceptan y rechazan sugerencias pero no intervienen ni prendas ni usuarios
*/

package main;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import componentes.Categoria;
import componentes.Color;
import componentes.Material;
import componentes.Prenda;
import componentes.PrendaNivel;
import componentes.TipoDePrenda;
import componentes.Trama;
import eventos.Sugerencia;
import guardarropas.Guardarropa;
import repositorio.Repositorio;
import usuario.Usuario;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class mainCreacionUsuariosGuardarropasPrendas {
	
	private static final String PERSISTENCE_UNIT_NAME = "DDS";
	private static EntityManagerFactory emFactory;
	private static Repositorio repositorio;
	
	
	public static void main(String[] args) throws Exception {
		
		/* Primero creamos los atributos basicos de las prendas */
		
		
		
		/*
		 * ALGODON, JEAN, LINO, GABARDINA, SEDA, CUERO, PLASTICO, CRISTAL, ORO, CUERINA,
		 * PLATA, LONA, LANA, POLIESTER, ACRILICO, CORDEROY, BENGALINA, CAUCHO
		 */
		
		Material algodon=new Material("Aldodon");
		Material jean=new Material("Jean");
		Material lino=new Material("Lino");
		Material gabardina=new Material("Gabardina");
		Material seda=new Material("Seda");
		Material cuero=new Material("Cuero");
		Material plastico=new Material("Plastico");
		Material cristal=new Material("Cristal");
		Material oro=new Material("Oro");
		Material cuerina=new Material("Cuerina");
		Material plata=new Material("Plata");
		Material lona=new Material("Lona");
		Material lana=new Material("Lana");
		Material poliester=new Material("Poliester");
		Material acrilico=new Material("Acrilico");
		Material corderoy=new Material("Corderoy");
		Material bengalina=new Material("Bengalina");
		Material caucho=new Material("Caucho");
		
		Set <Material> tiposDeMaterialRemera;
		Set <Material> tiposDeMaterialZapato;
		Set <Material> tiposDeMaterialZapatilla;
		Set <Material> tiposDeMaterialPantalon;
		Set <Material> tiposDeMaterialLentes;				
		Color colorBlanco=new Color(255,255,0);
		Color colorRojo=new Color (255,0,0);
		Color colorNegro=new Color(10,10,10);
		Color colorVerde=new Color(0,255,0);
		Color colorAzulTrafico=new Color(006,057,113);
		tiposDeMaterialRemera = new HashSet<Material>();
		tiposDeMaterialPantalon = new HashSet<Material>();
		tiposDeMaterialZapato= new HashSet<Material>();
		tiposDeMaterialZapatilla= new HashSet<Material>();
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

		//LISA, ESTAMPADA, RAYADA, LUNARES, CUADROS, 
		
		Trama lisa= new Trama("Lisa");
		Trama estampada= new Trama("Estampada");		
		Trama rayada= new Trama("Rayada");	
		Trama cuadros= new Trama("Cuadros");	
		Trama lunares= new Trama("Lunares");	
		
		/* Luego creamos tipos de prendas particulares */
		TipoDePrenda remera = new  TipoDePrenda("Remera",Categoria.PARTE_SUPERIOR, tiposDeMaterialRemera,PrendaNivel.Nivel1);
		TipoDePrenda buzo = new TipoDePrenda("Buzo",Categoria.PARTE_SUPERIOR, null,PrendaNivel.Nivel2);
		TipoDePrenda campera = new TipoDePrenda("Campera",Categoria.PARTE_SUPERIOR, null,PrendaNivel.Nivel3);		
		TipoDePrenda zapato= new TipoDePrenda("Zapato", Categoria.CALZADO, tiposDeMaterialZapato,PrendaNivel.Nivel2);
		TipoDePrenda zapatilla = new TipoDePrenda("Zapatilla", Categoria.CALZADO, tiposDeMaterialZapatilla,PrendaNivel.Nivel2);
		TipoDePrenda ojotas = new TipoDePrenda("Ojotas", Categoria.CALZADO, null,PrendaNivel.Nivel1);
		TipoDePrenda pantalonCorto = new TipoDePrenda("Pantalon Corto",Categoria.PARTE_INFERIOR, tiposDeMaterialPantalon,PrendaNivel.Nivel2);
		TipoDePrenda pantalon = new TipoDePrenda("Pantalon",Categoria.PARTE_INFERIOR, tiposDeMaterialPantalon,PrendaNivel.Nivel1);
		TipoDePrenda lentes = new TipoDePrenda("Lentes de sol", Categoria.ACCESORIO, tiposDeMaterialLentes,PrendaNivel.Nivel1);
		
		/* Luego creamos las Prendas que estarán en los guardarropas*/
		Prenda unaRemeraBlancaLisa = new Prenda("Remera Blanca lisa", remera, algodon, colorBlanco, lisa );
		Prenda unaRemeraRoja = new Prenda("Remera Roja a lunares", remera, seda, colorRojo, lunares);
		Prenda unaRemeraNegra= new Prenda("Remera Negra Basica", remera, algodon, colorNegro, lisa);
		Prenda unBuzoNegro = new Prenda("Buzo Negro", buzo, cuero, colorNegro, rayada);
		Prenda unaCamperaNegra = new Prenda("Campera Negra", campera, cuero, colorNegro, estampada);
		Prenda unPantalonNegro = new Prenda("Pantalon Negro", pantalon, corderoy, colorNegro, lisa);
		Prenda unZapatoNegro = new Prenda("Zapatos Negros", zapato, cuero, colorNegro, lisa);
		Prenda unaZapatillaLonaBlanca = new Prenda("Zapatillas de lona blancas", zapatilla, lona, colorBlanco,colorNegro, cuadros);
		Prenda unasHavaianas = new Prenda("Ojotas Havaianas",ojotas,caucho, colorNegro,lisa);
		Prenda unLenteNegro = new Prenda("Lentes de sol  negros", lentes, plastico, colorNegro, lisa);
		
				
		/*Luego creamos los guardarropas y las personas */
		Usuario ines = new Usuario("Ines");	
		Guardarropa guardarropaInesUno = new Guardarropa();
		
		
		System.out.println("Se creo el mundo inicial");
		
		
		/*Persistiendo*/
		
		emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		repositorio = new Repositorio(emFactory.createEntityManager());
		
		System.out.println("Arrancando");

		ines.agregarGuardarropa(guardarropaInesUno);
	    
	    guardarropaInesUno.agregarAGuardarropas(unaRemeraBlancaLisa);
	    guardarropaInesUno.agregarAGuardarropas(unaRemeraRoja);
	    guardarropaInesUno.agregarAGuardarropas(unPantalonNegro);
	    guardarropaInesUno.agregarAGuardarropas(unZapatoNegro);
	    guardarropaInesUno.agregarAGuardarropas(unaZapatillaLonaBlanca);
	    guardarropaInesUno.agregarAGuardarropas(unLenteNegro); 	
	    
	     repositorio.prenda().persistir(unaRemeraBlancaLisa);
	    //repositorio.prenda().persistir(unaRemeraRoja);   SI NO LOS COMENTO ME DUPLICA LAS PRENDAS PORQUE?????
		//repositorio.prenda().persistir(unPantalonNegro);
		//repositorio.prenda().persistir(unZapatoNegro);
		//repositorio.prenda().persistir(unaZapatillaLonaBlanca);
		//repositorio.prenda().persistir(unLenteNegro);
		
		//repositorio.guardarropa().persistir(guardarropaInesUno);
		
		//PROBANDO CALIFICAR SUGERENCIAS
    
	    ines.crearEvento(LocalDate.now(), "Miamiii", "4174383");
	    ines.pedirSugerencia(guardarropaInesUno);
	    Sugerencia sugerencia1 = new Sugerencia(ines.getManagerDeEventos().getListaDePrendasTemporal());
	    ines.aceptarSugerencia(sugerencia1);
	    
	    ines.crearEvento(LocalDate.now(), "Las Toninas", "3431608");
	    ines.pedirSugerencia(guardarropaInesUno);	    
	    Sugerencia sugerencia2 = new Sugerencia(ines.getManagerDeEventos().getListaDePrendasTemporal());
	    ines.rechazarSugerencia(sugerencia2);  
	    
	    System.out.println("Ines es friolenta, así que modifica su percepcionDeTemperatura");
	    ines.getPercepcion().modificarPercepcionCabeza(-2);
	    ines.getPercepcion().modificarPercepcionCalzado(-1);
	    ines.getPercepcion().modificarPercepcionTorso(-4);
	    
	   // repositorio.usuario().persistir(ines);
	    	    
	    repositorio.cerrar();
		emFactory.close();
	    
 
	}
	
}
