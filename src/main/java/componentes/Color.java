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
	
	public Color (String nombre, int ro, int ve, int az) {
		this.nombre=nombre;
		this.rojo=ro;
		this.verde=ve;
		this.azul=az;
	}
	
	//Metodos
	
	//Getters
	public int getRojo() {
		return rojo;
	}
	public int getVerde() {
		return verde;
	}
	public int getAzul() {
		return azul;
	}
	
	public String getternaColores() {
		int[] colores = {rojo,verde,azul};
		return  Arrays.toString(colores);
	}
	
	/* Setters
	public void setRojo(int rojo) {
		this.rojo = rojo;
	}
	public void setAmarillo(int amarillo) {
		this.amarillo = amarillo;
	}
	public void setAzul(int azul) {
		this.azul = azul;
	}*/
}
