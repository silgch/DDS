package guardarropas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import componentes.Prenda;
import queMePongo.QueMePongo;
import usuario.Usuario;

import com.google.common.collect.Sets;



//Cada Usuario tiene uno o mas guardarropas.
//Cuando un usuario crea una prenda, se la incluye en su guardarropas, mediante el metodo agregarAGuardarropas.
public class Guardarropa {
    private HashSet<Prenda> prendasSuperiores;
    private HashSet<Prenda> prendasInferiores;
    private HashSet<Prenda> calzados;
    private HashSet<Prenda> accesorios;
    
    private Usuario miDuenio=null;
    
    //Constructores:
    
    public Guardarropa() {
        prendasSuperiores = new HashSet<Prenda>();
        prendasInferiores = new HashSet<Prenda>();
        calzados = new HashSet<Prenda>();
        accesorios = new HashSet<Prenda>();

    }

    public void duenio(Usuario usuario){
    	if (miDuenio == null){miDuenio = usuario;}
    }
    
    public void agregarAGuardarropas(Prenda prenda) throws Exception {
    	if (miDuenio == null) {
    		throw new Exception("Primero debe asignar un usuario a este guardarropa.");
    	}
    	if (miDuenio.tineGuardarropaLleno(this)){
    		throw new Exception("El usuario no puede agregar mas ropa debido a su plan.");
    	}
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
            case ACCESORIOS:
            	this.agregarAccesorio(prenda);
            	break;
            default:
                throw new Exception("Ha ingresado una categoria Invalida.");
        }
    }

    	public int cantidadDePrendas() {
    		int cantidad=0;
    		//Esto lo hacemos para evitar un nullPointer si no hay prendas de alguna categoria.
    		if (prendasSuperiores.isEmpty()) {cantidad=0;} else {cantidad = prendasSuperiores.size();}
    		if (prendasInferiores.isEmpty()) {cantidad+=0;} else {cantidad += prendasInferiores.size();}
    		if (calzados.isEmpty()) {cantidad+=0;} else {cantidad += calzados.size();}
    		if (accesorios.isEmpty()) {cantidad+=0;} else {cantidad += accesorios.size();}
    		
    		return cantidad;
    	}

        public Set<List<Prenda>> sugerir(){
        	
        	 return QueMePongo.obtenerSugerencias(this);
        }

			
        //Estos Metodos se utilizan para agregar a la lista de la categoria correspondiente en el guardarropas
        
    	private void agregarPrendaInferior(Prenda _prenda) {
            this.prendasInferiores.add(_prenda);         
        }

        private void agregarCalzado(Prenda _prenda) {
            this.calzados.add(_prenda);          
        }
        
        private void agregarPrendaSuperior(Prenda prenda) {
            this.prendasSuperiores.add(prenda);          
        }
        
        private void agregarAccesorio(Prenda prenda) {
            this.accesorios.add(prenda);          
        }
        	    
//Getter
		public HashSet<Prenda> getPrendasSuperiores() {
			return this.prendasSuperiores;
		}

		public HashSet<Prenda>  getPrendasInferiores() {
			return this.prendasInferiores;
		}

		public HashSet<Prenda>  getCalzados() {
			return this.calzados;
		}

		public HashSet<Prenda>  getAccesorios() {
			return this.accesorios;
		}
		

		
}
