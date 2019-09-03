package aw.entidades;

import java.util.ArrayList;

public class RetornoAW {

	ArrayList<ClimaCiudad> climaCiudad = new ArrayList<ClimaCiudad>();
	ArrayList<AWError> errores = new ArrayList<AWError>();
	
	public RetornoAW(){}

	public ArrayList<ClimaCiudad> getClimaCiudad() {
		return climaCiudad;
	}

	public void setClimaCiudad(ArrayList<ClimaCiudad> climaCiudad) {
		this.climaCiudad = climaCiudad;
	}

	public ArrayList<AWError> getErrores() {
		return errores;
	}

	public void setErrores(ArrayList<AWError> errores) {
		this.errores = errores;
	}
	
	
	
}
