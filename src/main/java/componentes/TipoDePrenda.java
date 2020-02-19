package componentes;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/* 
	 El programa vendrá con algunos TiposDePrenda ya hechos (Zapatos,Zapatillas,Botas,Camisa
	 Campera,Pantalon, Lentes, Reloj)
	 en todos se especificara Categoria y nivel y verifica si está bien el tipo 
	 de material elegido por el usuario.
	 Sin embarlo le dejaremos al usuario la posibilidad de 
	 hacer su propio tipo de material, eligiendo él el nivel y material. 
	 Entonces el usuario podría crear un TipoDePrenda calzoncillos nivel 2 de latex y usuarlo
	 arriba de la ropa 🤦‍♂️ ...somos concientes de eso. 
*/

@Entity
@Table(name = "tipo_de_prenda")
public class TipoDePrenda{	
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;	
	
    @Column(nullable = false, unique = true, length = 20)
	private String nombre;	
	
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	@ManyToMany
	@JoinTable(name="tiposDePrendas_materiales",
			   joinColumns={@JoinColumn(name="tipo_de_prenda_id")}, 
			   inverseJoinColumns={@JoinColumn(name= "material_id")})
    private Set<Material> tiposDeMaterialesPermitidos;
	
	
	@Enumerated(EnumType.STRING)
	private PrendaNivel nivel;
	
	private String imagen; 
	
	public TipoDePrenda() {}
	
	public TipoDePrenda(String nombre, Categoria categoria, Set<Material> tiposDeMaterialesPermitidos, PrendaNivel nivel) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.tiposDeMaterialesPermitidos = tiposDeMaterialesPermitidos;
		this.nivel = nivel;		
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public PrendaNivel getNivel() {
		return nivel;
	}
	
	public String getImagen() {
		return imagen;
	}
	
	public Set<Material> getTiposDeMaterialesPermitidos() {
		return tiposDeMaterialesPermitidos;
	}
	
	public void agregarMaterialPermitido(Material unMaterial) {
		/* Agrega un material a los ya existentes*/
		tiposDeMaterialesPermitidos.add(unMaterial);
		
	}
	
	public void puedeSerDeMaterial(Material unMaterial) {
		//Si el material no se encuentra tiposDeMaterialesPermitidos tira excepción
		if(tiposDeMaterialesPermitidos==null); //No se seleccionaron los tiposDeMaterialesPermitidos
		else if (!tiposDeMaterialesPermitidos.contains(unMaterial)) { //&& ) {
			//throw new IllegalArgumentException("Material No Permitido");
            System.out.println("Material no Permitido");

		}
	}
}
