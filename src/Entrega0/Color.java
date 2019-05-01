package Entrega0;

public class Color {
	// EL usuario aportara una una terna RGB
	int rojo, amarillo, azul;
	
	//Constructor.
	public Color (int ro, int am, int az) {
		this.rojo=ro;
		this.amarillo=am;
		this.azul=az;
	}
	//Metodos
	
	public boolean esIgualA(Color otroColor) {
		
		return (this.rojo==otroColor.rojo&&
				this.azul==otroColor.azul&&
				this.amarillo==otroColor.amarillo);
	}
	
	//Getters & Setters
	public int getRojo() {
		return rojo;
	}

	public void setRojo(int rojo) {
		this.rojo = rojo;
	}

	public int getAmarillo() {
		return amarillo;
	}

	public void setAmarillo(int amarillo) {
		this.amarillo = amarillo;
	}

	public int getAzul() {
		return azul;
	}

	public void setAzul(int azul) {
		this.azul = azul;
	}
}
