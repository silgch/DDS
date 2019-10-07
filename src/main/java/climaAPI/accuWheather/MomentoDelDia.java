package climaAPI.accuWheather;

public class MomentoDelDia {
	
	private int Icon;
	private String IconPhrase;
	private boolean HasPrecipitation;
	
	public MomentoDelDia(){}

	public int getIcon() {
		return Icon;
	}

	public void setIcon(int icon) {
		Icon = icon;
	}

	public String getIconPhrase() {
		return IconPhrase;
	}

	public void setIconPhrase(String iconPhrase) {
		IconPhrase = iconPhrase;
	}

	public boolean isHasPrecipitation() {
		return HasPrecipitation;
	}

	public void setHasPrecipitation(boolean hasPrecipitation) {
		HasPrecipitation = hasPrecipitation;
	}
	
	
	
}
