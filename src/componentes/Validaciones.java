package componentes;

public class Validaciones {

	public static void validarCreacionPrenda(String nombre,TipoDePrenda tipo,  Material material, Color colorPrincipal, Trama trama) {
		constructorSinNull(nombre,tipo,material,colorPrincipal,trama);
		tipo.puedeSerDeMaterial(material);
	}
	
	
	public static  void validarCreacionPrenda(String nombre, TipoDePrenda tipo,	Material material,Color colorPrincipal, Color colorSecundario, Trama trama){
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
    public boolean chequearDesigualdadColores(Color unColor,Color otroColor) {
		
   		boolean check=false;
		try {
	        check= (unColor.rojo==otroColor.rojo &&
	        		unColor.azul==otroColor.azul &&
	        		unColor.amarillo==otroColor.amarillo
	        		);
	        if(check) {
	        	throw new IllegalArgumentException("Los colores deben ser distintos");
	        }
		}
		catch(IllegalArgumentException e) {
			System.out.println(e);
		}
		return check;
	}
}
