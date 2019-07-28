package Email;

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

public class JavaUtilMail {
	public static void enviarMail(String receptor) throws AddressException, MessagingException {
		
		System.out.println("Preparando todo para envio de email");
		
		Properties propiedades = new Properties();
		
		propiedades.put("mail.smtp.auth", "true");
		propiedades.put("mail.smtp.starttls.enable", "true");
		propiedades.put("mail.smtp.host", "smtp.gmail.com");
		propiedades.put("mail.smtp.port", "587");
		
		String account ="pruebaparaenviodemaildds@gmail.com";
		String password="apalapepa99";
		
		Session sesion = Session.getInstance(propiedades, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(account,password);
			}
		});
		
		Message mensaje = prepareMessage(sesion,account,receptor);
		
		Transport.send(mensaje);
		System.out.println("Mail enviado satisfactoriamente");
	}
	
	private static Message prepareMessage(Session sesion, String account, String receptor) throws AddressException, MessagingException {
		try {
			Message mensaje = new MimeMessage(sesion);
			mensaje.setFrom(new InternetAddress(account));
			mensaje.setRecipient(Message.RecipientType.TO, new InternetAddress(receptor));
			mensaje.setSubject("Esto es un titulo sarasa para el email");
			//mensaje.setText("ola k tul");
			String htmlCode="<h1> holaaaa </h1><br> <h2><b>que tullll</b></h2>";
			mensaje.setContent(htmlCode,"text/html");
			return mensaje;
		}
		catch(Exception e) {
			System.out.println("Hubo un inconveniente a la hora de enviar mail: "+e);
		}
		
		return null;
	}
}
