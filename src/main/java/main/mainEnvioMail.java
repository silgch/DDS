package main;

import notificador.JavaUtilMail;
import usuario.Usuario;

public class mainEnvioMail{

	public class mainPruebasEnvioMail {
		public void main(String[] args) throws Exception{
			
		Usuario ines;
		ines = new Usuario("Ines");
		ines.setMail("micoluccileandro@gmail.com");
		
		System.out.println("Se creo el usuario");
		
		JavaUtilMail notificador = new JavaUtilMail(ines);
		
		notificador.enviarMail();		
	}
}	

}
