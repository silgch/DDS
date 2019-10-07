package climaAPI;

import excepciones.NoConexionApiException;

public interface ClimaAdapter {
	double pasajeDeKelvin =273.15;
	boolean hayProblemasDeConexion = false;
	
	public String nombreDeAPI();
	public double obtenerClima(String unCodigoCiudad) throws NoConexionApiException; 
	
}

