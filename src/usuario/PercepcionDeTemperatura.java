package usuario;

public class PercepcionDeTemperatura {
	int percepcionCabeza = 0;
	int percepcionTorso = 0;
	int percepcionPiernas = 0;
	
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
