/*
 	Este main sirve para analizar como funciona OpenWeather
*/

package main;

import climaAPI.OpenWeather;
import excepciones.NoConexionApiException;

public class mainPruebasApi {

	public static void main(String[] args) throws NoConexionApiException {
		OpenWeather sarasa = new OpenWeather();
		System.out.println(sarasa.obtenerClima("3433955"));
	}

}
