package climaAPI.accuWheather;

public class AWError {

	private String Code;
	private String Message;
	private String Reference;
	
	public AWError(){}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public String getReference() {
		return Reference;
	}

	public void setReference(String reference) {
		Reference = reference;
	}
	
}
