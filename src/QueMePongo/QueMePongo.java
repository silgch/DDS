package QueMePongo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.collect.Sets;

import Componentes.Atuendo;
import Componentes.Prenda;
import guardarropas.Guardarropa;
import usuario.Usuario;

public class QueMePongo {
	
	private static QueMePongo instance = null;
	private QueMePongo() {
	}

	
	public static QueMePongo getInstance() {
		if(instance == null) {
		instance = new QueMePongo();
		}
		return instance;
	}
	
	
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
		{
		  return false;
		}
		else{
		 return true;
		}      
}
	
}	
