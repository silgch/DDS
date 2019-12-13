package componentes;

import java.util.Set;


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
	
	
	private String nombre;
	
	
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	@ManyToMany
	@JoinTable(name="rel_tipoprenda_material",
			   joinColumns={@JoinColumn(name="TIPO_DE_PRENDA_ID")}, 
			   inverseJoinColumns={@JoinColumn(name= "MATERIAL_ID")})
    private Set<Material> tiposDeMaterialesPermitidos;
	
	
	@Enumerated(EnumType.STRING)
	private PrendaNivel nivel;
 
	
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
			throw new IllegalArgumentException("Material No Permitido");
		}
	}
	
	

	/*
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setNivel(PrendaNivel nivel) {
		this.nivel = nivel;
	}
	
	public void setTiposDeMaterialesPermitidos(Set<Material> tiposDeMaterialesPermitidos) {
		this.tiposDeMaterialesPermitidos = tiposDeMaterialesPermitidos;
	}*/
	
}
	
	/*
    ZAPATOS(Categoria.CALZADO){
    	@Override
        public void puedeSerDeMaterial(Material material){
       		boolean check=false;
    		try {
            check= (material == Material.CUERO || material == Material.CUERINA);
            if(!check) {
            	throw new IllegalArgumentException("Material no admisible para TipoDePrenda");
            }
    		}
    		catch(IllegalArgumentException e) {
    			System.out.println(e);
    		}
    	}
    },

    ZAPATILLAS(Categoria.CALZADO){
    	@Override
        public void puedeSerDeMaterial(Material material){
       		boolean check=false;
    		try {
            check= (material == Material.CUERO || material == Material.CUERINA|| material == Material.LONA);
            if(!check) {
            	throw new IllegalArgumentException("Material no admisible para TipoDePrenda");
            }
    		}
    		catch(IllegalArgumentException e) {
    			System.out.println(e);
    		}
    	}
    },
    BOTAS(Categoria.CALZADO){
    	@Override
        public void puedeSerDeMaterial(Material material){
       		boolean check=false;
    		try {
            check= (material == Material.CUERO || material == Material.CUERINA);
            if(!check) {
            	throw new IllegalArgumentException("Material no admisible para TipoDePrenda");
            }
    		}
    		catch(IllegalArgumentException e) {
    			System.out.println(e);
    		}
    	}
    },

    CAMISA(Categoria.PARTE_SUPERIOR){
    	@Override
        public void puedeSerDeMaterial(Material material){
       		boolean check=false;
    		try {
            check= (material == Material.SEDA || material == Material.ALGODON);
            if(!check) {
            	throw new IllegalArgumentException("Material no admisible para TipoDePrenda");
            }
    		}
    		catch(IllegalArgumentException e) {
    			System.out.println(e);
    		}
    	}
    },

    REMERA(Categoria.PARTE_SUPERIOR){
    	@Override
        public void puedeSerDeMaterial(Material material){
       		boolean check=false;
    		try {
            check= (material == Material.SEDA || material == Material.ALGODON);
            if(!check) {
            	throw new IllegalArgumentException("Material no admisible para TipoDePrenda");
            }
    		}
    		catch(IllegalArgumentException e) {
    			System.out.println(e);
    		}
    	}
    },

    PANTALON(Categoria.PARTE_INFERIOR){
    	@Override
        public void puedeSerDeMaterial(Material material){
       		boolean check=false;
    		try {
            check= (material == Material.CORDEROY || material == Material.CUERO || material == Material.CUERINA|| material == Material.JEAN|| material == Material.LINO);
            if(!check) {
            	throw new IllegalArgumentException("Material no admisible para TipoDePrenda");
            }
    		}
    		catch(IllegalArgumentException e) {
    			System.out.println(e);
    		}
    	}
    },
     LENTES(Categoria.ACCESORIOS){
    	@Override
        public void puedeSerDeMaterial(Material material){
       		boolean check=false;
    		try {
            check= (material == Material.PLASTICO);
            if(!check) {
            	throw new IllegalArgumentException("Material no admisible para TipoDePrenda");
            }
    		}
    		catch(IllegalArgumentException e) {
    			System.out.println(e);
    		}
    	}
    },
    RELOJ(Categoria.ACCESORIOS){
    	@Override
        public void puedeSerDeMaterial(Material material){
    		boolean check=false;
    		try {
            check= (material == Material.ORO || material == Material.PLATA
            || material == Material.PLASTICO);
            if(!check) {
            	throw new IllegalArgumentException("Material no admisible para TipoDePrenda");
            }
    		}
    		catch(IllegalArgumentException e) {
    			System.out.println(e);
    		}
    	}
    };
//----------------------------------------------------------------------------------
    
	private Categoria categoria;
    
	//Constructor: 
    TipoDePrenda(Categoria categoria) {
        this.categoria = categoria;
    }

    public abstract void puedeSerDeMaterial(Material material);

    public Categoria getCategoria() {
        return categoria;
    }

}*/