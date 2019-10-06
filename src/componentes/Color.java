package componentes;

public class Color {
	// EL usuario aportara una una terna RGB
	public int rojo, amarillo, azul;
	
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
