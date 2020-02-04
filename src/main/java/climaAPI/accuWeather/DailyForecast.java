package climaAPI.accuWeather;

public class DailyForecast {

	private String Date;
	//Epochdate -- variable que la vi al pepe
	private Temperature Temperature;
	private MomentoDelDia Day;
	private MomentoDelDia Night;
	// sources -- variable que la vi al pepe
	private String MobileLink;
	private String Link;
	
	
	public DailyForecast(){}


	public String getDate() {
		return Date;
	}


	public void setDate(String date) {
		Date = date;
	}


	public Temperature getTemperature() {
		return Temperature;
	}


	public void setTemperature(Temperature temperature) {
		Temperature = temperature;
	}


	public MomentoDelDia getDay() {
		return Day;
	}


	public void setDay(MomentoDelDia day) {
		Day = day;
	}


	public MomentoDelDia getNight() {
		return Night;
	}


	public void setNight(MomentoDelDia night) {
		Night = night;
	}


	public String getMobileLink() {
		return MobileLink;
	}


	public void setMobileLink(String mobileLink) {
		MobileLink = mobileLink;
	}


	public String getLink() {
		return Link;
	}


	public void setLink(String link) {
		Link = link;
	}
}
