package componentes;

import java.util.Arrays;

public class Color{
	private int rojo, amarillo, azul;
	
	
	//Constructor.
	public Color (int ro, int am, int az) {
		this.rojo=ro;
		this.amarillo=am;
		this.azul=az;
	}
	
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
