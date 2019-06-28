package main;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import componentes.Categoria;
import componentes.Color;
import componentes.Material;
import componentes.Prenda;
import componentes.TipoDePrenda;
import componentes.Trama;
import guardarropas.Guardarropa;
import usuario.Usuario;
import usuario.UsuarioGratuito;

public class mainDeclaracionPrenda {

	public static void main(String[] args) throws Exception {
		 Set<Material> tiposDeMaterialRemera;
		 Set <Material> tiposDeMaterialZapato;
		 Set <Material> tiposDeMaterialZapatilla;
		 Set <Material> tiposDeMaterialPantalon;
		 Set <Material> tiposDeMaterialLentes;
		

		Usuario ines = new UsuarioGratuito();
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
			
			
		    guardarropaInesUno = new Guardarropa();
		    
		    System.out.println(guardarropaInesUno.cantidadDePrendas());
		    guardarropaInesUno.agregarAGuardarropas(unaRemeraBlancaLisa);
		    System.out.println(guardarropaInesUno.cantidadDePrendas());
		    guardarropaInesUno.agregarAGuardarropas(unaRemeraRoja);
		    System.out.println(guardarropaInesUno.cantidadDePrendas());
		    guardarropaInesUno.agregarAGuardarropas(unPantalonNegro);
		    guardarropaInesUno.agregarAGuardarropas(unZapatoNegro);
		    guardarropaInesUno.agregarAGuardarropas(unaZapatillaLonaBlanca);
		    guardarropaInesUno.agregarAGuardarropas(unLenteNegro); 	
	  
		    
		    System.out.println("el guardarropas tiene: " + guardarropaInesUno.getPrendasSuperiores().size() + " prendas superiores");
		    System.out.println("el guardarropas tiene: " + guardarropaInesUno.getPrendasInferiores().size() + " prendas inferiores");
		    System.out.println("el guardarropas tiene: " + guardarropaInesUno.getCalzados().size() + " calzados");
		    System.out.println("el guardarropas tiene: " + guardarropaInesUno.getAccesorios().size() + " accesorio");
			Set<List<Prenda>> sugerencias = guardarropaInesUno.sugerir();
			sugerencias.forEach(sugerencia -> System.out.println(sugerencia));
			
	}
	
}
