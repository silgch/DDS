package componentes;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "COLOR")
public class Color{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	
	private int rojo;
	private int amarillo;
	private int azul;
	
	
	public Color() {}
	
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
