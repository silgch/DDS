package climaAPI.accuWeather;

import java.util.ArrayList;
import java.util.List;

public class ClimaCiudad { //mismo nombres en las apis que traen datos metereologicos
	
	private Headline Headline;
	private List<DailyForecast> DailyForecasts = new ArrayList<DailyForecast>();
	
	public Headline getHeadline() {
		return Headline;
	}
	public void setHeadline(Headline headline) {
		Headline = headline;
	}
	public List<DailyForecast> getDailyForecasts() {
		return DailyForecasts;
	}
	public void setDailyForecasts(List<DailyForecast> dailyForecasts) {
		DailyForecasts = dailyForecasts;
	}


}
