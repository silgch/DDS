package Excepciones;

public class NoConexionApiException extends Exception{
	
	private String mensaje;
	
	public NoConexionApiException(String unError) {
		mensaje =unError;
	}
	
	public String toString() {
		return "NoConexionApiException: fallo la conexion con la api [" + mensaje + "]";
	}
	
}
