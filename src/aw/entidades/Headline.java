package aw.entidades;

public class Headline {

	private String EffectiveDate;
	private String EffectiveEpochDate;
	private int Severity;
	private String Text;
	private String Category;
	private String EndDate;
	private double EndEpochDate;
	private String MobileLink;
	private String Link;
	
	public Headline(){}
	
	public String getEffectiveDate() {
		return EffectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		EffectiveDate = effectiveDate;
	}
	public String getEffectiveEpochDate() {
		return EffectiveEpochDate;
	}
	public void setEffectiveEpochDate(String effectiveEpochDate) {
		EffectiveEpochDate = effectiveEpochDate;
	}
	public int getSeverity() {
		return Severity;
	}
	public void setSeverity(int severity) {
		Severity = severity;
	}
	public String getText() {
		return Text;
	}
	public void setText(String text) {
		Text = text;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getEndDate() {
		return EndDate;
	}
	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
	public double getEndEpochDate() {
		return EndEpochDate;
	}
	public void setEndEpochDate(double endEpochDate) {
		EndEpochDate = endEpochDate;
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
