

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import repositorio.Repositorio;
import spark.Request;

public class Fachada {

	private static final String PERSISTENCE_UNIT_NAME = "DDS";
	private static EntityManagerFactory emFactory;	
	private static Repositorio repositorio;	
	private static EntityManager entityManager;
	
	
	public static void main(String[] args) throws Exception {
		
		emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		entityManager = emFactory.createEntityManager();
		repositorio = new Repositorio(entityManager);
		
		while(emFactory.isOpen()){};
		
		repositorio.cerrar();
		emFactory.close();
	}

	/*
	public boolean loginExitoso(String username, String pass) {
		 Query query = (entityManager).createQuery("SELECT COUNT(*) FROM usuario" 
				 								+"WHERE nombreDeUsuario = '" + username
				 								+"' and password = '"+ pass + "'" );
		 int result = (int) query.getSingleResult();
	     return (result == 1);
	}
	}*/
	
	public boolean loginExitoso(String username, String pass) {
		 Query query = (entityManager).createQuery("SELECT COUNT(*) FROM usuario" 
				 								+"WHERE nombreDeUsuario = '" + username
				 								+"' and password = '"+ pass + "'" );
		 int result = (int) query.getSingleResult();
	     return (result == 1);
	}
	
    public List<String> getAllFromDB() {
        return entityManager.createQuery("SELECT nombre AS 'Listado De Guardarropas' FROM guardarropa").getResultList();
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
