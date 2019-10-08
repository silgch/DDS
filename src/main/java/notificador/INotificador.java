package notificador;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import eventos.CommandParaEventos;
import usuario.Usuario;

public interface INotificador{
	
	void enviarMail() throws AddressException, MessagingException;
	void notificaSiHayEventoHoy(Usuario u,CommandParaEventos cdes) throws AddressException, MessagingException; 
}
