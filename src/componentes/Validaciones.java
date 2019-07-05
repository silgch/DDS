package componentes;

public class Validaciones {

	public static void validarCreacionPrenda(String nombre,TipoDePrenda tipo,  Material material, Color colorPrincipal, Trama trama) {
		constructorSinNull(nombre,tipo,material,colorPrincipal,trama);
		tipo.puedeSerDeMaterial(material);
	}
	
	
	public static  void validarCreacionPrenda(String nombre, TipoDePrenda tipo,
	Material material,Color colorPrincipal, Color colorSecundario, Trama trama){
		validarCreacionPrenda( nombre, tipo,  material,  colorPrincipal, trama);
	}
	
    public static void constructorSinNull(String nombre, TipoDePrenda tipo, Material material, Color colorPrincipal, Trama trama) {
    		boolean check = 
    			(nombre==null||tipo==null||material==null||
				colorPrincipal==null||trama==null);
			if(check) {
	        	throw new IllegalArgumentException("Todos los parametros del constructor deben ser distintos de null");
	        }
		}
	}
/*
     public static void constructorSinNull(String nombre, TipoDePrenda tipo, Material material, Color colorPrincipal, Trama trama) {
    	
		boolean check= false;
		try {

		check= (nombre==null||tipo==null||material==null||
				colorPrincipal==null||trama==null);
			if(check) {
	        	throw new IllegalArgumentException("Todos los parametros del constructor deben ser distintos de null");
	        }
		}
		catch(IllegalArgumentException e) {
			System.out.println(e);
			
		}
*/
