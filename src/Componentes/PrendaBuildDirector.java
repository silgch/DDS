package Componentes;

public class PrendaBuildDirector {
	
	public static Prenda construirPantalonDosColoresAlgodonConCuadros(){
		PrendaBuilder builder = new PrendaBuilder();
		builder.setNombre("pantalonDosColoresAlgodonConCuadros");
		builder.setTipoPrenda(TipoDePrenda.PANTALON);
		builder.setMaterial(Material.ALGODON);
		builder.setColorPrincipal(new Color(0,0,200));
		builder.setColorSecundario(new Color(110,10,0));
		builder.setTrama(Trama.CUADROS);
		return builder.getResult();

	}
	
	public static Prenda construirRemeraRoja(){
		PrendaBuilder builder = new PrendaBuilder();
		builder.setNombre("remeraRoja");
		builder.setTipoPrenda(TipoDePrenda.REMERA);
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
		builder.setTipoPrenda(TipoDePrenda.REMERA);
		builder.setMaterial(Material.ALGODON);
		builder.setColorPrincipal(new Color(0,0,100));
		builder.setTrama(Trama.CUADROS);
		return builder.getResult();
		//Prenda prendaRemeraAzul= new Prenda(TipoDePrenda.REMERA, Material.ALGODON, new Color(0,0,100),Trama.CUADROS);
	}
	
	public static Prenda construirRemeraVerde(){
		PrendaBuilder builder = new PrendaBuilder();
		builder.setNombre("remeraVerde");
		builder.setTipoPrenda(TipoDePrenda.REMERA);
		builder.setMaterial(Material.ALGODON);
		builder.setColorPrincipal(new Color(0,150,100));
		builder.setTrama(Trama.LISA);
		return builder.getResult();
		//Prenda prendaRemeraAzul= new Prenda(TipoDePrenda.REMERA, Material.ALGODON, new Color(0,0,100),Trama.CUADROS);
	}
	
	public static Prenda construirPantalonCorderoy(){
		PrendaBuilder builder = new PrendaBuilder();
		builder.setNombre("pantalonCorderoy");
		builder.setTipoPrenda(TipoDePrenda.PANTALON);
		builder.setMaterial(Material.CORDEROY);
		builder.setColorPrincipal(new Color(0,70,100));
		builder.setTrama(Trama.LISA);
		return builder.getResult();
		//Prenda prendaPantalonCorderoy= new Prenda(TipoDePrenda.PANTALON, Material.CORDEROY, new Color(0,70,100),Trama.LISA);

	}
	
	public static Prenda construirPantalonJean(){
		PrendaBuilder builder = new PrendaBuilder();
		builder.setNombre("pantalonJean");
		builder.setTipoPrenda(TipoDePrenda.PANTALON);
		builder.setMaterial(Material.JEAN);
		builder.setColorPrincipal(new Color(0,0,200));
		builder.setTrama(Trama.LISA);
		return builder.getResult();
		//Prenda prendaPantalonJean = new Prenda(TipoDePrenda.PANTALON, Material.JEAN, new Color(0,0,200),Trama.LISA);

	}
	
	public static Prenda construirPantalonRockero(){
		PrendaBuilder builder = new PrendaBuilder();
		builder.setNombre("pantalonRockero");
		builder.setTipoPrenda(TipoDePrenda.PANTALON);
		builder.setMaterial(Material.CUERO);
		builder.setColorPrincipal(new Color(200,200,200));
		builder.setTrama(Trama.LISA);
		return builder.getResult();
		//Prenda prendaPantalonJean = new Prenda(TipoDePrenda.PANTALON, Material.JEAN, new Color(0,0,200),Trama.LISA);

	}
	
	public static Prenda construirZapatillaLona(){
		PrendaBuilder builder = new PrendaBuilder();
		builder.setNombre("zapatillaLona");
		builder.setTipoPrenda(TipoDePrenda.ZAPATILLAS);
		builder.setMaterial(Material.LONA);
		builder.setColorPrincipal(new Color(0,200,200));
		builder.setTrama(Trama.LISA);
		return builder.getResult();
		//Prenda prendaZapatillaLona= new Prenda(TipoDePrenda.ZAPATILLAS, Material.LONA, new Color(0,200,200),Trama.LISA);

	}
	
	public static Prenda construirZapatillaCuero(){
		PrendaBuilder builder = new PrendaBuilder();
		builder.setNombre("zapatillaCuero");
		builder.setTipoPrenda(TipoDePrenda.ZAPATILLAS);
		builder.setMaterial(Material.CUERO);
		builder.setColorPrincipal(new Color(0,0,0));
		builder.setTrama(Trama.LISA);
		return builder.getResult();
		//Prenda prendaZapatillaCuero= new Prenda(TipoDePrenda.ZAPATILLAS, Material.CUERO, new Color(0,0,0),Trama.LISA);

	}
	
	public static Prenda construirBotaCuero(){
		PrendaBuilder builder = new PrendaBuilder();
		builder.setNombre("botaCuero");
		builder.setTipoPrenda(TipoDePrenda.BOTAS);
		builder.setMaterial(Material.CUERO);
		builder.setColorPrincipal(new Color(0,200,200));
		builder.setTrama(Trama.LISA);
		return builder.getResult();
		//Prenda prendaBotaCuero = new Prenda(TipoDePrenda.BOTAS, Material.CUERO, new Color(0,200,200),Trama.LISA);

	}
	
	public static Prenda construirBotaCuerina(){
		PrendaBuilder builder = new PrendaBuilder();
		builder.setNombre("botaCuerina");
		builder.setTipoPrenda(TipoDePrenda.BOTAS);
		builder.setMaterial(Material.CUERINA);
		builder.setColorPrincipal(new Color(0,200,200));
		builder.setTrama(Trama.LISA);
		return builder.getResult();
		//Prenda prendaBotaCuerina = new Prenda(TipoDePrenda.BOTAS, Material.CUERINA, new Color(0,200,200),Trama.LISA);
	}
	
	public static Prenda construirRelojOro(){
		PrendaBuilder builder = new PrendaBuilder();
		builder.setNombre("relojOro");
		builder.setTipoPrenda(TipoDePrenda.RELOJ);
		builder.setMaterial(Material.ORO);
		builder.setColorPrincipal(new Color(234,190,63));
		builder.setTrama(Trama.LISA);
		return builder.getResult();
		//Prenda relojOro = new Prenda(TipoDePrenda.RELOJ,  Material.ORO, new Color(234, 190, 63),Trama.LISA);
	}
	
	public static Prenda construirRelojPlastico(){
		PrendaBuilder builder = new PrendaBuilder();
		builder.setNombre("relojPlastico");
		builder.setTipoPrenda(TipoDePrenda.RELOJ);
		builder.setMaterial(Material.PLASTICO);
		builder.setColorPrincipal(new Color(345,390,67));
		builder.setTrama(Trama.LUNARES);
		return builder.getResult();
		//Prenda relojOro = new Prenda(TipoDePrenda.RELOJ,  Material.ORO, new Color(234, 190, 63),Trama.LISA);
	}
	
}
