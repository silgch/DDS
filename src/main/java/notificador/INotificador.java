package notificador;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface INotificador{
	
	void enviarMail() throws AddressException, MessagingException;
	//void setNotificado(Usuario usuario); 
}
