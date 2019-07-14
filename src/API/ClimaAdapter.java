package API;

import Excepciones.NoConexionApiException;

public interface ClimaAdapter {
	double pasajeDeKelvin =273.15;
	public double obtenerClima(String unCodigoCiudad) throws NoConexionApiException; 
}

