package main;

import API.ClimaAdapterImp;

public class mainPruebasApi {

	public static void main(String[] args) {
//		Get_OpenWeather prueba = new Get_OpenWeather();
//		prueba.obtenerClima();

		ClimaAdapterImp sarasa = new ClimaAdapterImp();
		
		sarasa.codigoCiudad("2643743");//Londres
		System.out.println(sarasa.temperaturaActual());
	}

}
