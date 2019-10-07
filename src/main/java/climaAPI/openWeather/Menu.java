package climaAPI.openWeather;

public class Menu {
	private float temp;
	private float temp_min;
	private float temp_max;
	private float pressure;
	private float sea_level;
	private float grnd_level;
	private int humidity;
	private float temp_kf;
	
	
	public float getTemp() {
		return temp;
	}
	public void setTemp(float temp) {
		this.temp = temp;
	}
	public float getTemp_min() {
		return temp_min;
	}
	public void setTemp_min(float temp_min) {
		this.temp_min = temp_min;
	}
	public float getTemp_max() {
		return temp_max;
	}
	public void setTemp_max(float temp_max) {
		this.temp_max = temp_max;
	}
	public float getPressure() {
		return pressure;
	}
	public void setPressure(float pressure) {
		this.pressure = pressure;
	}
	public float getSea_level() {
		return sea_level;
	}
	public void setSea_level(float sea_level) {
		this.sea_level = sea_level;
	}
	public float getGrnd_level() {
		return grnd_level;
	}
	public void setGrnd_level(float grnd_level) {
		this.grnd_level = grnd_level;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public float getTemp_kf() {
		return temp_kf;
	}
	public void setTemp_kf(float temp_kf) {
		this.temp_kf = temp_kf;
	}
}
