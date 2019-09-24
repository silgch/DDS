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
	
	public boolean esIgualA(Color otroColor) {
		
   		boolean check=false;
		try {
        check= (rojo==otroColor.getRojo()&&
        		azul==otroColor.getAzul()&&
        		amarillo==otroColor.getAmarillo());;
        if(check) {
        	throw new IllegalArgumentException("Los colores deben ser distintos");
        }
		}
		catch(IllegalArgumentException e) {
			System.out.println(e);
		}
		return check;
	}

	
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
