package guardarropas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import QueMePongo.QueMePongo;

import com.google.common.collect.Sets;

import Componentes.Prenda;



//Cada Usuario tiene uno o mas guardarropas.
//Cuando un usuario crea una prenda, se la incluye en su guardarropas, mediante el metodo agregarAGuardarropas.
public class Guardarropa {
    private List<Prenda> prendasSuperiores;
    private List<Prenda> prendasInferiores;
    private List<Prenda> calzados;
    private List<Prenda> accesorios;
    
    //Constructores:
    
    public Guardarropa() {
        this.prendasSuperiores = new ArrayList<Prenda>();
        this.prendasInferiores = new ArrayList<Prenda>();
        this.calzados = new ArrayList<Prenda>();
        this.accesorios = new ArrayList<Prenda>();

    }

    public void agregarAGuardarropas(Prenda prenda) throws Exception {
    	
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
        

        public Set<List<Prenda>> sugerir(){
        	
        	 return QueMePongo.obtenerSugerencias(this);
        }
			
			
	    

		public List<Prenda> getPrendasSuperiores() {
			return this.prendasSuperiores;
		}

		public List<Prenda> getPrendasInferiores() {
			return this.prendasInferiores;
		}

		public List<Prenda> getCalzados() {
			return this.calzados;
		}

		public List<Prenda> getAccesorios() {
			return this.accesorios;
		}
		
		public String getRandomList(List<String> list) {
		    Random random = new Random();
		    int index = random.nextInt(list.size());
		    System.out.println("\nIndex :" + index );
		    return list.get(index);
		}

		
}
