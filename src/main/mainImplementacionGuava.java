package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;

public class mainImplementacionGuava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		List<String> s1 = Arrays.asList("abc", "def","ghi");
		List<String> s2 = Arrays.asList("001", "002","003");
		List<String> s3 = Arrays.asList("991","992","993");
		
		
		List<Set<String>> sets = new ArrayList<Set<String>>();
		
		 sets.add(new HashSet(s1));
	     sets.add(new HashSet(s2));
	     sets.add(new HashSet(s3));
	     
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
