package ow.entidades;

import java.util.ArrayList;
import java.util.List;

public class Datos {
	private long dt;
	private Menu main;
	private List<Clima> weather = new ArrayList<Clima>();
	private Nubes clouds;
	private Viento wind;
	//snow no lo cacheo por las dudas
	private Sys sys;
	private String dt_txt;
	
	public long getDt() {
		return dt;
	}
	public void setDt(long dt) {
		this.dt = dt;
	}
	public Menu getMain() {
		return main;
	}
	public void setMain(Menu main) {
		this.main = main;
	}
	public List<Clima> getWeather() {
		return weather;
	}
	public void setWeather(List<Clima> weather) {
		this.weather = weather;
	}
	public Nubes getClouds() {
		return clouds;
	}
	public void setClouds(Nubes clouds) {
		this.clouds = clouds;
	}
	public Viento getWind() {
		return wind;
	}
	public void setWind(Viento wind) {
		this.wind = wind;
	}
	public Sys getSys() {
		return sys;
	}
	public void setSys(Sys sys) {
		this.sys = sys;
	}
	public String getDt_txt() {
		return dt_txt;
	}
	public void setDt_txt(String dt_txt) {
		this.dt_txt = dt_txt;
	}
}
