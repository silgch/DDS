package ow.entidades;

import java.util.ArrayList;
import java.util.List;

public class ClimaCiudad {
	
	private String cod;
	private float message;
	private int cnt;
	private List<Datos> list= new ArrayList<Datos>();
	private Ciudad city;
	
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public float getMessage() {
		return message;
	}
	public void setMessage(float message) {
		this.message = message;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public List<Datos> getList() {
		return list;
	}
	public void setList(List<Datos> list) {
		this.list = list;
	}
	public Ciudad getCity() {
		return city;
	}
	public void setCity(Ciudad city) {
		this.city = city;
	}
}
