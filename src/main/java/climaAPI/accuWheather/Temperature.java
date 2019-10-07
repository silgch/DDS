package climaAPI.accuWheather;

public class Temperature {

	private PuntoTemperatura Minimum;
	private PuntoTemperatura Maximum;
	
	public Temperature(){}

	public PuntoTemperatura getMinimum() {
		return Minimum;
	}

	public void setMinimum(PuntoTemperatura minimum) {
		Minimum = minimum;
	}

	public PuntoTemperatura getMaximum() {
		return Maximum;
	}

	public void setMaximum(PuntoTemperatura maximum) {
		Maximum = maximum;
	}
	
	
	
}
