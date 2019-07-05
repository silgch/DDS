package queMePongo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
//import java.util.Iterator;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

import com.google.common.collect.Sets;

import API.ClimaAdapterImp;
import componentes.Prenda;
import guardarropas.Guardarropa;


public class QueMePongo {
	
	private ClimaAdapterImp adapterClima = new ClimaAdapterImp();
	private static QueMePongo instance = null;
	private QueMePongo() {}

	public static QueMePongo getInstance() {
		if(instance == null) 
			{instance = new QueMePongo();}
		return instance;
	}
/*
  A sugerir se le da un guardarropa, el mismo tendrá varios niveles
  de prendas (ej:remera=prendaSuperior nivel1, camperaPolar=prendaSuperior nivel4).
  Si hace mas de 25º sugerir dará alguna prenda superior nivel1, si existiera.
  Si hace mas de 20º segerir dará una prendaSuperior nivel1 y una de nivel2 y así...
 */
    public void sugerir(Guardarropa unGuardarropa){
    	Double temp = adapterClima.temperaturaActual();
    	try {
	    	List<Set<Prenda>> sets = new ArrayList<Set<Prenda>>();
	    	
			if(!unGuardarropa.getPrendasSuperioresNivel1().isEmpty() && temp<25) {
				sets.add(new HashSet(unGuardarropa.getPrendasSuperioresNivel1()));
			}
			if(!unGuardarropa.getPrendasSuperioresNivel2().isEmpty() && temp<=20) {
				sets.add(new HashSet(unGuardarropa.getPrendasSuperioresNivel2()));
			}
			if(!unGuardarropa.getPrendasSuperioresNivel3().isEmpty() && temp<=15) {
				sets.add(new HashSet(unGuardarropa.getPrendasSuperioresNivel3()));
			}
			if(!unGuardarropa.getPrendasSuperioresNivel4().isEmpty() && temp<=10) {
				sets.add(new HashSet(unGuardarropa.getPrendasSuperioresNivel4()));
			}
			if(!unGuardarropa.getPrendasInferioresNivel1().isEmpty()) {
				sets.add(new HashSet(unGuardarropa.getPrendasInferioresNivel1()));
			}
			if(!unGuardarropa.getPrendasInferioresNivel2().isEmpty()) {
				sets.add(new HashSet(unGuardarropa.getPrendasInferioresNivel2()));
			}
			if(!unGuardarropa.getPrendasInferioresNivel3().isEmpty()) {
				sets.add(new HashSet(unGuardarropa.getPrendasInferioresNivel3()));
			}
			if(!unGuardarropa.getCalzadosNivel1().isEmpty()) {
				sets.add(new HashSet(unGuardarropa.getCalzadosNivel1()));
			}
			if(!unGuardarropa.getCalzadosNivel2().isEmpty()) {
				sets.add(new HashSet(unGuardarropa.getCalzadosNivel2()));
			}
			if(!unGuardarropa.getAccesorios().isEmpty()) {
				sets.add(new HashSet(unGuardarropa.getAccesorios()));
			}
	   	 	
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
			
			//this.creacionAtuendo(listaAux.toString(), unGuardarropa.getTodoJunto());
    
    	} 
    	catch(Exception e) {
    		System.out.println(e);
    		//System.out.println("El usuario no posee tantos guardarropas");
    	}
}
    
  public void sugerirTodasLasCombinaciones(Guardarropa unGuardarropa){
  		Double temp = adapterClima.temperaturaActual();
    	try {
    	List<Set<Prenda>> sets = new ArrayList<Set<Prenda>>();
		if(!unGuardarropa.getPrendasSuperioresNivel1().isEmpty() && temp<25) {
			sets.add(new HashSet(unGuardarropa.getPrendasSuperioresNivel1()));
		}
		if(!unGuardarropa.getPrendasSuperioresNivel2().isEmpty() && temp<=20) {
			sets.add(new HashSet(unGuardarropa.getPrendasSuperioresNivel2()));
		}
		if(!unGuardarropa.getPrendasSuperioresNivel3().isEmpty() && temp<=15) {
			sets.add(new HashSet(unGuardarropa.getPrendasSuperioresNivel3()));
		}
		if(!unGuardarropa.getPrendasSuperioresNivel4().isEmpty() && temp<=10) {
			sets.add(new HashSet(unGuardarropa.getPrendasSuperioresNivel4()));
		}
		if(!unGuardarropa.getPrendasInferioresNivel1().isEmpty()) {
			sets.add(new HashSet(unGuardarropa.getPrendasInferioresNivel1()));
		}
		if(!unGuardarropa.getPrendasInferioresNivel2().isEmpty()) {
			sets.add(new HashSet(unGuardarropa.getPrendasInferioresNivel2()));
		}
		if(!unGuardarropa.getPrendasInferioresNivel3().isEmpty()) {
			sets.add(new HashSet(unGuardarropa.getPrendasInferioresNivel3()));
		}
		if(!unGuardarropa.getCalzadosNivel1().isEmpty()) {
			sets.add(new HashSet(unGuardarropa.getCalzadosNivel1()));
		}
		if(!unGuardarropa.getCalzadosNivel2().isEmpty()) {
			sets.add(new HashSet(unGuardarropa.getCalzadosNivel2()));
		}
		if(!unGuardarropa.getAccesorios().isEmpty()) {
			sets.add(new HashSet(unGuardarropa.getAccesorios()));
		}
   	 	
   	 	Set<List<Prenda>> cartesianSet = Sets.cartesianProduct(sets);
   	 	
   	 	List<String> listaAux= new ArrayList<String>();
   	 	
		for(List<Prenda> element : cartesianSet ){
			System.out.println(element);
		}
		
		
		//this.creacionAtuendo(listaAux.toString(), unGuardarropa.getTodoJunto());
    
    	} 
    	catch(Exception e) {
    		System.out.println(e);
    		//System.out.println("El usuario no posee tantos guardarropas");
    	}
}
  
public void sugerirUnaCantidadDeVeces(Guardarropa unGuardarropa,int unaCantidad){
  	Double temp = adapterClima.temperaturaActual();
  	try {
  		List<Set<Prenda>> sets = new ArrayList<Set<Prenda>>();
		if(!unGuardarropa.getPrendasSuperioresNivel1().isEmpty() && temp<25) {
			sets.add(new HashSet(unGuardarropa.getPrendasSuperioresNivel1()));
		}
		if(!unGuardarropa.getPrendasSuperioresNivel2().isEmpty() && temp<=20) {
			sets.add(new HashSet(unGuardarropa.getPrendasSuperioresNivel2()));
		}
		if(!unGuardarropa.getPrendasSuperioresNivel3().isEmpty() && temp<=15) {
			sets.add(new HashSet(unGuardarropa.getPrendasSuperioresNivel3()));
		}
		if(!unGuardarropa.getPrendasSuperioresNivel4().isEmpty() && temp<=10) {
			sets.add(new HashSet(unGuardarropa.getPrendasSuperioresNivel4()));
		}
		if(!unGuardarropa.getPrendasInferioresNivel1().isEmpty()) {
			sets.add(new HashSet(unGuardarropa.getPrendasInferioresNivel1()));
		}
		if(!unGuardarropa.getPrendasInferioresNivel2().isEmpty()) {
			sets.add(new HashSet(unGuardarropa.getPrendasInferioresNivel2()));
		}
		if(!unGuardarropa.getPrendasInferioresNivel3().isEmpty()) {
			sets.add(new HashSet(unGuardarropa.getPrendasInferioresNivel3()));
		}
		if(!unGuardarropa.getCalzadosNivel1().isEmpty()) {
			sets.add(new HashSet(unGuardarropa.getCalzadosNivel1()));
		}
		if(!unGuardarropa.getCalzadosNivel2().isEmpty()) {
			sets.add(new HashSet(unGuardarropa.getCalzadosNivel2()));
		}
		if(!unGuardarropa.getAccesorios().isEmpty()) {
			sets.add(new HashSet(unGuardarropa.getAccesorios()));
		}
 	 	
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
		for(int i =0;i<unaCantidad;i++) {
			System.out.println(this.getRandomList(listaAux));
		}
		//this.creacionAtuendo(listaAux.toString(), unGuardarropa.getTodoJunto());
  
  	} 
  	catch(Exception e) {
  		System.out.println(e);
  		//System.out.println("El usuario no posee tantos guardarropas");
  	}
}
	public String getRandomList(List<String> list) {
	    Random random = new Random();
	    int index = random.nextInt(list.size());
	    System.out.println("\nIndex :" + index );
	    return list.get(index);
	}
	
	
	
	/*
	  						 Implentación Vieja
	 
	
	public static Set<List<Prenda>> obtenerSugerencias(Guardarropa unGuardarropa){
		
		List<Set<Prenda>> sets = new ArrayList<Set<Prenda>>();
		
		sets.add(new HashSet(unGuardarropa.getPrendasSuperiores()));
   	    sets.add(new HashSet(unGuardarropa.getPrendasInferiores()));
   	    sets.add(new HashSet(unGuardarropa.getCalzados()));
   	 	sets.add(new HashSet(unGuardarropa.getAccesorios()));
		
		return  Sets.cartesianProduct(sets);
	}
	
	private boolean comprobarListaNoVacia(List<Prenda> unaLista) { //Ver si sirve incluirlo en ObtenerSugerencias() pare evitar el null pointer
		if(unaLista == null || unaLista.size() == 0)
			{return false;}
		else
			{return true;}		
	      
	}
	 */
}	
