package Email;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class pruebaEnvioMail {

	public static void main(String[] args) throws AddressException, MessagingException {
		// TODO Auto-generated method stub

		JavaUtilMail.enviarMail("acaponerelmailreceptoraenviarelmensaje@sarasamail.com");
		
	}

}
