package Componentes;

public class PrendaBuildDirector {
	
	public Prenda construirPantalonDosColoresAlgodonConCuadros(){
		PrendaBuilder builder = new PrendaBuilder();
		builder.setTipoPrenda(TipoDePrenda.PANTALON);
		builder.setMaterial(Material.ALGODON);
		builder.setColorPrincipal(new Color(0,0,200));
		builder.setColorSecundario(new Color(110,10,0));
		builder.setTrama(Trama.CUADROS);
		return builder.getResult();
	

	}

}
