/*package guardarropas;

import componentes.Prenda;

public class OrganizadorDeGuardarropa {
	private Guardarropa miGuardarropa;
	
	public OrganizadorDeGuardarropa(Guardarropa guardarropa) {
		miGuardarropa = guardarropa;
	}

	public void organizameEsta(Prenda prenda) throws Exception{
		switch (prenda.getCategoria()) {
	        case PARTE_SUPERIOR:
	        	this.agregarPrendaSuperior(prenda);
	            break;
	        case PARTE_INFERIOR:
	        	this.agregarPrendaInferior(prenda);
	            break;
	        case CALZADO:
	        	this.agregarCalzado(prenda);
	            break;
	        case ACCESORIO:
	        	this.agregarAccesorio(prenda);
	        	break;
	        default:
	            throw new Exception("Ha ingresado una categoria Invalida.");
		}
	}
	//Estos Metodos se utilizan para agregar a la lista de la categoria correspondiente en el guardarropas
	
	private void agregarPrendaSuperior(Prenda _prenda) throws Exception {
	    //this.prendasInferiores.add(_prenda);  
		 switch (_prenda.getNivel()) {
		     case Nivel1:
		    	 this.agregarPrendaSuperiorNivel1(_prenda);
		         break;
		     case Nivel2:
		    	 this.agregarPrendaSuperiorNivel2(_prenda);
		         break;
		     case Nivel3:
		    	 this.agregarPrendaSuperiorNivel3(_prenda);
		         break;
		     case Nivel4:
		    	 this.agregarPrendaSuperiorNivel4(_prenda);
		     	break;
		     default:
		         throw new Exception("Ha ingresado una categoria Invalida.");
	 }
	}
	private void agregarPrendaInferior(Prenda _prenda) throws Exception {
	    //this.prendasInferiores.add(_prenda);  
		 switch (_prenda.getNivel()) {
		     case Nivel1:
		    	 this.agregarPrendaInferiorNivel1(_prenda);
		         break;
		     case Nivel2:
		    	 this.agregarPrendaInferiorNivel2(_prenda);
		         break;
		     case Nivel3:
		    	 this.agregarPrendaInferiorNivel3(_prenda);
		         break;
		     default:
		         throw new Exception("Ha ingresado una categoria Invalida.");
	 }
	}

	private void agregarCalzado(Prenda _prenda) throws Exception {
	    //this.prendasInferiores.add(_prenda);  
		 switch (_prenda.getNivel()) {
		     case Nivel1:
		    	 this.agregarCalzadoNivel1(_prenda);
		         break;
		     case Nivel2:
		    	 this.agregarCalzadoNivel2(_prenda);
		         break;
		     default:
		         throw new Exception("Ha ingresado una categoria Invalida.");
		 }
	}

	void agregarAccesorio(Prenda prenda) {
		miGuardarropa.accesorios.add(prenda);          
	}
    void agregarPrendaSuperiorNivel1(Prenda prenda) {
        miGuardarropa.prendasSuperioresNivel1.add(prenda);          
    }
    void agregarPrendaSuperiorNivel2(Prenda prenda) {
        miGuardarropa.prendasSuperioresNivel2.add(prenda);          
    }
    void agregarPrendaSuperiorNivel3(Prenda prenda) {
        miGuardarropa.prendasSuperioresNivel3.add(prenda);          
    }
    void agregarPrendaSuperiorNivel4(Prenda prenda) {
        miGuardarropa.prendasSuperioresNivel4.add(prenda);          
    }
    void agregarPrendaInferiorNivel1(Prenda prenda) {
        miGuardarropa.prendasInferioresNivel1.add(prenda);          
    }
    void agregarPrendaInferiorNivel2(Prenda prenda) {
        miGuardarropa.prendasInferioresNivel2.add(prenda);          
    }
    void agregarPrendaInferiorNivel3(Prenda prenda) {
        miGuardarropa.prendasInferioresNivel3.add(prenda);          
    }
    void agregarCalzadoNivel1(Prenda _prenda) {
        miGuardarropa.calzadosNivel1.add(_prenda);          
    }
    void agregarCalzadoNivel2(Prenda _prenda) {
        miGuardarropa.calzadosNivel2.add(_prenda);          
    }
}
*/
