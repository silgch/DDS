package notificador;

import usuario.Usuario;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface INotificador{
	
	Usuario notificado= null;
	String mail = notificado.getMail();
	void enviarMail() throws AddressException, MessagingException;
}
