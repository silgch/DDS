package componentes;

public class Prenda {

	private String nombre;
    private Color colorPrincipal;
    private Color colorSecundario;
    private Material material;
    private TipoDePrenda tipo;
    private Trama trama;
	private String urlImagen;
	private int calificacion=0;
    
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
	    
    }
    
    private void asignarValoresAPrenda(String nombre, TipoDePrenda tipo, Material material, Color colorPrincipal, Trama trama) {
       	this.nombre=nombre;
		this.tipo = tipo;
        this.material = material;
        this.colorPrincipal = colorPrincipal;
        this.trama = trama;
	}
    
/*    
    public boolean esDeInvierno() {
    	return true;
    }
    
    public boolean esDeVerano() {
    	return true;
    }
*/    


//Lo unico que podriamos cambiar de una prenda es el nombre .
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

//ESTE METODO LO USAMOS PARA QUE NOS DEVUELVA LA POSICION EN MEMORIA CUANDO QUEREMOS IMPRIMIR POR CONSOLA LA LISTA DE PRENDAS
	public String toString() {
		return this.getNombre();
	}
	
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

    
    // Ver si vamos a usar los setter. 
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
	public void setNivel(PrendaNivel nivel) {
		this.tipo.setNivel(nivel);
	}
	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
	public void setCalificacion(int unaCalificacion) {
		this.calificacion=unaCalificacion;
	}

}