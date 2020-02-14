package componentes;

import javax.persistence.Table;
import javax.persistence.Transient;

import eventos.Sugerencia;
import guardarropas.Guardarropa;

/*import eventos.Evento;
import eventos.Sugerencia;
import guardarropas.Guardarropa;
import usuario.Usuario;*/

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity(name = "prenda")
@Table(name = "prenda")
public class Prenda{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	private String nombre;	

	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "color_ppal_id", referencedColumnName="id")
    private Color colorPrincipal;
	
	@ManyToOne (cascade=CascadeType.ALL)
	@JoinColumn(name = "color_sec_id", referencedColumnName="id")
    private Color colorSecundario;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "material_id", referencedColumnName="id")
    private Material material;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tipoPrenda_id", referencedColumnName = "id")
    private TipoDePrenda tipo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "trama_id", referencedColumnName = "id")
    private Trama trama;
	
	//@ManyToOne(cascade=CascadeType.ALL,optional = true)
	//@JoinColumn(name = "guardarropa_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Guardarropa guardarropa;
	
	private String urlImagen;
	
	private int calificacion=0;
	
	@ManyToMany(mappedBy = "prendas_de_sugerencia")
	private Set<Sugerencia> sugerencia;
	
	@Transient
	private List<LocalDate> listaDeFechasReservadas;
	
	
	/*
	 * //Para persistir private String jpa_color_ppal; private String jpa_color_sec;
	 * private String jpa_material; private String jpa_trama; private String
	 * jpa_categoria; private String jpa_nivel;
	 */
	
    public Prenda() {}

    //Constructor: Se puede construir una prenda con o sin color secundario.
    
    
    public Prenda(String nombre, TipoDePrenda tipo, Material material, Color colorPrincipal, Trama trama) {
    	Validaciones.validarCreacionPrenda(nombre, tipo, material, colorPrincipal, trama);
    	asignarValoresAPrenda(nombre, tipo, material, colorPrincipal, trama);    	
	}

    public Prenda(String nombre,TipoDePrenda tipo,  Material material, Color colorPrincipal, Color colorSecundario, Trama trama){
    	Validaciones.validarCreacionPrenda(nombre, tipo, material, colorPrincipal, colorSecundario, trama);
		asignarValoresAPrenda(nombre, tipo, material, colorPrincipal,trama);
		this.colorSecundario = colorSecundario;
		//this.jpa_color_sec = colorSecundario.getternaColores();
        
    }
    
    private void asignarValoresAPrenda(String nombre, TipoDePrenda tipo, Material material, Color cPpal, Trama trama) {
       	this.nombre = nombre;
		this.tipo = tipo;
        this.material = material;
        this.colorPrincipal = cPpal;
        this.trama = trama;
        ///
		/*
		 * this.jpa_material = material.name(); this.jpa_color_ppal =
		 * cPpal.getternaColores(); this.jpa_categoria = tipo.getCategoria().name();
		 * this.jpa_nivel = tipo.getNivel().name(); this.jpa_trama = trama.name();
		 */
	}
    
     //Lo unico que podriamos cambiar de una prenda es el nombre .
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//ESTE METODO LO USAMOS PARA QUE NOS DEVUELVA LA POSICION EN MEMORIA CUANDO QUEREMOS IMPRIMIR POR CONSOLA LA LISTA DE PRENDAS
	public String toString() {
		return this.getNombre();
	}

	
	public void setGuardarropa(Guardarropa guardarropa) {
		this.guardarropa = guardarropa; }
	 
	//Getters
	public String getNombre() {
		return nombre;
	}
    public Color getColor() {
        return colorPrincipal;
    }
    public Color getColorSecundario() {
    	return colorSecundario;
    }
    public Material getMaterial() {
        return material;
    }
    public TipoDePrenda getTipo() {
        return tipo;
    }
    public Trama getTrama() {
        return trama;
    }
    public Categoria getCategoria() {
        return tipo.getCategoria();
    }
	public PrendaNivel getNivel() {
		return tipo.getNivel();
	}
	public String getUrlImagen() {
		return urlImagen;
	}
	public int getCalificacion() {
		return calificacion;
	}
	
	/*
	 * public Guardarropa getGuardarropa() { return guardarropa; }
	 */
	
	
	//Semáforos:

	public void reservarPrenda(LocalDate fecha){
		listaDeFechasReservadas.add(fecha);
	}
	public void liberarPrenda(LocalDate fecha){
		listaDeFechasReservadas.remove(fecha);
	}
	public boolean estaReservada(LocalDate fecha) {
		if(listaDeFechasReservadas==null) return false;
			else return(listaDeFechasReservadas.contains(fecha));
		
	}
	

    
    // Ver si vamos a usar los setter. 
	/*
	public void setColorPrincipal(Color colorPrincipal) {
		this.colorPrincipal = colorPrincipal;
	}
	public void setColorSecundario(Color colorSecundario) {
		this.colorSecundario = colorSecundario;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public void setTipo(TipoDePrenda tipo) {
		this.tipo = tipo;
	}
	public void setTrama(Trama trama) {
		this.trama = trama;
	}
	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
	public void setCalificacion(int unaCalificacion) {
		this.calificacion=unaCalificacion;
	}
	
	public void setNivel(PrendaNivel nivel) {
		this.tipo.setNivel(nivel);
	}*/
	
}