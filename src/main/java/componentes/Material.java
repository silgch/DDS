package componentes;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name = "material")
public class Material {
	/*
	 * ALGODON, JEAN, LINO, GABARDINA, SEDA, CUERO, PLASTICO, CRISTAL, ORO, CUERINA,
	 * PLATA, LONA, LANA, POLIESTER, ACRILICO, CORDEROY, BENGALINA, CAUCHO
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;	
	
    @Column(nullable = false, unique = true, length = 20)
	private String nombre;

	@ManyToMany(mappedBy = "tiposDeMaterialesPermitidos")
	private Set<TipoDePrenda> tiposDePrenda = new HashSet<TipoDePrenda>();
	
	public Material(String nombre) {	
		this.nombre = nombre;
	}
	
	public Material() {}
	
	public String getNombre() {
		return this.nombre;
	}
	
}
