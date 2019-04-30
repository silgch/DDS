package main;

public class Color {
	// EL usuario aportara una una terna RGB
	int rojo, verde, azul;
	
	//Constructor.
	public Color (int ro, int ve, int az) {
		this.rojo=ro;
		this.verde=ve;
		this.azul=az;
	}

	public int getRojo() {
		return rojo;
	}

	public void setRojo(int rojo) {
		this.rojo = rojo;
	}

	public int getVerde() {
		return verde;
	}

	public void setVerde(int verde) {
		this.verde = verde;
	}

	public int getAzul() {
		return azul;
	}

	public void setAzul(int azul) {
		this.azul = azul;
	}
}
