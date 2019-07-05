package API;

public class ClimaAdapterImp implements ClimaAdapter{

	private Get_OpenWeather openWeather = new Get_OpenWeather();
	
	@Override
	public void codigoCiudad(String codigoCiudad) {
		openWeather.codigoCiudad(codigoCiudad);
	}	
	
	@Override
	public double temperaturaActual() {
		double auxiliar = openWeather.obtenerClima().getClimaCiudad().get(0).getList().get(0).getMain().getTemp() - 273.15; 
		return auxiliar;
	}


}
