package guardarropas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import componentes.Prenda;
import usuario.Usuario;

/*	
 	Cada Usuario tiene uno o mas guardarropas.Cuando
	un usuario crea una prenda, se la incluye en su guardarropas, 
  	mediante el metodo agregarAGuardarropas.
*/

@Entity
@Table(name = "guardarropa")
public class Guardarropa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	public Guardarropa(){}

	@Transient
	public static int maximoDePrendas = 10;
	
	@Transient
	@OneToMany  
	@JoinColumn(name = "prendas_id", referencedColumnName = "id") 	
	private List<Prenda> prendas = new ArrayList<Prenda>();
	
	private String Nombre;	
	
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name="usuario_id")
	private Usuario miDuenio= null;
	
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name="usuarioParasito")
	private Usuario usuarioParasito = null;    
	
    //Constructores:
    public void duenio(Usuario usuario){
    	if (miDuenio == null){miDuenio = usuario;}
    }
    
    public void agregarAGuardarropas(Prenda prenda) {
    	/*if (miDuenio == null) {
			System.out.println("mi dueño:"+miDuenio);
    		throw new Exception("Primero debe asignar un usuario a este guardarropa.");
    	}
    	if (miDuenio.tieneGuardarropaLleno(this.cantidadDePrendas())){
    		System.out.println("cantidadDePrendas:"+this.cantidadDePrendas());
    		throw new Exception("El usuario no puede agregar mas ropa debido a su plan.");
    	}*/
    	prendas.add(prenda);
    	prenda.setGuardarropa(this);
     }
    
    public int cantidadDePrendas() {
		int cantidad=0;
		//Esto lo hacemos para evitar un nullPointer si no hay prendas de alguna categoria.
		if (prendas.isEmpty());
			else {cantidad += prendas.size();}

		return cantidad;
	}
    
	public List<Prenda> getPrendas() {
		return prendas;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	public boolean tieneElGuardarropasLLeno() {
		return miDuenio.esPobre() && cantidadDePrendas()>=maximoDePrendas;
	}
    
}
