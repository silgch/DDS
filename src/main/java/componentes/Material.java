package componentes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Material {
	/*
	 * ALGODON, JEAN, LINO, GABARDINA, SEDA, CUERO, PLASTICO, CRISTAL, ORO, CUERINA,
	 * PLATA, LONA, LANA, POLIESTER, ACRILICO, CORDEROY, BENGALINA, CAUCHO
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	
	private String nombre;


	public Material(String nombre) {
	
		this.nombre = nombre;
	}
	
	
	public Material() {}
	
}
