package ow.entidades;

public class Ciudad {

	private long id;
	private String name;
	private Coordenadas coord;
	private String country;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Coordenadas getCoord() {
		return coord;
	}
	public void setCoord(Coordenadas coord) {
		this.coord = coord;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
