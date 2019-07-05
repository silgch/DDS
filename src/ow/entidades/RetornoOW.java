package ow.entidades;

import java.util.ArrayList;

public class RetornoOW {
	
	ArrayList<ClimaCiudad> climaCiudad = new ArrayList<ClimaCiudad>();
	ArrayList<OWError> errores = new ArrayList<OWError>();
	
	public ArrayList<ClimaCiudad> getClimaCiudad() {
		return climaCiudad;
	}
	public void setClimaCiudad(ArrayList<ClimaCiudad> climaCiudad) {
		this.climaCiudad = climaCiudad;
	}
	public ArrayList<OWError> getErrores() {
		return errores;
	}
	public void setErrores(ArrayList<OWError> errores) {
		this.errores = errores;
	}
	

}
