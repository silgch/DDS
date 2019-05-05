package uniformes;

import Entrega0.Prenda;
import Entrega0.Categoria;


public class Atuendo {
	//Un Atuendo es una combinación de prendas que tiene sentido usar juntas.

    private final Prenda parte_superior;
    private final Prenda parte_inferior;
    private final Prenda calzado;
	private final Prenda accesorio;
	
	//Constructor con Accesorio
	public Atuendo(Prenda unaParteSuperior, Prenda unaParteInferior, Prenda calzado, Prenda accesorio) throws Exception{

        if(	chequearCategorias(unaParteSuperior, unaParteInferior, calzado) &&
            accesorio.getCategoria() == Categoria.ACCESORIOS){
    		this.parte_superior = unaParteSuperior;
        	this.parte_inferior = unaParteInferior;
	            this.calzado = calzado;
	            this.accesorio = accesorio;
        }

        else{

            throw new Exception("Ha ingresado un atuendo NO VALIDO. Debe ingresa Parte Superior, Parte Inferior,  Calzado y Accesorio");

        }
    }
	
	//Constructor sin Accesorio
	public Atuendo(Prenda unaParteSuperior, Prenda unaParteInferior, Prenda calzado) throws Exception{

        if(	chequearCategorias(unaParteSuperior, unaParteInferior, calzado)){
        		this.parte_superior = unaParteSuperior;
            	this.parte_inferior = unaParteInferior;
	            this.calzado = calzado;
	    
        }

        else{

            throw new Exception("Ha ingresado un atuendo NO VALIDO. Debe ingresa Parte Superior, Parte Inferior y Calzado.");

        }
    }
	
	private boolean chequearCategorias(Prenda parteSuperior, Prenda parteInferior, Prenda calzado) {
		return 
				parte_superior.getCategoria() == Categoria.PARTE_SUPERIOR &&
		        parte_inferior.getCategoria() == Categoria.PARTE_INFERIOR &&
		        calzado.getCategoria() == Categoria.CALZADO;
	}
	
	//Devuelve el accesorio del atuendo.
	public Prenda getAccesorio() {
		return accesorio;
	}
}