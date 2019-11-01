

import javax.persistence.EntityManager;
import javax.persistence.Query;

import spark.Request;

public class Fachada {
	public boolean loginExitoso(EntityManager entitymanager, String username, String pass) {
		 Query query = entitymanager.createQuery("SELECT COUNT(*) FROM usuario" 
				 								+"WHERE nombreDeUsuario = '" + username
				 								+"' and password = '"+ pass + "'" );
		 int result = (int) query.getSingleResult();
	     return (result == 1);
	}
	
    boolean removeSessionAttrLoggedOut(Request _request) {
        Object loggedOut = _request.session().attribute("loggedOut");
        _request.session().removeAttribute("loggedOut");
        return loggedOut != null;
    }

    public static String removeSessionAttrLoginRedirect(Request _request) {
        String loginRedirect = _request.session().attribute("loginRedirect");
        _request.session().removeAttribute("loginRedirect");
        return loginRedirect;
    }
}
