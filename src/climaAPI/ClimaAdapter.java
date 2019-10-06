package climaAPI;

import excepciones.NoConexionApiException;

public interface ClimaAdapter {
	double pasajeDeKelvin =273.15;
	public double obtenerClima(String unCodigoCiudad) throws NoConexionApiException; 
}

