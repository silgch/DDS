package QueMePongo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.google.common.collect.Sets;

import Componentes.Prenda;
import guardarropas.Guardarropa;
import usuario.Usuario;

public class QueMePongo {
	
	private List<Usuario> usuarios =new ArrayList<Usuario>();
	private static QueMePongo instance = null;
	private QueMePongo() {
	}
	
	public void agregarUsuario(Usuario unUsuario) {
		this.usuarios.add(unUsuario);
	}
	
	public static QueMePongo getInstance() {
	if(instance == null) {
	instance = new QueMePongo();
	}
	return instance;
	}
	
	
	public void sugerenciaConTodosLosGuardarropas(List<Guardarropa> guardarropas) throws Exception{
    	
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
    
    public void sugerir(Guardarropa unGuardarropa){
    	
    	try {
    	List<Set<Prenda>> sets = new ArrayList<Set<Prenda>>();
		
   		sets.add(new HashSet(unGuardarropa.getPrendasSuperiores()));
   	    sets.add(new HashSet(unGuardarropa.getPrendasInferiores()));
   	    sets.add(new HashSet(unGuardarropa.getCalzados()));
   	 	sets.add(new HashSet(unGuardarropa.getAccesorios()));
   	 	
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
    	catch(Exception e) {
    		System.out.println("El usuario no posee tantos guardarropas");
    	}
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


}
//public class Singleton {
//private static Singleton instance = null;
//private Singleton() {
//}
//public static Singleton getInstance() {
//if(instance == null) {
//instance = new Singleton();
//}
//return instance;
//}
//}