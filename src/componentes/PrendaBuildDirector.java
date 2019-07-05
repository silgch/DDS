package componentes;

import java.util.Set;

import componentes.Color;
import componentes.Material;
import componentes.Prenda;
import componentes.PrendaBuilder;
import componentes.PrendaNivel;
import componentes.TipoDePrenda;
import componentes.Trama;

public class PrendaBuildDirector {
	
	private static Set <Material> tiposDeMaterialRemera;
	private static Set <Material> tiposDeMaterialCampera;
	private static Set <Material> tiposDeMaterialZapato;
	private static Set <Material> tiposDeMaterialZapatilla;
	private static Set <Material> tiposDeMaterialPantalon;
	private static Set <Material> tiposDeMaterialAccesorios;
	
	static TipoDePrenda remera = new  TipoDePrenda("Remera",Categoria.PARTE_SUPERIOR, tiposDeMaterialRemera,PrendaNivel.Nivel1);
	static TipoDePrenda campera = new  TipoDePrenda("Campera",Categoria.PARTE_SUPERIOR, tiposDeMaterialCampera,PrendaNivel.Nivel4);
	static TipoDePrenda zapato= new TipoDePrenda("Zapato", Categoria.CALZADO, tiposDeMaterialZapato,PrendaNivel.Nivel2);
	static TipoDePrenda zapatilla = new TipoDePrenda("Zapatilla", Categoria.CALZADO, tiposDeMaterialZapatilla,PrendaNivel.Nivel2);
	static TipoDePrenda pantalon = new TipoDePrenda("Pantalon",Categoria.PARTE_INFERIOR, tiposDeMaterialPantalon,PrendaNivel.Nivel3);
	static TipoDePrenda lentes = new TipoDePrenda("Lentes de sol", Categoria.ACCESORIOS, tiposDeMaterialAccesorios,PrendaNivel.Nivel1);
	static TipoDePrenda reloj = new TipoDePrenda("Reloj", Categoria.ACCESORIOS, tiposDeMaterialAccesorios,PrendaNivel.Nivel1);	
	
	public static Prenda construirPantalonDosColoresAlgodonConCuadros(){
		PrendaBuilder builder = new PrendaBuilder();
		builder.setNombre("pantalonDosColoresAlgodonConCuadros");
		builder.setTipoPrenda(pantalon);
		builder.setMaterial(Material.ALGODON);
		builder.setColorPrincipal(new Color(0,0,200));
		builder.setColorSecundario(new Color(110,10,0));
		builder.setTrama(Trama.CUADROS);
		return builder.getResult();

	}
	
	public static Prenda construirRemeraRoja(){
		PrendaBuilder builder = new PrendaBuilder();
		builder.setNombre("remeraRoja");
		builder.setTipoPrenda(remera);
		builder.setMaterial(Material.ALGODON);
		builder.setColorPrincipal(new Color(200,0,0));
		builder.setColorSecundario(new Color(110,10,0));
		builder.setTrama(Trama.ESTAMPADA);
		return builder.getResult();
		//Prenda prendaRemeraRoja= new Prenda(TipoDePrenda.REMERA, Material.ALGODON, new Color(200,0,0), new Color(110,10,0),Trama.ESTAMPADA);
	}
	
	public static Prenda construirRemeraAzul(){
		PrendaBuilder builder = new PrendaBuilder();
		builder.setNombre("remeraAzul");
		builder.setTipoPrenda(remera);
		builder.setMaterial(Material.ALGODON);
		builder.setColorPrincipal(new Color(0,0,100));
		builder.setTrama(Trama.CUADROS);
		return builder.getResult();
		//Prenda prendaRemeraAzul= new Prenda(TipoDePrenda.REMERA, Material.ALGODON, new Color(0,0,100),Trama.CUADROS);
	}
	
	public static Prenda construirRemeraVerde(){
		PrendaBuilder builder = new PrendaBuilder();
		builder.setNombre("remeraVerde");
		builder.setTipoPrenda(remera);
		builder.setMaterial(Material.ALGODON);
		builder.setColorPrincipal(new Color(0,150,100));
		builder.setTrama(Trama.LISA);
		return builder.getResult();
		//Prenda prendaRemeraAzul= new Prenda(TipoDePrenda.REMERA, Material.ALGODON, new Color(0,0,100),Trama.CUADROS);
	}
	
	public static Prenda construirPantalonCorderoy(){
		PrendaBuilder builder = new PrendaBuilder();
		builder.setNombre("pantalonCorderoy");
		builder.setTipoPrenda(pantalon);
		builder.setMaterial(Material.CORDEROY);
		builder.setColorPrincipal(new Color(0,70,100));
		builder.setTrama(Trama.LISA);
		return builder.getResult();
		//Prenda prendaPantalonCorderoy= new Prenda(TipoDePrenda.PANTALON, Material.CORDEROY, new Color(0,70,100),Trama.LISA);

	}
	
	public static Prenda construirPantalonJean(){
		PrendaBuilder builder = new PrendaBuilder();
		builder.setNombre("pantalonJean");
		builder.setTipoPrenda(pantalon);
		builder.setMaterial(Material.JEAN);
		builder.setColorPrincipal(new Color(0,0,200));
		builder.setTrama(Trama.LISA);
		return builder.getResult();
		//Prenda prendaPantalonJean = new Prenda(TipoDePrenda.PANTALON, Material.JEAN, new Color(0,0,200),Trama.LISA);

	}
	
	public static Prenda construirPantalonRockero(){
		PrendaBuilder builder = new PrendaBuilder();
		builder.setNombre("pantalonRockero");
		builder.setTipoPrenda(pantalon);
		builder.setMaterial(Material.CUERO);
		builder.setColorPrincipal(new Color(200,200,200));
		builder.setTrama(Trama.LISA);
		return builder.getResult();
		//Prenda prendaPantalonJean = new Prenda(TipoDePrenda.PANTALON, Material.JEAN, new Color(0,0,200),Trama.LISA);

	}
	
	public static Prenda construirZapatillaLona(){
		PrendaBuilder builder = new PrendaBuilder();
		builder.setNombre("zapatillaLona");
		builder.setTipoPrenda(zapatilla);
		builder.setMaterial(Material.LONA);
		builder.setColorPrincipal(new Color(0,200,200));
		builder.setTrama(Trama.LISA);
		return builder.getResult();
		//Prenda prendaZapatillaLona= new Prenda(TipoDePrenda.ZAPATILLAS, Material.LONA, new Color(0,200,200),Trama.LISA);

	}
	
	public static Prenda construirZapatillaCuero(){
		PrendaBuilder builder = new PrendaBuilder();
		builder.setNombre("zapatillaCuero");
		builder.setTipoPrenda(zapatilla);
		builder.setMaterial(Material.CUERO);
		builder.setColorPrincipal(new Color(0,0,0));
		builder.setTrama(Trama.LISA);
		return builder.getResult();
		//Prenda prendaZapatillaCuero= new Prenda(TipoDePrenda.ZAPATILLAS, Material.CUERO, new Color(0,0,0),Trama.LISA);

	}
	
	public static Prenda construirBotaCuero(){
		PrendaBuilder builder = new PrendaBuilder();
		builder.setNombre("zapatoCuero");
		builder.setTipoPrenda(zapato);
		builder.setMaterial(Material.CUERO);
		builder.setColorPrincipal(new Color(0,200,200));
		builder.setTrama(Trama.LISA);
		return builder.getResult();
		//Prenda prendaBotaCuero = new Prenda(TipoDePrenda.BOTAS, Material.CUERO, new Color(0,200,200),Trama.LISA);

	}
	
	public static Prenda construirBotaCuerina(){
		PrendaBuilder builder = new PrendaBuilder();
		builder.setNombre("zapatoCuerina");
		builder.setTipoPrenda(zapato);
		builder.setMaterial(Material.CUERINA);
		builder.setColorPrincipal(new Color(0,200,200));
		builder.setTrama(Trama.LISA);
		return builder.getResult();
		//Prenda prendaBotaCuerina = new Prenda(TipoDePrenda.BOTAS, Material.CUERINA, new Color(0,200,200),Trama.LISA);
	}
	
	public static Prenda construirRelojOro(){
		PrendaBuilder builder = new PrendaBuilder();
		builder.setNombre("relojOro");
		builder.setTipoPrenda(reloj);
		builder.setMaterial(Material.ORO);
		builder.setColorPrincipal(new Color(234,190,63));
		builder.setTrama(Trama.LISA);
		return builder.getResult();
		//Prenda relojOro = new Prenda(TipoDePrenda.RELOJ,  Material.ORO, new Color(234, 190, 63),Trama.LISA);
	}
	
	public static Prenda construirRelojPlastico(){
		PrendaBuilder builder = new PrendaBuilder();
		builder.setNombre("relojPlastico");
		builder.setTipoPrenda(reloj);
		builder.setMaterial(Material.PLASTICO);
		builder.setColorPrincipal(new Color(345,390,67));
		builder.setTrama(Trama.LUNARES);
		return builder.getResult();
		//Prenda relojOro = new Prenda(TipoDePrenda.RELOJ,  Material.ORO, new Color(234, 190, 63),Trama.LISA);
	}
	
	public static Prenda construirRemeraNegra(){
		PrendaBuilder builder = new PrendaBuilder();
		builder.setNombre("remeraNegra");
		builder.setTipoPrenda(remera);
		builder.setMaterial(Material.ALGODON);
		builder.setColorPrincipal(new Color(0,0,0));
		builder.setTrama(Trama.LISA);
		return builder.getResult();
	}
	
	public static Prenda construirPantalonNegro(){
		PrendaBuilder builder = new PrendaBuilder();
		builder.setNombre("pantalonNegro");
		builder.setTipoPrenda(pantalon);
		builder.setMaterial(Material.JEAN);
		builder.setColorPrincipal(new Color(0,0,0));
		builder.setTrama(Trama.LISA);
		return builder.getResult();
	}
	
	public static Prenda construirZapatillasNegros(){
		PrendaBuilder builder = new PrendaBuilder();
		builder.setNombre("zapatillasNegras");
		builder.setTipoPrenda(zapatilla);
		builder.setMaterial(Material.CUERO);
		builder.setColorPrincipal(new Color(0,0,0));
		builder.setTrama(Trama.LISA);
		return builder.getResult();
	}
	
	public static Prenda construirLentesNegros(){
		PrendaBuilder builder = new PrendaBuilder();
		builder.setNombre("lentesNegros");
		builder.setTipoPrenda(lentes);
		builder.setMaterial(Material.PLASTICO);
		builder.setColorPrincipal(new Color(0,0,0));
		builder.setTrama(Trama.LISA);
		return builder.getResult();
	}
	
	public static Prenda construirCamperaCuero(){
		PrendaBuilder builder = new PrendaBuilder();
		builder.setNombre("camperaCuero");
		builder.setTipoPrenda(campera);
		builder.setMaterial(Material.CUERO);
		builder.setColorPrincipal(new Color(200,0,0));
		builder.setColorSecundario(new Color(110,10,0));
		builder.setTrama(Trama.LISA);
		return builder.getResult();
	}
}