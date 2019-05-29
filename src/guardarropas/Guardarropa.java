package guardarropas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.google.common.collect.Sets;

import Componentes.Prenda;



//Cada Usuario tiene uno o mas guardarropas.
//Cuando un usuario crea una prenda, se la incluye en su guardarropas, mediante el metodo agregarAGuardarropas.
public class Guardarropa {
    private List<Prenda> prendasSuperiores;
    private List<Prenda> prendasInferiores;
    private List<Prenda> calzados;
    private List<Prenda> accesorios;
    private List<Prenda> todoJunto;
    
    //Constructores:
    
    public Guardarropa() {
        this.prendasSuperiores = new ArrayList<Prenda>();
        this.prendasInferiores = new ArrayList<Prenda>();
        this.calzados = new ArrayList<Prenda>();
        this.accesorios = new ArrayList<Prenda>();
        this.todoJunto = new ArrayList<Prenda>();

    }

    public void agregarAGuardarropas(Prenda prenda) throws Exception {
    	this.todoJunto.add(prenda);
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
        
        public void sugerenciaConTodosLosGuardarropas(List<Guardarropa> guardarropas) throws Exception{
        	//DEPRECADO: usar el metodo del mismo nombre en clase QueMePongo//
        	Guardarropa aux = new Guardarropa();
        	for(Guardarropa element : guardarropas) {
        		this.fusionarGuardarropa(aux,element);
        	}
        	
        	List<Set<Prenda>> sets = new ArrayList<Set<Prenda>>();
    		
	   		sets.add(new HashSet(aux.getPrendasSuperiores()));
	   	    sets.add(new HashSet(aux.getPrendasInferiores()));
	   	    sets.add(new HashSet(aux.getCalzados()));
	   	 	sets.add(new HashSet(aux.getAccesorios()));
	   	 	
	   	 	Set<List<Prenda>> cartesianSet = Sets.cartesianProduct(sets);
	   	 	
	   	 	List<String> listaAux= new ArrayList<String>();
	   	 	
			for(List<Prenda> element : cartesianSet ){

				String nombreAux ="";
				List<Prenda> listaPrendaAux = element;
				for(Prenda prenda :listaPrendaAux ){
			    	 
					nombreAux=nombreAux+"-"+prenda.getNombre();
					
				}
				
				listaAux.add(nombreAux);
			}
			
			System.out.println(this.getRandomList(listaAux));
    	        	
        }
        
        public void sugerir(){//DEPRECADO: usar el metodo del mismo nombre en clase QueMePongo//
        	
        	List<Set<Prenda>> sets = new ArrayList<Set<Prenda>>();
    		
	   		sets.add(new HashSet(this.prendasSuperiores));
	   	    sets.add(new HashSet(this.prendasInferiores));
	   	    sets.add(new HashSet(this.calzados));
	   	 	sets.add(new HashSet(this.accesorios));
	   	 	
	   	 	Set<List<Prenda>> cartesianSet = Sets.cartesianProduct(sets);
	   	 	
	   	 	List<String> listaAux= new ArrayList<String>();
	   	 	
			for(List<Prenda> element : cartesianSet ){
				
				String nombreAux ="";
				List<Prenda> listaPrendaAux = element;
				for(Prenda prenda :listaPrendaAux ){
			    	 
					nombreAux=nombreAux+"-"+prenda.getNombre();
					
				}
				
				listaAux.add(nombreAux);
			}
			
			System.out.println(this.getRandomList(listaAux));
	    } 

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
		
		public void fusionarGuardarropa(Guardarropa a,Guardarropa b) throws Exception {
			
			for(Prenda p : b.getPrendasSuperiores()) {
				
				a.agregarPrendaSuperior(p);
			}
			
			for(Prenda p : b.getPrendasInferiores()) {
				
				a.agregarPrendaInferior(p);;
			}
			
			for(Prenda p : b.getCalzados()) {
				
				a.agregarCalzado(p);
			}
			
			for(Prenda p : b.getAccesorios()) {
				
				a.agregarAccesorio(p);
			}
			
		}

		public List<Prenda> getTodoJunto() {
			return todoJunto;
		}
		

}