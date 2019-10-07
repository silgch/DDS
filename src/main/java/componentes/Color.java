package componentes;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity 
public class Color extends Entidad{
	private static final long serialVersionUID = 1L;
	// EL usuario aportara una una terna RGB
	private int rojo, amarillo, azul;
	
	
	//Constructor.
	public Color (int ro, int am, int az) {
		this.rojo=ro;
		this.amarillo=am;
		this.azul=az;
	}
	public Color() {}
	
	//Metodos
	
	//Getters
	public int getRojo() {
		return rojo;
	}
	public int getAmarillo() {
		return amarillo;
	}
	public int getAzul() {
		return azul;
	}
	
	@Column(name = "ternaColores")
	public String getternaColores() {
		int[] colores = {rojo,amarillo,azul};
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
