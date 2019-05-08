package Componentes;

public class Color {
	// EL usuario aportara una una terna RGB
	private int rojo, amarillo, azul;
	
	//Constructor.
	public Color (int ro, int am, int az) {
		this.rojo=ro;
		this.amarillo=am;
		this.azul=az;
	}
	//Metodos
	
	public boolean esIgualA(Color otroColor) {
		
   		boolean check=false;
		try {
        check= (this.rojo==otroColor.getRojo()&&
			this.azul==otroColor.getAzul()&&
			this.amarillo==otroColor.getAmarillo());;
        if(check) {
        	throw new IllegalArgumentException("Los colores deben ser distintos");
        }
		}
		catch(IllegalArgumentException e) {
			System.out.println(e);
		}
		return check;
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
