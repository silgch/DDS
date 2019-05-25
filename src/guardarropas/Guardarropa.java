package guardarropas;

import static java.util.Objects.requireNonNull;

import java.util.stream.Collectors;

import com.google.common.collect.Sets;

import java.util.*;
import Componentes.Prenda;
import Componentes.Categoria;



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
       
    	public void agregarPrendaInferior(Prenda _prenda) {
            this.prendasInferiores.add(_prenda);         
        }

        public void agregarCalzado(Prenda _prenda) {
            this.calzados.add(_prenda);          
        }
        
        public void agregarPrendaSuperior(Prenda prenda) {
            this.prendasSuperiores.add(prenda);          
        }
        
        public void agregarAccesorio(Prenda prenda) {
            this.accesorios.add(prenda);          
        }
        
        public void sugerir(){
        	//2)Generar sugerencias de atuendos v�lidas, implementando un algoritmo que genere
        	//todas las combinaciones posibles de ropa. 
        	
        	List<Set<Prenda>> sets = new ArrayList<Set<Prenda>>();
    		
	   		sets.add(new HashSet(prendasSuperiores));
	   	    sets.add(new HashSet(prendasInferiores));
	   	    sets.add(new HashSet(calzados));
	   	 	sets.add(new HashSet(accesorios));
	   	 	
	   	 	Set<List<Prenda>> cartesianSet = Sets.cartesianProduct(sets);
	   	 	
	   	 	List<String> listaAux= new ArrayList<String>();
	   	 	
			for(List<Prenda> element : cartesianSet ){
				    	 
				listaAux.add(element.toString());
			}
			
			System.out.println(this.getRandomList(listaAux));
    	 
	     
   	    
	    }
        
//        public List<Prenda> sugerirAtuendo(){
//        	//2)Generar sugerencias de atuendos v�lidas, implementando un algoritmo que genere
//        	//todas las combinaciones posibles de ropa. 
//        	
//        	//LEAN Y ANGEL VEAN "mainImplementacionGuava" (dentro del package main)
//        	Random aleatorio= new Random();
//        	List <List<Prenda>> atuendosValidos = this.atuendosValidos();
//        	return this.atuendosValidos().get(aleatorio);
//        }
//
//        
//        private List <List<Prenda>> atuendosValidos(){
//        	
//        	return Lists.cartesianProduct(this.prendasSuperiores, this.prendasInferiores, 
//        									this.calzados, this.accesorios);
//     	
//        }  

		public List<Prenda> getPrendasSuperiores() {
			return prendasSuperiores;
		}

		public List<Prenda> getPrendasInferiores() {
			return prendasInferiores;
		}

		public List<Prenda> getCalzados() {
			return calzados;
		}

		public List<Prenda> getAccesorios() {
			return accesorios;
		}
		
		public String getRandomList(List<String> list) {
		    Random random = new Random();
		    int index = random.nextInt(list.size());
		    System.out.println("\nIndex :" + index );
		    return list.get(index);
		}


}