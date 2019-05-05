package prendas; //Ver si se cambia

import static java.util.Objects.requireNonNull;
import java.util.Objects;
import prendas.Trama;
import prendas.TipoDePrenda;


public class BorradorDePrenda {
	private TipoDePrenda tipo;
	private Material material;
	private Trama trama = Trama.LISA;
	private Color colorPrincipal, colorSecundario;
	//Aqui deberiamos de hacer todas las validaciones y permitir una construccion parcial.


	//Constructor de la prenda: Solo necesito saber que tipo de prenda es, y por defecto la trama sera lisa
	public BorradorDePrenda(TipoDePrenda tipo) {
		this.tipo = tipo;
		this.trama = Trama.LISA;
	}
	public Prenda generarPrenda(){
		//Chequear que la prenda esta completa, generar prenda ya sea que exista o no el color secundario.
		//Falta completar el chequeo y el if. 
		return new Prenda (tipo,  material, colorPrincipal, colorSecundario, trama);
	}
		
	
	//Setter  Parciales(Trama, Material, Colores).	
    public void setTrama(Trama trama){ //Permite elegir  la Trama
        this.trama = trama;
    }
	
    public void setMaterial(Material material) {//Permite elegir el material.

        if(tipo.puedeSerDeMaterial(material)){
            this.material = material; 
        }

        else{
            throw new RuntimeException("El material elegido no está permitido.");
        }
    }
    public void setColorPrimario(Color colorPrimario) {
        this.colorPrincipal = colorPrimario;
    }

    public void setColorSecundario(Color colorSecundario) {

        // 2 opciones:
        // asignar al color primario si es nulo
        // tirar excepcion
        if(this.colorPrincipal == null) {
            throw new RuntimeException("Falta color primario");
        }

        this.colorSecundario = colorSecundario;
    }

	//public BorradorDePrenda(TipoDePrenda tipoDePrenda, Material material, Color colorUno, Color colorDos, Trama unaTrama) {
		//Aca tenemos que hacer todas las validaciones.
	
		
		/*ESTO LO BORRE DE PRENDA
		 * Una prenda no puede tener el mismo color principal y secundario:
		if(colorDos!=null) {
			try {
				if(colorUno.esIgualA(colorDos)) {
					throw new IllegalArgumentException("Los colores deben ser distintos");
				}
				else {
					this.tipoDePrenda = Objects.requireNonNull(tipoDePrenda,"falta tipoDePrenda");
				    this.material = Objects.requireNonNull(material,"falta material");
				    this.colorPrimario =  Objects.requireNonNull(colorUno,"falta color primario");
				    this.colorSecundario = colorDos;
				    this.trama = Objects.requireNonNull(unaTrama,"falta definir trama");
				}
			}
			catch(IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		else {
			this.tipoDePrenda = Objects.requireNonNull(tipoDePrenda,"falta tipoDePrenda");
		    this.material = Objects.requireNonNull(material,"falta material");
		    this.colorPrimario =  Objects.requireNonNull(colorUno,"falta color primario");
		    this.colorSecundario = colorDos;
		}
		*/


}
