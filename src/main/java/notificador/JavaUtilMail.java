package notificador;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import eventos.CommandParaEventos;
import eventos.Evento;
import usuario.Usuario;

public class JavaUtilMail implements INotificador{
	
	private String mailDestino;
	
	public JavaUtilMail(Usuario usuario){ 
		this.mailDestino = usuario.getMail();}
	
	public void enviarMail() throws AddressException, MessagingException {
	
	System.out.println("Preparando todo para envio de email ...");
	
	Properties propiedades = new Properties();
	
	propiedades.put("mail.smtp.auth", "true");
	propiedades.put("mail.smtp.starttls.enable", "true");
	propiedades.put("mail.smtp.host", "smtp.gmail.com");
	propiedades.put("mail.smtp.port", "587");
	
	String mailOrigen ="pruebaparaenviodemaildds@gmail.com";
	String password="apalapepa99";
	
	Session sesion = Session.getInstance(propiedades, new Authenticator() {
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(mailOrigen,password);
		}
	});
	
	Message mensaje = prepareMessage(sesion,mailOrigen,mailDestino);
	
	Transport.send(mensaje);
	System.out.println("Mail enviado satisfactoriamente");
}
	
	public Message prepareMessage(Session sesion, String account, String receptor) throws AddressException, MessagingException {
		try {
			Message mensaje = new MimeMessage(sesion);
			mensaje.setFrom(new InternetAddress(account));
			mensaje.setRecipient(Message.RecipientType.TO, new InternetAddress(receptor));
			mensaje.setSubject("Esto es un titulo sarasa para el email");
			//mensaje.setText("ola k tul");
			String htmlCode="<h1> Acordate que tenes un evento!! </h1><br> <h2><b>(subtitulo vacio)</b></h2>";
			mensaje.setContent(htmlCode,"text/html");
			return mensaje;
		}
		catch(Exception e) {
			System.out.println("Hubo un inconveniente a la hora de enviar mail: "+e);
		}
		return null;
	}	
		
	@Override	
	public void notificaSiHayEventoHoy(Usuario usuario,CommandParaEventos managerDeEventos) throws AddressException, MessagingException{
		for (Evento evento : managerDeEventos.getColaEventosActivos()) {
			if(evento.getFechaEvento().compareTo(LocalDate.now()) == 0)
				this.enviarMail();
			}
		}
		
		
		

	
	


}
