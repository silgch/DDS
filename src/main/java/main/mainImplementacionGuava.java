/*
 	Este main sirve para analizar como funciona Guava
*/

package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;

public class mainImplementacionGuava {
	public static void main(String[] args) {
		
		List<String> s1 = Arrays.asList("a", "b","c");
		List<String> s2 = Arrays.asList("1", "2","3");
		List<String> s3 = Arrays.asList("manzana","pera","banana");
		
		
		List<Set<String>> sets = new ArrayList<Set<String>>();
		
		sets.add(new HashSet<String>(s1));
	    sets.add(new HashSet<String>(s2));
	    sets.add(new HashSet<String>(s3));
	     
	    Set<List<String>> cartesianSet = Sets.cartesianProduct(sets);
	     // para que aparezca la opcion de importar guava
	     // tienen que hacer:
	     //					mvn eclipse:clean
	     //					mvn eclipse:eclispe
	     //SI EL ERROR SIGUE: vuelvan a copiar la linea debajo
	    for(List<String> element : cartesianSet ){
	    	System.out.println(element);
	    }
	}
}
