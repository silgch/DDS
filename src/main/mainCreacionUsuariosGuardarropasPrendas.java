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
import eventos.Sugerencia;
import guardarropas.Guardarropa;
import usuario.Usuario;


public class mainCreacionUsuariosGuardarropasPrendas {

	public static void main(String[] args) throws Exception {
		 Set <Material> tiposDeMaterialRemera;
		 Set <Material> tiposDeMaterialZapato;
		 Set <Material> tiposDeMaterialZapatilla;
		 Set <Material> tiposDeMaterialPantalon;
		 Set <Material> tiposDeMaterialLentes;
		

		Usuario ines = new Usuario();
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
		Prenda unPantalonNegro;
		Prenda unZapatoNegro;
		Prenda unaZapatillaLonaBlanca;
		Prenda unLenteNegro;
		Guardarropa guardarropaInesUno;

		
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
			pantalon = new TipoDePrenda("Pantalon",Categoria.PARTE_INFERIOR, tiposDeMaterialPantalon,PrendaNivel.Nivel3);
			lentes = new TipoDePrenda("Lentes de sol", Categoria.ACCESORIO, tiposDeMaterialLentes,PrendaNivel.Nivel1);
			
			unaRemeraBlancaLisa = new Prenda("Remera Blanca lisa", remera, Material.ALGODON, colorBlanco, Trama.LISA );
			unaRemeraRoja= new Prenda("Remera Roja a lunares", remera, Material.SEDA, colorRojo, Trama.LUNARES);
			unPantalonNegro = new Prenda("Pantalon Negro", pantalon, Material.CORDEROY, colorNegro, Trama.LISA);
			unZapatoNegro= new Prenda("Zapatos Negros", zapato, Material.CUERO, colorNegro, Trama.LISA);
			unaZapatillaLonaBlanca= new Prenda("Zapatillas de lona blancas", zapatilla, Material.LONA, colorBlanco, Trama.LISA);
			unLenteNegro = new Prenda("Lentes de sol  negros", lentes, Material.PLASTICO, colorNegro, Trama.LISA);
			
			guardarropaInesUno = new Guardarropa();
		    guardarropaInesUno.duenio(ines);
		    
		    guardarropaInesUno.agregarAGuardarropas(unaRemeraBlancaLisa);
		    guardarropaInesUno.agregarAGuardarropas(unaRemeraRoja);
		    guardarropaInesUno.agregarAGuardarropas(unPantalonNegro);
		    guardarropaInesUno.agregarAGuardarropas(unZapatoNegro);
		    guardarropaInesUno.agregarAGuardarropas(unaZapatillaLonaBlanca);
		    guardarropaInesUno.agregarAGuardarropas(unLenteNegro); 	
		    
		    System.out.println("el guardarropas tiene: " + guardarropaInesUno.getPrendasSuperioresNivel1().size() + " prendas superiores");
		    System.out.println("el guardarropas tiene: " + guardarropaInesUno.getPrendasInferioresNivel3().size() + " prendas inferiores");
		    System.out.println("el guardarropas tiene: " + guardarropaInesUno.getCalzadosNivel2().size() + " calzados");
		    System.out.println("el guardarropas tiene: " + guardarropaInesUno.getAccesorios().size() + " accesorio");
			//guardarropaInesUno.sugerir();
			//QueMePongo.sugerirTodasLasCombinaciones(guardarropaInesUno);
		    
		    
		  //PROBANDO CALIFICAR SUGERENCIAS
		    
		    Sugerencia sugerencia1 = new Sugerencia();
		    sugerencia1.setDescripcion("Sugerencia que me gusta mucho");
		    sugerencia1.aceptarSugerencia();
		    System.out.println("Acepto la Sugerencia y El estado de la sugerencia es:" + sugerencia1.getEstado());
		    System.out.println("La calificacion de la sugerencia es:" + sugerencia1.getCalificacion());
		    sugerencia1.setCalificacion(10);
		    System.out.println("Califico con 10 y La calificacion de la sugerencia es:" + sugerencia1.getCalificacion());
		    sugerencia1.RechazarSugerencia();
		    System.out.println("Rechazo sugerencia y El estado de la sugerencia es:" + sugerencia1.getEstado());
		    
		    System.out.println("Ines No deberia de poder calificar una sugerencia Rechazada");
		    ines.calificarSugerencia(sugerencia1, 1);
			
	}
	
}
