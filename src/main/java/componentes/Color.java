package componentes;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "color")
public class Color{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@SuppressWarnings("unused")
	private String nombre;
	private int rojo;
	private int verde;
	private int azul;	
	
	public Color() {}
	
	public Color (int ro, int ve, int az) {
		this.rojo=ro;
		this.verde=ve;
		this.azul=az;
	}
	
	//Metodos
	
	//Getters
	public int getR() {
		return rojo;
	}
	public int getV() {
		return verde;
	}
	public int getA() {
		return azul;
	}
	
	public String getternaColores() {
		int[] colores = {rojo,verde,azul};
		return  Arrays.toString(colores);
	}	
	
}
