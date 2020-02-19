package componentes;//Ver si se cambia

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "trama")
@Table(name = "trama")
public class Trama {
	//LISA, ESTAMPADA, RAYADA, LUNARES, CUADROS, 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	private String nombre;

	public Trama() {}	
	
	public String getNombre() {
		return this.nombre;
	}
	
}