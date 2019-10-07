package usuario;

public class PercepcionDeTemperatura {
	public int percepcionCabeza = 0;
	public int percepcionTorso = 0;
	public int percepcionPiernas = 0;
	
	public void modificarPercepcionCabeza(int modificacion) {
		percepcionCabeza += modificacion;
	}
	public void modificarPercepcionTorso(int modificacion) {
		percepcionTorso += modificacion;
	}
	public void modificarPercepcionPiernas(int modificacion) {
		percepcionPiernas += modificacion;
	}

}
