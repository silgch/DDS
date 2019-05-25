
package Componentes;

import java.util.Objects;

public class Prenda {

    private Color colorPrincipal;
    private Color colorSecundario;
    private Material material;
    private TipoDePrenda tipo;
    private Trama trama;
    
    public Prenda() {}

   //Constructor: Se puede construir una prenda con o sin color secundario.
    public Prenda(TipoDePrenda tipo, Material material, Color colorPrincipal, Trama trama) {
    	

    		if(Validaciones.realizarValidacionesCuatroParametros(tipo, material, colorPrincipal, trama)) {
		    	this.tipo = tipo;
		        this.material = material;
		        this.colorPrincipal = colorPrincipal;
		        this.trama = trama;
    		}

    }

    public Prenda(TipoDePrenda tipo,  Material material, Color colorPrincipal, Color colorSecundario, Trama trama) {
        
	    	if(Validaciones.realizarValidacionesCincoParametros(tipo, material, colorPrincipal, colorSecundario, trama)) {
	    		this.tipo = tipo;
	    		this.material = material;
		    	this.colorPrincipal = colorPrincipal;
		        this.colorSecundario = colorSecundario;
		        this.trama = trama;
	    	}
    }
    
//Metodos
    
    public boolean esDeInvierno() {
    	return true;
    }
    
    public boolean esDeVerano() {
    	return true;
    }
    


//Getter
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

}