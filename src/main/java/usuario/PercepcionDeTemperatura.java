package usuario;

public class PercepcionDeTemperatura {
	public int percepcionCabeza = 0;
	public int percepcionCuello = 0;
	public int percepcionTorso = 0;
	public int percepcionManos = 0;
	public int percepcionPiernas = 0;
	public int percepcionCalzado = 0;
	
	public void modificarPercepcionCabeza(int modificacion) {percepcionCabeza += modificacion;}
	public void modificarPercepcionCuello(int modificacion) {percepcionCuello += modificacion;}
	public void modificarPercepcionTorso(int modificacion) {percepcionTorso += modificacion;}
	public void modificarPercepcionManos(int modificacion) {percepcionManos += modificacion;}
	public void modificarPercepcionPiernas(int modificacion) {percepcionPiernas += modificacion;}
	public void modificarPercepcionCalzado(int modificacion) {percepcionCalzado += modificacion;}
	
}
