
package Entrega0;

public class Prenda {

    private Color colorPrincipal;
    private Color colorSecundario;
    private Material material;
    private TipoDePrenda tipo;
    private Trama trama;

   //Constructor: Se puede construir una prenda con o sin color secundario.
    public Prenda(TipoDePrenda tipo, Material material, Color colorPrincipal, Trama trama) {
        this.colorPrincipal = colorPrincipal;
        this.material = material;
        this.tipo = tipo;
        this.trama = trama;
    }

    public Prenda(TipoDePrenda tipo,  Material material, Color colorPrincipal, Color colorSecundario, Trama trama) {
        this.colorPrincipal = colorPrincipal;
        this.material = material;
        this.tipo = tipo;
        this.colorSecundario = colorSecundario;
        this.trama = trama;
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

}