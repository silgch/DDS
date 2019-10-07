package climaAPI;

public class GestorDeClimaAPIs {
	public ClimaAdapter entregarAPI() {
		return new OpenWeather();
	}
	public void cambiarDeAPI(ClimaAdapter unaAPI) {
		if (unaAPI.nombreDeAPI() == "OpenWeather"){
			unaAPI = new AccuWeather();
		} else unaAPI = new OpenWeather();
	}

}
