package main;

import climaAPI.OpenWeather;
import Excepciones.NoConexionApiException;

public class mainPruebasApi {

	public static void main(String[] args) throws NoConexionApiException {


		OpenWeather sarasa = new OpenWeather();
		
		System.out.println(sarasa.obtenerClima("3433955"));
	}

}
