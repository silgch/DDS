package climaAPI;

public class GestorDeClimaAPIs {
	public ClimaAdapter entregarAPI() {
		return new OpenWeather();
	}
	public void cambiarDeAPI(ClimaAdapter unaAPI) {
		if (unaAPI.nombreDeAPI() == "OpenWeather"){
			unaAPI = new AccuWeather();
		}
		else if (unaAPI.nombreDeAPI() == "AccuWeather"){
			unaAPI = new OpenWeather();
		}
		else System.out.println("Todas las APIs están teniendo problemas, intente de nuevo mas tarde");
	}

}
