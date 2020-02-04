package excepciones;

public class NoConexionApiException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	private String mensaje;
	
	public NoConexionApiException(String unError) {
		mensaje =unError;
	}
	
	public String toString() {
		return "NoConexionApiException: fallo la conexion con la api [" + mensaje + "]";
	}
	
}
