package notificador;

import usuario.Usuario;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;

public interface INotificador{
	
	Usuario notificado= null;
	String mail = notificado.getMail();
	Message prepareMessage(Session sesion, String account, String receptor) throws AddressException, MessagingException;
	void enviarMail(String receptor) throws AddressException, MessagingException;
}
