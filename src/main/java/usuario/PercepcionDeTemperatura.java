package usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PercepcionDeTemperatura {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = true, nullable = false)
	private Long id;
	
	private int percepcionCabeza = 0;
	private int percepcionCuello = 0;
	private int percepcionTorso = 0;
	private int percepcionManos = 0;
	private int percepcionPiernas = 0;
	private int percepcionCalzado = 0;
	
	public void modificarPercepcionCabeza(int modificacion) {percepcionCabeza = getPercepcionCabeza() + modificacion;}
	public void modificarPercepcionCuello(int modificacion) {percepcionCuello = getPercepcionCuello() + modificacion;}
	public void modificarPercepcionTorso(int modificacion) {percepcionTorso = getPercepcionTorso() + modificacion;}
	public void modificarPercepcionManos(int modificacion) {percepcionManos = getPercepcionManos() + modificacion;}
	public void modificarPercepcionPiernas(int modificacion) {percepcionPiernas = getPercepcionPiernas() + modificacion;}
	public void modificarPercepcionCalzado(int modificacion) {percepcionCalzado = getPercepcionCalzado() + modificacion;}
	
	public int getPercepcionCalzado() {return percepcionCalzado;}
	public int getPercepcionPiernas() {return percepcionPiernas;}
	public int getPercepcionManos() {return percepcionManos;}
	public int getPercepcionCuello() {return percepcionCuello;}
	public int getPercepcionTorso() {return percepcionTorso;}
	public int getPercepcionCabeza() {return percepcionCabeza;}
	
}
