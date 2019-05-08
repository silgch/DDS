package Componentes;

public class Validaciones {

	public static boolean realizarValidacionesCincoParametros(TipoDePrenda tipo,  Material material, Color colorPrincipal, Color colorSecundario, Trama trama) {
		boolean check= true;
		try {
		
		//SE IRIAN AGREGANDO DISTINTAS VALIDACIONES
		constructorSinNullCincoParametros(tipo, material, colorPrincipal, colorSecundario, trama);
		tipo.puedeSerDeMaterial(material);
		colorPrincipal.esIgualA(colorSecundario);
		
		}
		catch(IllegalArgumentException e) {
			check = false;
			
		}
		
		return check;
	}
	
	public static boolean realizarValidacionesCuatroParametros(TipoDePrenda tipo,  Material material, Color colorPrincipal, Trama trama) {
		boolean check= true;
		try {
		
		//SE IRIAN AGREGANDO DISTINTAS VALIDACIONES	
		constructorSinNullCuatroParametros(tipo,material,colorPrincipal,trama);
		tipo.puedeSerDeMaterial(material);
		
		}
		catch(IllegalArgumentException e) {
			check = false;
			
		}
		
		return check;
	}
	
    public static void constructorSinNullCuatroParametros(TipoDePrenda tipo, Material material, Color colorPrincipal, Trama trama) {
    	
		boolean check= false;
		try {

		check= (tipo==null||
				material==null||
				colorPrincipal==null||
				trama==null);
			if(check) {
	        	throw new IllegalArgumentException("Todos los parametros del constructor deben ser distintos de null");
	        }
		}
		catch(IllegalArgumentException e) {
			System.out.println(e);
			
		}
		
	}

    public static void constructorSinNullCincoParametros(TipoDePrenda tipo, Material material, Color colorPrincipal, Color colorSecundario, Trama trama) {
    	
		boolean check= false;
		try {

		check= (tipo==null||
				material==null||
				colorPrincipal==null||
				//RECORDAR QUE AUNQUE SE INICIE CON CINCO PARAMETROS
				//colorSecundario PUEDE SER NULL
				trama==null);
			if(check) {
	        	throw new IllegalArgumentException("Todos los parametros del constructor deben ser distintos de null");
	        }
		}
		catch(IllegalArgumentException e) {
			System.out.println(e);
			
		}
		
	}
}
